<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="model.*"%>

<html>
<head>

<%@include file="/css/header2.jsp" %>
<style type="text/css">
    <%@include file="/css/jquery.dataTables.css" %>
</style>

<meta content="text/html; charset=utf-8" http-equiv="content-type">
<jsp:useBean id="utilisateur" scope="request" class="model.Utilisateur"></jsp:useBean>

<title>Projet XML</title>

</head>

<body>
	<div class="page-header titre">
		<h1>
			Profil utilisateur de
<%
			out.println(utilisateur.getNom()+" "+utilisateur.getPrenom());
%>
		</h1>
	</div>
<div>
	<div class="titre">
	<h2>Carnet de contacts:</h2>
	</div>
	<div>
		<table  id="contacts" class="container col-sm-11">
			<thead>
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Adresse Mail</th>
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
						out.println("<td>"+"Aucun"+"</td>");
						out.println("</tr>");
					}
					else{
						for(Contact c :utilisateur.getListeContacts().getListeContacts()){
							out.println("<tr>");
							out.println("<td>"+c.getPrenom()+"</td>");
							out.println("<td>"+c.getNom()+"</td>");
							out.println("<td>"+c.getMail()+"</td>");
							out.println("<td>"+c.getGroupe()+"</td>");
							out.println("</tr>");
						}
					}
				%>
			</tbody>
		</table>
	</div>
</div>

<script src="/projetXML/js/jquery-1.11.1.min.js" language="javascript" type="text/javascript"></script>
<script src="/projetXML/js/jquery.dataTables.min.js"></script>
<script src="/projetXML/js/dataTables.bootstrap.js"></script>

<script>
$(document).ready(function() {
    $('#contacts').DataTable(
    		{
            "paging":   false
    		}
    );
} );
</script>
</body>
</html>