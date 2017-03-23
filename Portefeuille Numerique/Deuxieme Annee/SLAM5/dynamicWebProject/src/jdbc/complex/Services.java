package jdbc.complex;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Sert d'interface entre les classes DAO et l'application finale
 * @author Aygalic
 *
 */
public class Services {
	UserDAO userdao = new UserDAO();
	CommentDAO commentdao = new CommentDAO();

	/**
	 * permet de verrifier le mot de passe et le login d'un utilisateur
	 * 
	 * @param s login
	 * @param p mot de passe
	 * @return un utilisteurs si le login et le mot de passe correspondent a celui d'un utilisateur, null autrement
	 * @throws SQLException
	 */
	public User verifierConnexion(String s, String p) throws SQLException{
		User u = userdao.getUserByLogin(s);
		if(u.getLogin()!=null){
			if(u.getPassword().equals(p)){
				return u;
			}
			else{
				return null;
			}
		}

		else{
			return null;
		}
	}
	/**
	 * supprime un utilisteur de la BDD
	 * 
	 * @param u utilisateur a supprimer
	 * @throws SQLException
	 * @see deleteUser(User u)
	 */
	public void suppimerUtilisateur(User u) throws SQLException{
		userdao.deleteUser(u);
	}
	/**
	 * Supprime un commentaire de la BDD
	 * @param c Comment a supprimer
	 * @throws SQLException
	 */
	public void supprimerCommentaire(Comment c) throws SQLException{
		commentdao.deleteComment(c);
	}
	/**
	 * Recupere tout les commentaire d'un utilisateur dans la BDD
	 * @param u User dont on veut recuperer les comments
	 * @return un ArrayList de comments, peu etre vide
	 * @throws SQLException
	 */
	public ArrayList<Comment> recupererCommentairesUtilisateur(User u) throws SQLException{
		return commentdao.getUserComment(u);
	}
	/**
	 * Recupere TOUT les commentaires entrés dans la BDD
	 * @return ArrayList contenant tout les comments
	 * @throws SQLException
	 */
	public ArrayList<Comment> recupererTousLesComentaires() throws SQLException {
		return commentdao.getAllComment();
	}
	/**
	 * Renvois tout les commentaire suppérieur a d
	 * @param d date dont on retournera tout les commentaires postérieurs
	 * @return un ArrayList de comment
	 * @throws SQLException
	 */
	public ArrayList<Comment> recuprerTousLesCommentairesAPartir(Date d) throws SQLException{
		return commentdao.getAllCommentFrom(d);
	}
	/**
	 * Renvois tout les utilisateurs de la table User
	 * @return arrayList d'utilisateurs
	 * @throws SQLException
	 */
	public ArrayList<User> recupererTousLesUtilisateurs() throws SQLException {
		return userdao.getAllUser();
	}
	/**
	 * ajoute un utilisteur u a la BDD
	 * @param u User a ajouter
	 * @throws SQLException
	 */
	public void ajouterUtilisateur(User u) throws SQLException {
		userdao.insertUser(u);
	}
	/**
	 * Ajoute un commentaire c a la BDD
	 * @param c Comment a ajouter 
	 * @throws SQLException
	 */
	public void ajouterCommentaire(Comment c) throws SQLException{
		commentdao.insertComment(c);
	}

}
