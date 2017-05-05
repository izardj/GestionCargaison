package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.ITransportLocal;
import metier.Cargaison;
import metier.Marchandise;

/**
 * Session Bean implementation class TransportSOAPService
 */
@WebService(serviceName = "Transport")
@Stateless
public class TransportSOAPService implements TransportSOAPServiceRemote, TransportSOAPServiceLocal {

	@EJB
	private ITransportLocal dao;
	
	@WebMethod
	@Override
	public void addCargaison(@WebParam(name="cargaison") Cargaison c) {
		dao.addCargaison(c);
	}

	@WebMethod
	@Override
	public void addMarchandise(@WebParam(name="marchandise") Marchandise m, @WebParam(name="refCargaison") long refCargaison) {
		dao.addMarchandise(m, refCargaison);		
	}

	@WebMethod
	@Override
	public List<Cargaison> getAllCargaisons() {
		return dao.getAllCargaisons();
	}

	@Override
	public List<Marchandise> getMarchandisesParMC(@WebParam(name="mc") String mc) {
		return dao.getMarchandisesParMC(mc);
	}

	@Override
	public void deleteMarchandise(@WebParam(name="refMarchandise") long refMarchandise) {
		dao.deleteMarchandise(refMarchandise);		
	}

}
