public class Terre {
	
	public static void main(String[] args) {
		Jardin j = new Jardin(5,5);
		j.ajouterPanier("Carotte",5);
		j.ajouterPanier("Tomate",5);
		j.ajouterPanier("Ail",10);
		j.ajouterPanier("Betrave",5);
		System.out.println(j.toString());
		j.gerer();
	}
	
	
}
