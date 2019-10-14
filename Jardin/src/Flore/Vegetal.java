package Flore;

public class Vegetal {
	protected Etat etat;
	protected char dessin[];
	// Partie 6
	public Vegetal() {
		dessin=new char [6];
	//case '1' + 'caractère'
		dessin[0]='_';
		dessin[1]='.';
		dessin[2]='|';
		dessin[5]='#';
		
		etat=Etat.GRAINE;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public static void grandir() {
		
	}
}
