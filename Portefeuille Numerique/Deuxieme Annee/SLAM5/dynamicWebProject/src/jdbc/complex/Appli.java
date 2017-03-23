package jdbc.complex;

import java.sql.SQLException;
import java.util.Date;

public class Appli {
	public static void main(String[] args) throws SQLException{
		Services s = new Services();
		User u = new User("login17", "nom", "password");
		Date d= new Date();
		Comment c = new Comment(u.getLogin(), "commentaire a retrouver", d);
		System.out.println(c.toString());
		//s.ajouterUtilisateur(u);
		s.ajouterCommentaire(c);
		UserDAO udao = new UserDAO();
		
		System.out.println(udao.getUserByLogin("loginfake").getLogin());
		
		
		
		User u2 =s.verifierConnexion(u.getLogin(),u.getPassword());
		if(u2!=null){
			String passU = u2.getPassword();
			if(passU.equals(u.getPassword())){
				System.out.println("login successfull");
			}	
		}

		
		else{
			System.out.println("login failed");
		}
		
		
		
		/**
		 * Test de la fonction verifierConnextion()
		 */
		User u3 =s.verifierConnexion("dslkldfg","fgdfkgdfg");
		if(u3!=null){
			String passU3 = u3.getPassword();
			if(passU3.equals(u.getPassword())){
				System.out.println("login successfull");
			}
		}
		else{
			System.out.println("login failed");
		}
		
		
		
		
		for(Comment cs : s.recupererCommentairesUtilisateur(u)){
			System.out.println(cs.getContent());
		}
		
		for(Comment cs : s.recupererTousLesComentaires()){
			System.out.println(cs.getContent());
		}
		for(User us : s.recupererTousLesUtilisateurs()){
			System.out.println(us.getLogin());
		}
		//focntionne uniquement si le commentaire passé en parametre contien un ID
		s.supprimerCommentaire(c);
		
		//s.suppimerUtilisateur(u);
		

		for(Comment cs : s.recuprerTousLesCommentairesAPartir(new Date(d.getTime()-10000000l))){
			System.out.println(cs.getContent());
		}
	}
}
