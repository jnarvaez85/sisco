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
LinkedList<Parametros> param_mod_user = ParametrosDAO.listarParametros(); 
%>
  
    
    

<div class="modal fade" id="modificarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modificar Usuario</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <form action="${pageContext.request.contextPath}/seguridad" method="post">
      <div class="modal-body">

<div >
  <div id="nom_persona"><input type="text" name="txtNomPersona" class="form-control" placeholder="Nombres y Apellidos" aria-label="Nombres" id="nom_persona"></div>
  <br>
</div>

     
      <label for="exampleFormControlInput1" class="form-label">Dirección residencia</label>
      <div id="dir_persona"><input type="text"  name="txtDirPersona" class="form-control" id="dir_persona" placeholder="Dirección residencia"></div>
      <label for="exampleFormControlInput1" class="form-label">Telefóno celular o fijo</label>
      <div id="tel_persona"><input type="text"  name="txtTelPersona" class="form-control" id="tel_persona" placeholder="Telefóno celular o fijo"></div>
       </div>
       
       <div style="text-align:center">
       <small>Los permisos asignados para este usuario son de:</small>
       </div>
       
       <div id="rol_persona">
        <input type="text" style="font-weight: bold;text-align: center;font-size: 1.5em;" disabled class="form-control-plaintext" id="rol_persona"> 
       
       </div>
       
       
       <div class="modal-body">
       <select class="form-select" name="selectPermisos" id="validationCustom04" required>
          <option selected value="">-- ¿Desea modificar los permisos ? --</option>
      <% for (int i = 0; i < param_mod_user.size(); i++) {  
      	
    	  int codigo = param_mod_user.get(i).getCod_param();
    	  int parametro = param_mod_user.get(i).getNum_param();
    	  String detalle = param_mod_user.get(i).getDetalle_param();
    	  
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