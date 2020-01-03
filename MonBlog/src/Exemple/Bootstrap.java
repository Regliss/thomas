package Exemple;

import ExempleDAO.DAOArticle;
import ExempleDAO.DAOFactory;
import Model.Article;


public class Bootstrap {
	
	public static void main(String[] args) {
		
		
		System.out.println("Lancement du programme");
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		
		System.out.println("Insertion d'un nouvelle article");
		Article newArticle = new Article();
		System.out.println(daoArticle.getArticle(1).getId());
		System.out.println(daoArticle.getArticle(1).getAuteur());
		System.out.println(daoArticle.getArticle(1).getTitre());
		System.out.println(daoArticle.getArticle(1).getDescription());
		System.out.println(daoArticle.getArticle(1).getTexte());
		System.out.println(daoArticle.getArticle(1).getDate());
		
		System.out.println("Récupération de l'article inséré et affichage");
		Article createdArticle = daoArticle.getArticle(newArticle.getId());
		System.out.println(createdArticle);
		
		System.out.println("Modification de l'adresse mail de cet utilisateur");
		createdArticle.setTexte("Nouveau texte");
		daoArticle.updateArticle(createdArticle);
		
		System.out.println("Suppression de l'article");
		Article updateArticle = daoArticle.getArticle(createdArticle.getId());
		daoArticle.deleteArticle(updateArticle);
		
		System.out.println("Affichage de tous les articles");
		for (int i = 0 ; i < daoArticle.getAllArticle().size(); i++){
            Article u = (Article) daoArticle.getAllArticle().get(i);
            
           System.out.println(u);
        }

	}
}