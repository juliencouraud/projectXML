<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<html>
<head>

<%@include file="/css/header2.jsp" %>
<style type="text/css">
    <%@include file="/css/jquery.dataTables.css" %>
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="utilisateur" scope="request" class="model.Utilisateur"></jsp:useBean>
<jsp:useBean id="listeUtilisateurs" scope="request" class="model.ListeUtilisateurs"></jsp:useBean>
<jsp:useBean id="groupes" scope="request" class="model.ListeGroupes"></jsp:useBean>

<title>Projet XML</title>

</head>

<body>
	<div class="page-header titre">
		<h1>Gérer mes contacts</h1>
	</div>
	<div class="container col-sm-4">
		<div class="titre">
			<h2>Suppression de contact</h2>
		</div>
		<div>
			<form>
			<p>Sélectionnez un contact puis cliquez sur le bouton "Supprimer".</p> 
			<table id="contacts" class="display" width="100%" cellspacing="0">
				<thead>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
				</tr>
			</thead>
			<tbody>
				<%
				if(utilisateur.getListeContacts().estVide()){
					out.println("<tr>");
					out.println("<td>"+"Aucun"+"</td>");
					out.println("<td>"+"Aucun"+"</td>");
					out.println("</tr>");
				}
				else{
					for(Contact c :utilisateur.getListeContacts().getListeContacts()){
						out.println("<tr>");
						out.println("<td>"+c.getPrenom()+"</td>");
						out.println("<td>"+c.getNom()+"</td>");
						out.println("</tr>");
					}
				}
				%>
			</tbody>
				<button id="supprimer" >Supprimer</button>
			</table>
			</form>
		</div>
	</div>
	
	
	<div class="container col-sm-4">
		<div class="titre">
			<h2>Ajout de contact</h2>
		</div>
		<div>
			<form>
			<p>Sélectionnez un contact puis cliquez sur le bouton "Ajouter".</p> 
			<table id="autres" class="display" width="100%" cellspacing="0">
				<thead>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
				</tr>
			</thead>
			<tbody>
				<%
				/*
				if(utilisateur.getListeContacts().estVide()){
					for(Utilisateur u : listeUtilisateurs.getListeUtilisateur()){
						if(utilisateur.getID() != u.getID()){
							Contact c = u.utilisateurToContact(utilisateur.getGroupeContact(u.getID()));
							out.println("<tr>");
							out.println("<td>"+c.getPrenom()+"</td>");
							out.println("<td>"+c.getNom()+"</td>");
							out.println("</tr>");
						}
					}
				}
				*/
//				else{
					for(Utilisateur u : listeUtilisateurs.getListeUtilisateur()){
						if(utilisateur.getID() != u.getID() && !utilisateur.estContact(u.getID())){
							Contact c = u.utilisateurToContact(u.getID(),utilisateur.getGroupeContact(u.getID()));
							out.println("<tr>");
							out.println("<td>"+c.getPrenom()+"</td>");
							out.println("<td>"+c.getNom()+"</td>");
							out.println("</tr>");
						}
					}
			//	}
			//	%>
			</tbody>
				<button id="ajouter" >Ajouter</button>
			</table>
			</form>
		</div>
	</div>
	
	
	
	<div class="container col-sm-4">
		<div class="titre">
			<h2>Gestion des groupes</h2>
		</div>
		<div>
			<form>
			<p>Sélectionnez un contact et un groupe puis cliquez sur le bouton "Modifier".</p> 
			<select id="selectGroupe" name="selectGroupe">
				<%
					for(String groupe: groupes.getListeGroupes()){
						out.println("<option value=\""+groupe+"\">"+groupe+"</option>");
					}
				%>
			</select>
			<button id="modifier" >Modifier</button>
			<table id="modifGroupe" class="display" width="100%" cellspacing="0">
				<thead>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Groupe</th>
				</tr>
			</thead>
			<tbody>
				<%
				if(utilisateur.getListeContacts().estVide()){
					out.println("<tr>");
					out.println("<td>"+"Aucun"+"</td>");
					out.println("<td>"+"Aucun"+"</td>");
					out.println("<td>"+"Aucun"+"</td>");
					out.println("</tr>");
				}
				else{
					for(Contact c :utilisateur.getListeContacts().getListeContacts()){
						out.println("<tr>");
						out.println("<td>"+c.getPrenom()+"</td>");
						out.println("<td>"+c.getNom()+"</td>");
						out.println("<td>"+c.getGroupe()+"</td>");
						out.println("</tr>");
					}
				}
				%>
			</tbody>
			</table>
			</form>
		</div>
	</div>
	

<script src="/projetXML/js/jquery-1.11.1.min.js" language="javascript" type="text/javascript"></script>
<script src="/projetXML/js/jquery.dataTables.min.js"></script>
<script src="/projetXML/js/dataTables.bootstrap.js"></script>


<script>
$(document).ready(function() {
    var table = $('#contacts').DataTable(
    		{
    	    "paging":   false
   			}		
    );
 
    $('#contacts tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    var toServer;
    $('#contacts tbody').on( 'click', 'tr', function () {
        toServer = table.row('.selected').data();
		console.log(toServer);
    } );
    
    $('#supprimer').click( function () {
    	$.ajax({
    		method:'post',
    		url:'/projetXML/gestionContacts',
    		data: {"nom": toServer[1], "prenom": toServer[0],"action":"supprimer"}
    	}).succes(function(){
    		console.log(arguments);
    	}).error(function(){
    		console.log(arguments);

    	});
    	
    	return false;
    	
    	
    } );
    
} );
</script>
<script>
$(document).ready(function() {
    var table = $('#autres').DataTable(
    		{
    	    "paging":   false
   			}		
    );
 
    $('#autres tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    var toServer;
    $('#autres tbody').on( 'click', 'tr', function () {
        toServer = table.row('.selected').data();
		console.log(toServer);
    } );
    
    $('#ajouter').click( function () {
    	$.ajax({
    		method:'post',
    		url:'/projetXML/gestionContacts',
    		data: {"nom": toServer[1], "prenom": toServer[0],"action":"ajouter"}
    	}).succes(function(){
    		console.log(arguments);
    	}).error(function(){
    		console.log(arguments);

    	});
    	return false;
    	
    	
    } );
    
} );
</script>
<script>
$(document).ready(function() {
    var table = $('#modifGroupe').DataTable(
    		{
    	    "paging":   false
   			}		
    );
 
    $('#modifGroupe tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    var toServer;
    $('#modifGroupe tbody').on( 'click', 'tr', function () {
        toServer = table.row('.selected').data();
		console.log(toServer);
    } );
    
    $('#modifier').click( function () {
        var e = document.getElementById("selectGroupe");
        var selectGroupe = e.options[e.selectedIndex].value;
    	$.ajax({
    		method:'post',
    		url:'/projetXML/gestionContacts',
    		data: {"nom": toServer[1], "prenom": toServer[0],"action":"modifier","selectGroupe":selectGroupe}
    	}).succes(function(){
    		console.log(arguments);
    	}).error(function(){
    		console.log(arguments);

    	});
    	
    	return false;
    } );
    
} );
</script>
</body>
</html>