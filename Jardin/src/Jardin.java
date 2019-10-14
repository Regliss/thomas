import java.util.HashMap;
import java.util.Scanner;

import Flore.Ail;
import Flore.Bettrave;
import Flore.Carotte;
import Flore.Tomate;

public class Jardin {
	// attributs
	private int largeur;
	// visibilité-type-nom
	private int longueur;
	private Emplacement emplacement[][];
	private HashMap<String, Integer> panier;

	// constructeurs
	public Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		emplacement = new Emplacement[this.longueur][this.largeur];
	}

	// méthodes
	public void ajouterPanier(String nameVeg, int quant) {
		this.panier.put(nameVeg, quant);
	}

	@Override
	public String toString() {
		String str = "Voici notre jardin : \n";		
		
		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e == null) {
					str += "o";
				} else {
					str += "_";
				}
			}
			str += "\n";
		}
		
		
		return str;
	}
	// Partie 8
	
	public void gerer(){
	Scanner scanner = new Scanner(System.in);
	
	String[] vegetals = {"Carotte", "Tomate", "Ail", "Betrave"};
	 
	System.out.println("Et notre panier contient :");
	for(String v :  vegetals)
	{
	    System.out.println(v + " : " + this.panier.get(v) + " graine(s)");
	}
	
		System.out.println("\n1 Semer une graine");
		System.out.println("2 Récolter toutes les plantes qui sont matures");
		System.out.println("3 Passer a la saison suivant");
		System.out.println("4 Quitter l'application");
		System.out.println("Quel est votre choix ? :");
		int res = scanner.nextInt(); 

		switch(res)
		{
		case 1:this.semer();break;
		case 2:
		case 3:
		case 4:
		default:
			gerer();
			break;
		}
	}
	
	public static void semer() {
		Scanner scanner = new Scanner(System.in); 
		int res = scanner.nextInt();
		this.emplacement[x][y] = new Emplacement(new Ail());
		//this.emplacement[x][y] = new Emplacement(new Carotte());
		//this.emplacement[x][y] = new Emplacement(new Bettrave());
		//this.emplacement[x][y] = new Emplacement(new Tomate());
	}
	
	public static void saisonSuivante() {
		
	}


}
