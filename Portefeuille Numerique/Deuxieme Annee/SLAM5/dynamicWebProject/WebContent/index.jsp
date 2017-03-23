<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session = request.getSession();
%>
<%--
	
	Acceuil, ici on envoie au controlleur le mot de passe et le login via un formulaire
	
	 --%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
</head>
<body>
	<h1>Hello, world!</h1>
	<div class="row">
		<div class="col-xs-6 col-xs-offset-3">
			<form method="POST" action="Controler?action=login">
				<div class="form-group">
					<label for="exampleInputEmail1">Fait peter le login</label> <input
						class="form-control" name="mailInput" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" name="passInput"
						placeholder="Password">
				</div>
				<input type="submit" class="btn btn-primary" value="submit">
			</form>
		</div>
	</div>
</body>
</html>