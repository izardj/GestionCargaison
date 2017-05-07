package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ITransportLocal;
import dao.Transport;
import metier.Cargaison;
import metier.CargaisonAerienne;
import metier.CargaisonRoutiere;

@Path("/transport")
@Stateless
public class TransportRESTService {

	@EJB
	private ITransportLocal dao;

	@POST
	@Path("/cargaisons/routiere/{distance}/{temp}")
	public void addCargaisonRoutiere(@PathParam("distance") int distance, @PathParam("temp") int t) {
		CargaisonRoutiere c = new CargaisonRoutiere();
		c.setDistance(distance);
		c.setTemperatureConservation(t);
		dao.addCargaison(c);
	}

	@POST
	@Path("/cargaisons/aerienne/{distance}/{temp}")
	public void addCargaisonAerienne(@PathParam("distance") int distance, @PathParam("pds") int p) {
		CargaisonAerienne c = new CargaisonAerienne();
		c.setDistance(distance);
		c.setPoidsMax(p);;
		dao.addCargaison(c);
	}
	
	/*
	 * public void addMarchandise(Marchandise m, long refCargaison){
	 * 
	 * }
	 */
	@GET
	@Path("/cargaisons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> getAllCargaisons() {
		return dao.getAllCargaisons();
	}
	/*
	 * public List<Marchandise> getMarchandisesParMC(String mc){
	 * 
	 * }
	 * 
	 * public void deleteMarchandise(long refMarchandise){
	 * 
	 * }
	 */
}
