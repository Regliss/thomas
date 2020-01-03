package ExempleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Article;

public class DAOArticleImpl implements DAOArticle {
	private Connection connection;

	public DAOArticleImpl(Connection connection) {
		this.connection = connection;

}

	@Override
	public Article getArticle(int id) {
		Article article = new Article();
		try {
			String query = "SELECT * FROM article WHERE id=?;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == false) {
				return null;
			} else {
				do {
					article.setId(rs.getInt("id"));
					article.setAuteur(rs.getString("auteur"));
					article.setTitre(rs.getString("titre"));
					article.setDescription(rs.getString("description"));
					article.setTexte(rs.getString("texte"));
					article.setDate(rs.getString("date"));
				} while (rs.next());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticle() {
		List<Article> article = new ArrayList<Article>();
		
		try {
			String query = "SELECT * FROM article;";	
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Article art = new Article();
				
				art.setId(rs.getInt("id"));
				art.setAuteur(rs.getString("auteur"));
				art.setTitre(rs.getString("titre"));
				art.setDescription(rs.getString("description"));
				art.setTexte(rs.getString("texte"));
				
				((List<Article>) art).add(art);	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return article;

	}

	@Override
	public void addArticle(Article article) {
		try {
			String query = "INSERT INTO (auteur, titre, description, texte, date) VALUES (?,?,?,?,?)";
			String generatedColumns[]= {"ID"};
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);
			ps.setString(1,  article.getAuteur());
			ps.setString(1,  article.getTitre());
			ps.setString(1,  article.getDescription());
			ps.setString(1,  article.getTexte());
			ps.setString(1, article.getDate());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				article.setId(rs.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateArticle(Article article) {
		try {
			String query = "UPDATE article SET auteur=?, titre=?, description=?, texte=?, date=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,  article.getAuteur());
			ps.setString(2,  article.getTitre());
			ps.setString(3,  article.getDescription());
			ps.setString(4,  article.getTexte());
			ps.setString(5,  article.getDate());
			ps.setInt(6,  article.getId());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteArticle(Article article) {
		try {
			String query = "DELETE FROm article WHERE id=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,  article.getId());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	}

