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
LinkedList<Parametros> param = ParametrosDAO.listarParametros(); 
%>
  
    
    

<div class="modal fade" id="agregarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar nuevo usuario</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <form action="${pageContext.request.contextPath}/seguridad" method="post">
      <div class="modal-body">
      
      
      <div class="row g-3">
  <div class="col">
        <select class="form-select" name="selectTipoId" id="validationCustom04" required>
      
      <option selected value="">-- Tipo id --</option>
      <% for (int i = 0; i < param.size(); i++) {  
      	
    	  int codigo = param.get(i).getCod_param();
    	  int parametro = param.get(i).getNum_param();
    	  String detalle = param.get(i).getDetalle_param();
    	  
    	  if(codigo==1 && parametro!=0){ // tipo identificacion
      
    		  %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
      
    </select>
    
    <br>
  </div>
  <div class="col">
    <div id="docUsu"><input type="text" readonly class="form-control" id="docUsu" placeholder="Número identificación" ></div>
  </div>
</div>
      
      

<div >
  <input type="text" name="txtNomPersona" class="form-control" placeholder="Nombres y Apellidos" aria-label="Nombres" id="nom_persona">
  <br>
</div>

      
      <input type="text"  name="txtDirPersona" class="form-control" id="dir_persona" placeholder="Dirección residencia">
      <label for="exampleFormControlInput1" class="form-label"></label>
      <input type="text"  name="txtTelPersona" class="form-control" id="tel_persona" placeholder="Telefóno celular o fijo">
       </div>
       
       <div style="text-align:center">
       <small>Roles o permisos</small>
       </div>
       
          <div class="modal-body">
       <select class="form-select" name="selectPermisos" id="validationCustom04" required>
          <option selected value="">-- Agregar permisos al usuario --</option>
      <% for (int i = 0; i < param.size(); i++) {  
      	
    	  int codigo = param.get(i).getCod_param();
    	  int parametro = param.get(i).getNum_param();
    	  String detalle = param.get(i).getDetalle_param();
    	  
    	  if(codigo==2){ //permisos
      
      %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
    </select>  
     </div>  
       
       
      
      <div class="modal-footer">
      <input type="hidden"  name="txtCodPersona" class="form-control" id="cod_persona">
      <input type="hidden" name="validar" value="modificarUsuario">  
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
      </div>
    </div>
  </div>
</div>