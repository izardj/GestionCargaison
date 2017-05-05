package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROUTIERE")
public class CargaisonRoutiere extends Cargaison {

	private static final long serialVersionUID = 1L;
	private double temperatureConservation;

	public double getTemperatureConservation() {
		return temperatureConservation;
	}

	public void setTemperatureConservation(double temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
}
