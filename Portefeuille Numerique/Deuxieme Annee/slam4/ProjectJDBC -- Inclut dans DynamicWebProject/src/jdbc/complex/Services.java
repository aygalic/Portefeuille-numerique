package jdbc.complex;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
public class Services {
	UserDAO userdao = new UserDAO();
	CommentDAO commentdao = new CommentDAO();
	public User verifierConnexion(String s, String st) throws SQLException{
		  User u = userdao.getUserByLogin(s);
		  if(u.getPassword()==st){
			  return u;
		  }
		  else{
			  return u;
		  }
		  //que fait cette methode ?
	  }
	  public void suppimerUtilisateur(User u) throws SQLException{
		  userdao.deleteUser(u);
	  }
	  public void supprimerCommentaire(Comment c) throws SQLException{
		  commentdao.deleteComment(c);
	  }
	  public ArrayList<Comment> recupererCommentairesUtilisateur(User u) throws SQLException{
		  return commentdao.getUserComment(u);
	  }
	  public ArrayList<Comment> recupererTousLesComentaires() throws SQLException {
		  return commentdao.getAllComment();
	  }
	  public ArrayList<Comment> recuprerTousLesCommentairesAPartir(Date d) throws SQLException{
		  return commentdao.getAllCommentFrom(d);
	  }
	  public ArrayList<User> recupererTousLesUtilisateurs() throws SQLException {
		  return userdao.getAllUser();
	  }
	  public void ajouterUtilisateur(User u) throws SQLException {
		  userdao.insertUser(u);
	  }
	  public void ajouterCommentaire(Comment c) throws SQLException{
		  commentdao.insertComment(c);
	  }

}
