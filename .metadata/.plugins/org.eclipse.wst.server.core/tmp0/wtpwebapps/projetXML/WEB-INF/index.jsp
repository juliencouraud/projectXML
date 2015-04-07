<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="css/header1.jsp" %>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="page-header">
	<h1>Bienvenue sur le gestionnaire de contact</h1>
</div>
<div class="row">
<div class="container col-sm-6">
  		<h2>Connection</h2>
	<form role="form" method="POST" action="/projetXML/Connection">
    	<div class="form-group">
      		<label for="mail">Adresse mail:</label>
      		<input type="text" class="form-control" name="mail">
    	</div>
    	<div class="form-group">
      		<label for="mdp">Mot de passe:</label>
      		<input type="password" class="form-control" name="mdp">
    	</div>
    	<div class="submit">
    		<button type="submit" class="btn btn-default">Connection</button>
    	</div>
    </form>
</div>
<div class="container col-sm-6">
  		<h2>Inscription</h2>
	<form role="form" method="POST" action="/projetXML/Inscription">
    	<div class="form-group">
      		<label for="nom">Nom:</label>
      		<input type="text" class="form-control" name="nom">
    	</div>
    	<div class="form-group">
      		<label for="prenom">Prénom:</label>
      		<input type="text" class="form-control" name="prenom">
    	</div>
    	<div class="form-group">
      		<label for="mail">Adresse mail:</label>
      		<input type="text" class="form-control" name="mail">
    	</div>
    	<div class="form-group">
      		<label for="mdp">Mot de passe:</label>
      		<input type="password" class="form-control" name="mdp">
    	</div>
    	<div class="submit">
    		<button type="submit" class="btn btn-default">Inscription</button>
    	</div>
    </form>
</div>
</div>
</body>

</html>