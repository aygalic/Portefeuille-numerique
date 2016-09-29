package jdbc.complex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private Connection connect = null;
	private ResultSet resultSet = null;
	public Connection getConnection(){
		// This will load the MySQL driver, each DB has its own driver
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Setup the connection with the DB
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
				          + "user=sqluser&password=sqluserpw");
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
		

	}
	public void closeConnection(){
		try {
		      if (resultSet != null) {
		        resultSet.close();
		      }
		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {

		    }
	}
}
