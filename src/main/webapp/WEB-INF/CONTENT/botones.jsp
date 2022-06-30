<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
 <!--  Paquetes JAVA -->
<%@page import="admin.*"%>
<%@page import="seguridad.*"%>
<%@page import="planillas.*"%>   
    

<%


//DEFINIENDO LAS OPCIONES DE LOS ROLES
//int getRolColabor = (int) session.getAttribute("mi_rol");


//int getRolColabor = cod_rol;


int getRolColabor =0;

if (session.getAttribute("usuario") != null) {
	getRolColabor = (int)session.getAttribute("rol");  // Variable de session
}else{
	
	response.sendRedirect("expired");
	
	
}




//Recibe por parametro cod_menu
//************************************************ SECCION AGREGAR SOBRES ******************************//


// Compartir planilla
VTmenu btn_add_share = MenuDAO.menuGeneral(getRolColabor, 45);

int btn_add_share_permiso = btn_add_share.getPermiso();
String btn_add_share_opcion = btn_add_share.getOpcion();
String btn_add_share_link = btn_add_share.getLink_menu();


// Dejar de compartir
VTmenu btn_add_no_share = MenuDAO.menuGeneral(getRolColabor, 46);

int btn_add_no_share_permiso = btn_add_no_share.getPermiso();
String btn_add_no_share_opcion = btn_add_no_share.getOpcion();
String btn_add_no_share_link = btn_add_no_share.getLink_menu();


// Finalizar Ingreso
VTmenu btn_finalizar = MenuDAO.menuGeneral(getRolColabor, 47);

int btn_finalizar_permiso = btn_finalizar.getPermiso();
String btn_finalizar_opcion = btn_finalizar.getOpcion();
String btn_finalizar_link = btn_finalizar.getLink_menu();


// Cancelar
VTmenu btn_cancelar = MenuDAO.menuGeneral(getRolColabor, 44);

int btn_permiso = btn_cancelar.getPermiso();
String btn_opcion = btn_cancelar.getOpcion();
String btn_link = btn_cancelar.getLink_menu();



// Boton para Agregar sobres especiales
VTmenu btn_add_especial = MenuDAO.menuGeneral(getRolColabor, 43);

int btn_add_especial_permiso = btn_add_especial.getPermiso();
String btn_add_especial_icon = btn_add_especial.getIcon_menu();
String btn_add_especial_opcion = btn_add_especial.getOpcion();
String btn_add_especial_link = btn_add_especial.getLink_menu();

// Boton para Agregar colaboradores de planilla

VTmenu btn_add_colabora = MenuDAO.menuGeneral(getRolColabor, 40);

int btn_add_colabora_permiso = btn_add_colabora.getPermiso();
String btn_add_colabora_icon = btn_add_colabora.getIcon_menu();
String btn_add_colabora_opcion = btn_add_colabora.getOpcion();
String btn_add_colabora_link = btn_add_colabora.getLink_menu();




%>