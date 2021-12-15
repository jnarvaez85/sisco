<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.LinkedList"%>

<%@page import="admin.*"%>    
   
<% LinkedList<Parametros> tipo_doc = ParametrosDAO.listarParametros(); %>

<div class="modal fade" id="agregarColaborador" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar Nuevo Colaborador</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
 <form action="${pageContext.request.contextPath}/planillas" method="post">
  <div class="mb-3 row">
    <label for="staticEmail" class="col-sm-6 col-form-label">

    <select class="form-select" name="selectTipoId"  required>
      
      <option selected value="">-- Seleccionar --</option>
      <% for (int i = 0; i < tipo_doc.size(); i++) {  
      	
    	  int codigo = tipo_doc.get(i).getCod_param();
    	  int parametro = tipo_doc.get(i).getNum_param();
    	  String detalle = tipo_doc.get(i).getDetalle_param();
    	  
    	  if(codigo==1){ // tipo identificacion
      
    		  %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
      
    </select>


</label>
    <div class="col-sm-6">
      <input type="text"  name="txtDocColabora" class="form-control"  placeholder="Número documento" required>
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-12">
      <input type="text" name="txtNomColabora" class="form-control" placeholder="Nombres y Apellidos" required>
    </div>
  </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
        
        <input type="hidden"  name="validar"  value="agregarColaborador">
        </form>
      </div>
    </div>
  </div>
</div>