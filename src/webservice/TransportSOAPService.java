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
public class TransportSOAPService {

	@EJB
	private ITransportLocal dao;

	@WebMethod
	public void addCargaison(@WebParam(name = "cargaison") Cargaison c) {
		dao.addCargaison(c);
	}

	@WebMethod
	public void addMarchandise(@WebParam(name = "marchandise") Marchandise m,
			@WebParam(name = "refCargaison") long refCargaison) {
		dao.addMarchandise(m, refCargaison);
	}

	@WebMethod
	public List<Cargaison> getAllCargaisons() {
		return dao.getAllCargaisons();
	}

	@WebMethod
	public List<Marchandise> getMarchandisesParMC(@WebParam(name = "mc") String mc) {
		return dao.getMarchandisesParMC(mc);
	}

	@WebMethod
	public void deleteMarchandise(@WebParam(name = "refMarchandise") long refMarchandise) {
		dao.deleteMarchandise(refMarchandise);
	}

}
