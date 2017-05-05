package dao;

import java.util.List;

import javax.ejb.Remote;

import metier.Cargaison;
import metier.Marchandise;

@Remote
public interface ITransportRemote {

	public void addCargaison(Cargaison c);

	public void addMarchandise(Marchandise m, long refCargaison);

	public List<Cargaison> getAllCargaisons();

	public List<Marchandise> getMarchandisesParMC(String mc);

	public void deleteMarchandise(long refMarchandise);
}
