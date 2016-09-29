package jdbc.complex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO extends AbstractDAO{
	public User getUserByLogin(String s) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `user` WHERE login= ?;");
		preparedStatement.setString(1, s);
	   String login = resultSet.getString("login");
	   String nom = resultSet.getString("nom");
	   String password= resultSet.getString("password");
	   preparedStatement.close();
		getConnection().close();
	   return(new User(login,nom,password));	
	}
	
	public ArrayList<User> getAllUser() throws SQLException{
		ArrayList<User> retour= new ArrayList();
		String login, nom, password;
		ResultSet resultSet = null;
		Statement statement = null;
		statement = getConnection().createStatement();
	   // Result set get the result of the SQL query
		resultSet = statement.executeQuery("SELECT * FROM `user`");
	   while (resultSet.next()) {
		   login = resultSet.getString("login");
		   nom = resultSet.getString("nom");
		   password= resultSet.getString("password");
		   retour.add(new User(login,nom,password));	
	   }
	   statement.close();
		getConnection().close();
	   return retour;
	}
	public void insertUser(User u) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("INSERT INTO `feedback`.`user` (`login`, `nom`, `password`) VALUES (?,?,?);");
	   // Result set get the result of the SQL query
		preparedStatement.setString(1, u.getLogin());
		preparedStatement.setString(2, u.getNom());
		preparedStatement.setString(3, u.getPassword());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();

	}
	public void deleteUser(User u) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("DELETE FROM `feedback`.`user` WHERE `user`.`login` = ?");
	   // Result set get the result of the SQL query
		preparedStatement.setString(1, u.getLogin());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();
	}
	
	
	
}
