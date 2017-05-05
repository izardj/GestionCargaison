package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Cargaison;
import metier.Marchandise;

/**
 * Session Bean implementation class Transport
 */
@Stateless
public class Transport implements ITransportRemote, ITransportLocal {

	@PersistenceContext(name="cargaison-pu")
	private EntityManager em;
	
	@Override
	public void addCargaison(Cargaison c) {
		em.persist(c);		
	}

	@Override
	public void addMarchandise(Marchandise m, long refCargaison) {
		Cargaison c = em.find(Cargaison.class, refCargaison);
		
		List<Marchandise> lm = c.getMarchandises();
		lm.add(m);
		c.setMarchandises(lm);
		m.setCargaison(c);
		em.persist(m);		
	}

	@Override
	public List<Cargaison> getAllCargaisons() {
		return em.createQuery("SELECT c FROM Cargaison c").getResultList();
	}

	@Override
	public List<Marchandise> getMarchandisesParMC(String mc) {
		Query q = em.createQuery("SELECT m FROM Marchandise m WHERE m.nom LIKE :mc");
		q.setParameter("mc", "%" + mc + "%");
		return q.getResultList();
	}

	@Override
	public void deleteMarchandise(long refMarchandise) {
		em.remove(em.find(Marchandise.class, refMarchandise));		
	}

}
