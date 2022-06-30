<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%

int cod_rol =0;

if (session.getAttribute("usuario") != null) {
cod_rol = (int)session.getAttribute("mi_rol");  // Variable de session
}else{
	
	response.sendRedirect("expired");
	
	
}


%>