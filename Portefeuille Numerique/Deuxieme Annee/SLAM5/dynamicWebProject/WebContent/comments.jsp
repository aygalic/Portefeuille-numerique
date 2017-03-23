<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jdbc.complex.*"%>
<%session = request.getSession(); %>
<%--

	Page affichant tout les commentaires, permettant d'en ajouter des nouveau et d'en supprimer

 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Commentaires</h1>
	<%
	//initialisation
		Services s = new Services();
	//appel de la methode
		ArrayList<Comment> comments = s.recupererTousLesComentaires();
	//affichage
		for(Comment c : comments){
			out.println(c.getId()+" "+c.getContent()+" le : "+c.getDate()+" de :"+c.getLogin());  
			out.println("<form method='POST' action='Controler?action=deleteComment&toDelete="+c.getId()+"'>");
			out.println("<input type='submit' class='btn btn-primary' value='Suprimer'>");
			
			out.println("</form><br>");
		
		}
	%>
	<h2>ajouter un commentaire</h2>
	<form method="POST" action="Controler?action=addComment">
		<div class="form-group">
			<label for="exampleInputPassword1">commentaire : </label> <input
				class="form-control" name="commentInput">
		</div>
		<input type="submit" class="btn btn-primary" value="submit">
	</form>
</body>
</html>