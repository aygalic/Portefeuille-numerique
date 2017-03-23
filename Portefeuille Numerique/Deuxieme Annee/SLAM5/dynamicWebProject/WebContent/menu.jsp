<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jdbc.complex.*"%>
<%
	session = request.getSession();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<%-- 

Menu principal, ici l'utilisateur choisi à l'aide d'un formulaire les données auquelles il souhaite acceder

Se referer au balises <h2> pour plus d'information

 --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Menu Principal</h1>

		<div class="row">
			<h2>gerer les utilisateurs</h2>
			<form method="POST" action="Controler?action=users">
				<input type="submit" class="btn btn-primary"
					value="Acces aux utilisateurs">
			</form>
		</div>
		<div class="row">
			<h2>gérer les commentaires</h2>
			<form method="POST" action="Controler?action=comments">
				<input type="submit" class="btn btn-primary"
					value="Acces aux commentaires">
			</form>
		</div>
		<div class="row">
			<h2>afficher tout les commentaires a partir d'une date</h2>
			La date doit etre au format "17/06/2013"
			<form method="POST" action="Controler?action=getCommentFromDate">
				<input type="text" name="date"> <input type="submit"
					class="btn btn-primary"
					value="Acces aux commentaires posterieurs à cette date">
			</form>
		</div>
		<div class="row">
			<h2>afficher tout les commentaires d'un utilisateur</h2>
			<form method="POST" action="Controler?action=getCommentFromUser">
				<input type="text" name="user"> <input type="submit"
					class="btn btn-primary"
					value="Acces aux commentaires de cet utilisateur">
			</form>
		</div>
	</div>


</body>
</html>