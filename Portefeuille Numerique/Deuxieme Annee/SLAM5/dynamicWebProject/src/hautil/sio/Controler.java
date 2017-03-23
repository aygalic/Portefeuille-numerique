package hautil.sio;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jdbc.complex.*;
/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controler() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/**
			 * délégation du traitement à une fonction
			 */
			traitement(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			traitement(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * redirige l'utilisateur vers la bonne page en fonction de la pertinance des informations saisies
	 * C'est ici que le comportement du controlleur est définit 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		String action =  request.getParameter("action");
		String login, pass, nom, comment;
		int id;
		Services s;
		User u;
		Comment c;
		/**
		 * Switch dispatchant les requettes et redirigeant l'utilisateur dans sa navigation
		 */
		switch (action) {
		/**
		 * identification sur la page d'acceuil
		 */
		case "login":
			login = request.getParameter("mailInput");
			pass = request.getParameter("passInput");
			s = new Services();
			u = s.verifierConnexion(login, pass);
			if(u!=null){
				String passU = u.getPassword();
				if(passU.equals(u.getPassword())){
					dispatcher=request.getRequestDispatcher("menu.jsp");
					session.setAttribute("login", login );
					dispatcher.forward(request, response);
				}
			}
			else{
				System.out.println("log client failed");
			}	
			break;
			/**
			 * redirection vers la page affichant la gestion d'utilisateur
			 */
		case "users":
			dispatcher=request.getRequestDispatcher("users.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * redirection vers la page affichant la gestion des commentaires
			 */
		case "comments":
			dispatcher=request.getRequestDispatcher("comments.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * ajout de commentaire
			 */
		case "addComment":
			comment = request.getParameter("commentInput");
			s = new Services();	
			c = new Comment(session.getAttribute("login").toString(), comment, new Date());
			s.ajouterCommentaire(c);
			System.out.println("commentaire ajouté");
			dispatcher=request.getRequestDispatcher("comments.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * ajout d'utilisateur
			 */
		case "addUser":
			login = request.getParameter("loginInput");
			nom = request.getParameter("nomInput");
			pass = request.getParameter("passInput");
			u= new User(login, nom, pass);
			s = new Services();
			s.ajouterUtilisateur(u);
			System.out.println("utilisateur ajouté");
			dispatcher=request.getRequestDispatcher("users.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * suppression d'utilisateur
			 */
		case "deleteUser":
			login = request.getParameter("toDelete");
			s = new Services();
			s.suppimerUtilisateur(new User(login,"",""));
			System.out.println("utilisateur supprimé");
			dispatcher=request.getRequestDispatcher("users.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * suppression de commentaire
			 */
		case "deleteComment":
			id = new Integer(request.getParameter("toDelete"));
			s = new Services();
			s.supprimerCommentaire(new Comment(id, "", "", new Date()));
			System.out.println("Commentaire supprimé");
			dispatcher=request.getRequestDispatcher("comments.jsp");
			dispatcher.forward(request, response);
			break;
			/**
			 * redirection et passage de paramettre pour l'affichage des commentaires à partir d'une date
			 */
		case "getCommentFromDate":
			String date = request.getParameter("date");
			dispatcher=request.getRequestDispatcher("commentsFromDate.jsp?date="+date);
			dispatcher.forward(request, response);	
			break;
			/**
			 * redirection et passage de paramettre pour l'affichage des commentaires d'un utilisateur précis
			 */
		case "getCommentFromUser":
			String user = request.getParameter("user");
			dispatcher=request.getRequestDispatcher("commentsFromUser.jsp?user="+user);
			dispatcher.forward(request, response);	
			break;
			/**
			 * en cas de mauvaise requette l'utilisateur sera redirigé vers l'acceuil. Cela ne devrait pas arriver
			 */
		default:
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}
}
