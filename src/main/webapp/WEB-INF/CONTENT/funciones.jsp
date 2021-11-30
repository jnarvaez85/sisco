<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--  Paquetes JAVA -->
<%@page import="admin.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%> 



<% 



// REDIRIGE LA SESSION EXPIRADA
if (session.getAttribute("usuario") == null) {
	session.invalidate();  
	request.setAttribute("errMessage", "La sessión finalizo exitosamente!");
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("../PAGE/denegado.jsp");
	requestDispatcher.forward(request, response);
	System.out.println("Sessión cerrada!");

}

//FECHA ACTUAL  

Date dNow = new Date();
SimpleDateFormat ft = 
new SimpleDateFormat ("yyyy-MM-dd");

String currentDate = ft.format(dNow);

%>



