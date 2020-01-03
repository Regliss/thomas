package ExempleDAO;

import java.util.List;

import Model.Article;

public interface DAOArticle {
	public Article getArticle(int id);
	public List<Article> getAllArticle();
	public void addArticle(Article article);
	public void deleteArticle(Article article);
	void updateArticle(Article article);
}

