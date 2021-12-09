<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--  Paquetes JAVA -->
<%@page import="admin.*"%>
<%@page import="seguridad.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%> 



<% 



// INFORMACION DEL SOFTWARE
int var_sys=0;
LinkedList<Systems> datos_software = SystemsDAO.datosSystema();
	String nom_sys = datos_software.get(var_sys).getNom_sys();
	String ver_sys = datos_software.get(var_sys).getVer_sys();
	String desing_sys = datos_software.get(var_sys).getDesing_sys();
	
	
// INFORMACION DE LA ENTIDAD
int var_ent=0;
LinkedList<Entidad> datos_entidad = EntidadDAO.datosEntidad();
	String nom_ent = datos_entidad.get(var_sys).getNom_entidad();
	
	
// USUARIOS
LinkedList<VTusuarios> datos_usuario = UsuariosDAO.listarUsuarios();


// PARAMETROS
LinkedList<Parametros> parametros = ParametrosDAO.listarParametros();


//CONTADORES
LinkedList<VTcontadores> datos_contador = ContadoresDAO.listarContadores();
	


%>



