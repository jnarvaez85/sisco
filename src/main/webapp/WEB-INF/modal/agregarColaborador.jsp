
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



<% LinkedList<Parametros> paramPersona = ParametrosDAO.listarParametros(); %>


<div class="modal fade" id="getIdentificacion" tabindex="-1"  aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar Colaborador</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        



<form class="row g-3" action="${pageContext.request.contextPath}/planillas" method="post">

  <div class="col-md-5">

    <select class="form-select" name="selectTipoId" id="validationCustom04" required>
      
      <option selected value="">-- Tipo id --</option>
      <% for (int i = 0; i < paramPersona.size(); i++) {  
      	
    	  int codigo = paramPersona.get(i).getCod_param();
    	  int parametro = paramPersona.get(i).getNum_param();
    	  String detalle = paramPersona.get(i).getDetalle_param();
    	  
    	  if(codigo==1 && parametro!=0){ // tipo identificacion
      
    		  %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
      
    </select>

  </div>
  <div class="col-md-6">
    <div id="getDoc"><input type="text"  readonly class="form-control" name="txtIdentificacion" id="getDoc" placeholder="Identificación"></div>
    
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label"></label>
    <input type="text" required class="form-control" name="txtNomColabora"  placeholder="Nombres y Apellidos" autocomplete="off">
  </div>
  <div class="col-12">
    <input type="text" class="form-control" name="txtDirColabora"  placeholder="Dirección Residencia" autocomplete="off" >
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">Telefono</label>
    <input type="text" class="form-control" name="txtTelColabora" placeholder="ej: 623 12345" autocomplete="off">
  </div>

  
  <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
    <button type="submit" class="btn btn-primary">GUARDAR</button>
  </div>

	<input type="hidden"  name="cursor" value="0">
    <input type="hidden"  name="validar" value="agregarColaborador">
</form>




  
      </div>
    </div>
  </div>
</div>




  