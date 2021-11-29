<%@ include file="../CONTENT/lib.jsp" %>


<%@page import="admin.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.LinkedList"%>


<%
	LinkedList<Systems> system = SystemsDAO.datosSystema();	

	for (int i = 0; i < system.size(); i++) {

		String nombre_entidad = system.get(i).getNom_sys();
		String version_entidad = system.get(i).getVer_sys();
	
		%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=nombre_entidad+" "+version_entidad%></title>
</head>
<body>	
	
	<%
		}
	%>

</body>
</html>