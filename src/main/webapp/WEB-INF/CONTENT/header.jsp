<%@ include file="../../libraries/bootstrap.jsp" %>


<%@page import="admin.*"%>
<%@page import="seguridad.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.LinkedList"%>

<%
// recibe el rol
int cod_rol = (int)session.getAttribute("mi_rol");
LinkedList<VTmenu> menu = MenuDAO.datosMenu(cod_rol);

LinkedList<Entidad> entidad = EntidadDAO.datosEntidad();
String nombre_ent = entidad.get(0).getNom_entidad();

LinkedList<Systemas> software = SystemsDAO.datosSystema();
String nombre_sys = software.get(0).getNom_sys();
String version_sys = software.get(0).getVer_sys();
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<div class="header" id="rgb_corporative">
<%= "Licencia instalada a "+" "+nombre_ent %>
<span class="header_dropdown">
<nav class="navbar navbar-expand-lg navbar-dark">
  <div class="container-fluid">    
    <button class="navbar-toggler "  type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
     
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="25px" src="img/white/user.png"/> ${usuario.getNom_persona()}
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="#"><img width="18px" src="img/menu/config.png"/> Configuración</a></li>
            <li><a class="dropdown-item" href="#"><img width="18px" src="img/menu/admin.png"/> Cambiar contraseña</a></li>
            <li><a class="dropdown-item" href="logout"><img width="18px" src="img/menu/logout.png"/> Salir</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</span>
</div>


<div style=""> 
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="views?url=home"><%= nombre_sys+ " "+version_sys %> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
           <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/planillas.png"/>Planillas
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          
          <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==1){ // planillas    		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="planillas?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>

          </ul>
        </li>
           <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/recaudo.png"/> Recaudo
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==2){ // recaudo   		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="recaudo?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>

          </ul>
        </li>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/nomina.png"/> Nomina
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                 <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
			String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==3){ // nomina   		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="nomina?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/caja.png"/> Caja
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                 <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==4){ // caja  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="caja?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <img width="18px" src="img/menu/cierre.png"/> Cierre de planillas
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                 <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==5){ // cierre  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="cierre?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
               <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <img width="18px" src="img/menu/obligaciones.png"/> Obligaciones
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==6){ // obligaciones  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="obligaciones?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
               <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/auditoria.png"/> Reportes
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==7){ // reportes  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="reportes?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
               <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/admin.png"/> Administración
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==8){ // admin  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="admin?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
               <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <img width="18px" src="img/menu/seguridad.png"/> Seguridad
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                              <%
      	for (int i = 0; i < menu.size(); i++) {

    		int param = menu.get(i).getCod_modulo();
    		String opcion = menu.get(i).getOpcion();
    		String icon = menu.get(i).getIcon_menu();
    		String link = menu.get(i).getLink_menu();
    		
    		if(param==9){ // segur  		
    		%>
          
            <li>                    
            <a class="dropdown-item" href="seguridad?url=<%= link %>">
            <img width="18px" src="img/menu/<%= icon %>.png"/>
            <%= opcion %>
             </a>       
            
            </li>
            
		<% } 
      	}
		%>
          </ul>
        </li>
   
      </ul>
    </div>
  </div> 
</nav>
<div class="header_hr"> <hr></div>

</div>

</body>
</html>