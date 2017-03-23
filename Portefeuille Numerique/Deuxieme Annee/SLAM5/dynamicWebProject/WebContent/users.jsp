<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jdbc.complex.*"%>
<%
	session = request.getSession();
%>
<%--

Page servant à l'affichage, l'ajout et la suppression des utilisateurs

 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Utilisateurs</h1>
	<%
		//initialisation
		Services s = new Services();
		//appel de la methode
		ArrayList<User> users = s.recupererTousLesUtilisateurs();
		//affichage
		for (User u : users) {
			out.println("login : " + u.getLogin() + " nom : " + u.getNom() + " mot de passe :" + u.getPassword());
			out.println("<form method='POST' action='Controler?action=deleteUser&toDelete=" + u.getLogin() + "'>");
			out.println("<input type='submit' class='btn btn-primary' value='Suprimer'>");
			out.println("</form><br>");
		}
	%>
	<h2>Ajouter un Utilisateur</h2>
	<form method="POST" action="Controler?action=addUser">
		<div class="form-group">
			<label for="exampleInputEmail1">Login :</label> <input
				class="form-control" name="loginInput">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Nom :</label> <input
				class="form-control" name="nomInput">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Mot de Passe :</label> <input
				type="password" class="form-control" name="passInput">
		</div>
		<input type="submit" class="btn btn-primary" value="submit">
	</form>
</body>
</html>