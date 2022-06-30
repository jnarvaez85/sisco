<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%

int getRolModal =0;

if (session.getAttribute("usuario") != null) {
	getRolModal = (int)session.getAttribute("mi_rol");  // Variable de session
	
}


%>