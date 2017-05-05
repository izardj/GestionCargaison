package metier;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("AERIENNE")
public class CargaisonAerienne extends Cargaison {

	private static final long serialVersionUID = 1L;
	private double poidsMax;

	public double getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(double poidsMax) {
		this.poidsMax = poidsMax;
	}
}
