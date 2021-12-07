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

int getRol = (int)session.getAttribute("mi_rol");


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




<!-- SOLO PERMITE LA ENTRADA DE DATOS NUMERICOS  -->
<script type="text/javascript">
function valideKey(evt){
    
    // <input onkeypress="return valideKey(event);"
    var code = (evt.which) ? evt.which : evt.keyCode;
    
    if(code==8) { // backspace.
      return true;
    } else if(code>=48 && code<=57) { // is a number.
      return true;
    } else{ // other keys.
      return false;
    }
}
</script> 


