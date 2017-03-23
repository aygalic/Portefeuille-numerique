package jdbc.complex;

import java.sql.SQLException;
import java.util.Date;

public class Appli {
	public static void main(String[] args) throws SQLException{
		Services s = new Services();
		User u = new User("login4", "nom", "password");
		Date d= new Date();
		Comment c = new Comment("id", "ccontent", d);
		s.ajouterUtilisateur(u);
		s.ajouterCommentaire(c);
	}
}
