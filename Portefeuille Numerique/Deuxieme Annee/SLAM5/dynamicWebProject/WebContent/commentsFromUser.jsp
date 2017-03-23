<%@page import="jdbc.complex.Comment"%>
<%@page import="jdbc.complex.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdbc.complex.Services"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session = request.getSession();
%>
<%-- 

Page permettant d'afficher tout les commentaires d'un utilisateur passé en paramettre
on peu aussi supprimer les utilisateurs 

 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	//initialisation
		Services s = new Services();
	//recupération de l'utilisateur passé en paramettre 
		User u = new User(request.getParameter("user"), "", "");
	//appel de la fonction
		ArrayList<Comment> comments = s.recupererCommentairesUtilisateur(u);
	//affichage
		for (Comment c : comments) {
			out.println(c.getId() + " " + c.getContent() + " le : " + c.getDate() + " de :" + c.getLogin());
			out.println("<form method='POST' action='Controler?action=deleteComment&toDelete=" + c.getId() + "'>");
			out.println("<input type='submit' class='btn btn-primary' value='Suprimer'>");
			out.println("</form><br>");
		}
	%>
</body>
</html>