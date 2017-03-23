<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jdbc.complex.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdbc.complex.Services"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session = request.getSession();
%>

<%-- 


Cette page affiche les commentaires a partir d'une date passée en paramettre 
On peut aussi les supprimer

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
		//recutpération de la date
		String date = request.getParameter("date");
		//vérification du format
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = formatter.parse(date);
			//appel de la fonction
			ArrayList<Comment> comments = s.recuprerTousLesCommentairesAPartir(d);
			//affichage
			for (Comment c : comments) {
				out.println(c.getId() + " " + c.getContent() + " le : " + c.getDate() + " de :" + c.getLogin());
				out.println(
						"<form method='POST' action='Controler?action=deleteComment&toDelete=" + c.getId() + "'>");
				out.println("<input type='submit' class='btn btn-primary' value='Suprimer'>");
				out.println("</form><br>");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>