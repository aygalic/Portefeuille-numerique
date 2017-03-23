package jdbc.complex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class CommentDAO extends AbstractDAO {
	
	
	public ArrayList<Comment> getUserComment(User u) throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String l = u.getLogin();
		String id, content;
		Date date;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
	   // Result set get the result of the SQL query
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `comments` WHERE login= ?;");
		preparedStatement.setString(1, u.getLogin());

		while (resultSet.next()) {
			   id = resultSet.getString("id");
			   content = resultSet.getString("COMMENTS");
			   date= new Date(resultSet.getString("DATUM"));
			   retour.add(new Comment(id,content,date));	
		   }
		preparedStatement.close();
		getConnection().close();
	   return retour;	
	}
	
	public ArrayList<Comment> getAllComment() throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String id, content;
		Date date;
		ResultSet resultSet = null;
		Statement statement = null;
		statement = getConnection().createStatement();
	   // Result set get the result of the SQL query
		resultSet = statement.executeQuery("SELECT * FROM `comments`");
		while (resultSet.next()) {
			   id = resultSet.getString("id");
			   content = resultSet.getString("COMMENTS");
			   date= new Date(resultSet.getString("DATUM"));
			   retour.add(new Comment(id,content,date));	
		   }
		statement.close();
		getConnection().close();
	   return retour;	
	}
	public ArrayList<Comment> getAllCommentFrom(Date d) throws SQLException{
		ArrayList<Comment> retour= new ArrayList();
		String id, content;
		Date date;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
	   // Result set get the result of the SQL query
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `comments` WHERE DATUM > ?;");
		preparedStatement.setString(1, d.toString());
		while (resultSet.next()) {
			   id = resultSet.getString("id");
			   content = resultSet.getString("COMMENTS");
			   date= new Date(resultSet.getString("DATUM"));
			   retour.add(new Comment(id,content,date));	
		   }
		preparedStatement.close();
		getConnection().close();
	   return retour;	
	}
	public void insertComment(Comment c) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("INSERT INTO `feedback`.`comments` (`MYUSER`, `COMMENTS`, `DATUM`) VALUES (?,?,?);");
	   // Result set get the result of the SQL query
		preparedStatement.setString(1, c.getId());
		preparedStatement.setString(2, c.getContent());
		//source derreur probable
		preparedStatement.setString(3, c.getDate().toString());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();

	}
	public void deleteComment(Comment c) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("DELETE FROM `feedback`.`comment` WHERE `comments`.`id` = ?");
	   // Result set get the result of the SQL query
		preparedStatement.setString(1, c.getId());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();
	}
}
