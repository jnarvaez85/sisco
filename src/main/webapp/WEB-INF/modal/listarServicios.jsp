<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!--  Paquetes JAVA -->
<%@page import="planillas.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%> 

<%
LinkedList<Servicios> datos_serv = ServiciosDAO.listarServicios();
%>



<div class="modal fade" id="listarServicios" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Listado de servicios agregados</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        


<div id="table-wrapper">
  <div id="table-scroll">
	<table class="table">
  <thead>
    <tr>
      <th scope="col"><span class="text">Nombre del servicio</span></th>
      <th scope="col"><span class="text">Hora</span></th>
      <th scope="col"><span class="text"></span></th>      
    </tr>
  </thead>
  <tbody>
  
  
  <% for (int i = 0; i < datos_serv.size(); i++) {  
  
	  int cod_servicio = datos_serv.get(i).getCod_servicio();
	  String nom_servicio = datos_serv.get(i).getNom_servicio();
	  String hora_servicio = datos_serv.get(i).getHora_servicio();
  %>
  
    <tr> 
       
      <td><%=nom_servicio %></td>
      <td><%=hora_servicio %></td>
      <td>
	<form action="${pageContext.request.contextPath}/planillas" method="post">
				<div>				
				<button type="submit" class="btn btn-link">
				<img  width="18px" src="img/menu/eliminar.png" />
				</button>
				</div>
				<input type="hidden"  name="txtCodServicio"  value="<%=cod_servicio %>">
				<input type="hidden" name="validar" value="eliminarServicio">  
				</form>
		</td>
		      
		      <td>
				<a href="#" 
				data-bs-toggle="modal" data-bs-target="#modificarServicio"
				data-bs-cod-servicio="<%= cod_servicio %>" 
				data-bs-nom-servicio="<%= nom_servicio %>" 
				data-bs-hor-servicio="<%= hora_servicio %>">		
				<img width="18px" src="img/menu/editar.png" /></a>
		</td>
    
    </tr>
    
  <% } %>
  
  

  </tbody>
</table>
</div></div>
      </div>

    </div>
  </div>
</div>



<%@ include file="../modal/modificarServicio.jsp"%>
<%@ include file="../js/scriptServicios.jsp"%>