<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet XML</title>
<%@include file="/css/header2.jsp" %>
</head>
<body>
	<div class="page-header titre">
		<h1>Interface de modification</h1>
	</div>
<form method=POST action="/projetXML/Modification">
	<input type="radio" name="radio" value="nom">Changer mon nom.
	</br>
	<input type="radio" name="radio" value="prenom">Changer mon prénom.
	</br>
	<input type="radio" name="radio" value="mail">Changer mon mail.
	</br>
	<input type="radio" name="radio" value="mdp">Changer mon mot de passe.
	</br>
	Nouvelle donnée:<input type="text" name="nouveau">
	</br>
	<input type="submit">
</form>
</body>
</html>