package jdbc.complex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO extends AbstractDAO{
	/**
	 * @param s le login de l'utilisateur qu'on cherche a retourné
	 * @return un utilisateur si il existe, n utilisateurs au atribus null autrement
	 * @throws SQLException
	 */
	public User getUserByLogin(String s) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		preparedStatement = getConnection().prepareStatement("SELECT * FROM `user` WHERE login= ?;");
		preparedStatement.setString(1, s);
		resultSet=preparedStatement.executeQuery();
		String login=null, nom=null, password=null;
		//parcours tout les retours afin de creer des objets User et les stocker dans l'arrayList de retour
		while (resultSet.next()) {
			login = resultSet.getString("login");
			nom = resultSet.getString("nom");
			password= resultSet.getString("password");
			System.out.println(login+" "+nom+" "+password);
		}	
		preparedStatement.close();
		getConnection().close();
		return(new User(login,nom,password));	
	}
	/**
	 * 
	 * @return retour tout les utilisateurs
	 * @throws SQLException
	 */
	public ArrayList<User> getAllUser() throws SQLException{
		ArrayList<User> retour= new ArrayList();
		String login, nom, password;
		ResultSet resultSet = null;
		Statement statement = null;
		statement = getConnection().createStatement();
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery("SELECT * FROM `user`");
		//parcours tout les retours afin de creer des objets User et les stocker dans l'arrayList de retour
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
	/**
	 * 
	 * @param u l'utilisateur a inserer dans la base de donnée
	 * @throws SQLException
	 */
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
	/**
	 * 
	 * @param u l'utilisateur a supprimer 
	 * @throws SQLException
	 */
	public void deleteUser(User u) throws SQLException{
		PreparedStatement preparedStatement = null;
		preparedStatement = getConnection().prepareStatement("DELETE FROM `feedback`.`user` WHERE `user`.`login` = ?");
		preparedStatement.setString(1, u.getLogin());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		getConnection().close();
	}



}
