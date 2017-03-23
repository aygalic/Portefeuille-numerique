package jdbc.complex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * fait le liens entre la classe Comment et la BDD 
 * @author Aygalic
 *
 */
public class CommentDAO extends AbstractDAO {

	/**
	 * Recupere tout les commentaires d'un utilisateur
	 * @param u Utilisateur dont on cherche a recuperer les commentaires
	 * @return arraylist de comments
	 * @throws SQLException
	 */
	public ArrayList<Comment> getUserComment(User u) throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String l = u.getLogin();
		String id, content;
		Date date;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		//prepare la requette SQL
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `comments` WHERE MYUSER= ?;");
		preparedStatement.setString(1, u.getLogin());
		resultSet=preparedStatement.executeQuery();
		//parcours tout les retours afin de creer des objets Comment et les stocker dans l'arrayList de retour
		while (resultSet.next()) {
			id = resultSet.getString("id");
			content = resultSet.getString("COMMENTS");
			Timestamp timestamp = resultSet.getTimestamp("DATUM"); 
			date = timestamp;
			retour.add(new Comment(new Integer(id),l,content,date));	
		}
		preparedStatement.close();
		getConnection().close();
		return retour;	
	}
	/**
	 * Recupere tout les commentaire dans la table comments
	 * @return arraylist de comments
	 * @throws SQLException
	 */
	public ArrayList<Comment> getAllComment() throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String id, content,l;
		Date date;
		ResultSet resultSet = null;
		Statement statement = null;
		statement = getConnection().createStatement();
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery("SELECT * FROM `comments`");
		//parcours tout les retours afin de creer des objets Comment et les stocker dans l'arrayList de retour
		while (resultSet.next()) {
			id = resultSet.getString("id");
			l = resultSet.getString("MYUSER");
			content = resultSet.getString("COMMENTS");
			Timestamp timestamp = resultSet.getTimestamp("DATUM"); 
			date = timestamp;
			retour.add(new Comment(new Integer(id),l,content,date));	
		}
		statement.close();
		getConnection().close();
		return retour;	
	}
	/**
	 * recupere tout les commentaire dont la date est postérieur a d
	 * @param d Date
	 * @return arraylist de commentaires
	 * @throws SQLException
	 */
	public ArrayList<Comment> getAllCommentFrom(Date d) throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String id, l, content;
		Date date;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		// Result set get the result of the SQL query
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `comments` WHERE DATUM >= ?;");
		java.sql.Date dsql = new java.sql.Date(d.getTime());
		preparedStatement.setString(1, dsql.toString());
		resultSet=preparedStatement.executeQuery();
		//parcours tout les retours afin de creer des objets Comment et les stocker dans l'arrayList de retour
		while (resultSet.next()) {
			id = resultSet.getString("id");
			l = resultSet.getString("MYUSER");
			content = resultSet.getString("COMMENTS");
			Timestamp timestamp = resultSet.getTimestamp("DATUM"); 
			date = timestamp;
			retour.add(new Comment(new Integer(id),l,content,date));	
		}
		preparedStatement.close();
		getConnection().close();
		return retour;	
	}
	/**
	 * ajoute un commentaire dans la BDD
	 * @param c Commentaire a ajouter
	 * @throws SQLException
	 */
	public void insertComment(Comment c) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("INSERT INTO `feedback`.`comments` (`MYUSER`, `COMMENTS`, `DATUM`) VALUES (?,?,?);");
		// Result set get the result of the SQL query
		preparedStatement.setString(1, c.getLogin());
		preparedStatement.setString(2, c.getContent());
		//source derreur probable
		preparedStatement.setString(3, c.getDate().toString());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();

	}
	/**
	 * Supprime un commentaire 
	 * Le commentaire DOIT ETRE DOTE DUN ID pour que la requette fonctionne
	 * @param c Comment a supprimer
	 * @throws SQLException
	 */
	public void deleteComment(Comment c) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("DELETE FROM `feedback`.`comments` WHERE `comments`.`id` = ?");
		// Result set get the result of the SQL query
		preparedStatement.setInt(1, c.getId());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();
	}
}
