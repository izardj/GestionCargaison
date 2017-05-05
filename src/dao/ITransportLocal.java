package dao;

import java.util.List;

import javax.ejb.Local;

import metier.Cargaison;
import metier.Marchandise;

@Local
public interface ITransportLocal {

	public void addCargaison(Cargaison c);

	public void addMarchandise(Marchandise m, long refCargaison);

	public List<Cargaison> getAllCargaisons();

	public List<Marchandise> getMarchandisesParMC(String mc);

	public void deleteMarchandise(long refMarchandise);
}
