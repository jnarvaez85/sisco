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
  
    
    

<div class="modal fade" id="getIdentificacion" tabindex="-1"  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar nueva persona</h5>
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
    <div id="getDoc"><input type="text" readonly class="form-control" name="txtIdentificacion" id="getDoc" placeholder="Número identificación" ></div>
  </div>
</div>
      
      

<div >
  <input type="text" name="txtNombres" class="form-control" placeholder="Nombres y Apellidos"  id="nom_persona" autocomplete="off">
  <br>
</div>

      
      <input type="text"  name="txtDireccion" class="form-control" id="dir_persona" placeholder="Dirección residencia" autocomplete="off">
      <label for="exampleFormControlInput1" class="form-label"></label>
      <input type="text"  name="txtTelefono" class="form-control" id="tel_persona" placeholder="Telefóno celular o fijo" autocomplete="off">
       </div>
       
   
       

       
      
      <div class="modal-footer">
      <input type="hidden" name="cursor" value="0"> 
      <input type="hidden" name="validarUrl" value="agregarPersonaDesdeSobres"> 
      <input type="hidden" name="validar" value="agregarPersona">  
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
      </div>
    </div>
  </div>
</div>