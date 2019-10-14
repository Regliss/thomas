import Flore.Vegetal;

public class Emplacement {
	private Vegetal vegetal;

	public Vegetal getVegetal() {
		return vegetal;
	}

	public void setVegetal(Vegetal vegetal) {
		this.vegetal = vegetal;
	}

	// constructeur (param�tre)
	public Emplacement(Vegetal v) {
		// initialisation attribut
		this.vegetal = v;
	}

	public String toString() {
		
		return this.vegetal.toString();

	}
}
