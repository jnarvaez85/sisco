<%@ include file="../CONTENT/lib.jsp" %>
<%@ include file="../CONTENT/title.jsp" %>
<%@ include file="../CONTENT/header.jsp" %>
<%@ include file="../CONTENT/funciones.jsp" %>
<%@ include file="../CONTENT/consultas.jsp" %>



 <%  String documento = (String)request.getAttribute("doc_user"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="div_content">
<form class="row g-3 needs-validation" action="seguridad" method="post" >


 <div class="col-md-3">
    <label for="validationCustom04" class="form-label">Tipo Identificación</label>
    <select class="form-select" name="selectTipoId" id="validationCustom04" required>
      
      <option selected value="">-- Seleccionar --</option>
      <% for (int i = 0; i < parametros.size(); i++) {  
      	
    	  int codigo = parametros.get(i).getCod_param();
    	  int parametro = parametros.get(i).getNum_param();
    	  String detalle = parametros.get(i).getDetalle_param();
    	  
    	  if(codigo==1){ // tipo identificacion
      
    		  %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
      
    </select>
 
  </div>
  <div class="col-md-3">
    <label for="validationCustom05" class="form-label">Identificación</label>
    <input type="text" class="form-control" name="txtIdentificacion" readonly value="<%= documento %>">
   
  </div>
   
  
  
  
  <div class="col-md-4">
    <label for="validationCustom01" class="form-label">Permisos</label>
    <select class="form-select" name="selectPermisos" id="validationCustom04" required>
          <option selected value="">-- Seleccionar --</option>
      <% for (int i = 0; i < parametros.size(); i++) {  
      	
    	  int codigo = parametros.get(i).getCod_param();
    	  int parametro = parametros.get(i).getNum_param();
    	  String detalle = parametros.get(i).getDetalle_param();
    	  
    	  if(codigo==2){ //permisos
      
      %>
      <option value="<%= parametro%>"><%= detalle%></option>
      <% 	} 
      	}
      %>
    </select>    
  </div>
  <div class="col-md-4">
    <label for="validationCustom02" class="form-label">Nombres</label>
    <input type="text" class="form-control" name="txtNombres" autocomplete="off"  required>

  </div>
  <div class="col-md-4">
    <label for="validationCustomUsername" class="form-label">Apellidos</label>
    <div class="input-group has-validation">
      <input type="text" class="form-control" name="txtApellidos" autocomplete="off"  required>
  
    </div>
  </div>
    <div class="col-md-4">
    <label for="validationCustom02" class="form-label">Telefono</label>
    <input type="text" class="form-control" name="txtTelefono" autocomplete="off" >
 
  </div>

  <div class="col-md-6">
    <label for="validationCustom03" class="form-label">Dirección</label>
    <input type="text" class="form-control" name="txtDireccion" autocomplete="off" >
   
  </div>
 

  <div class="col-12">
    <button class="btn btn-primary" type="submit">GUARDAR</button>
  </div>
  
        <input type="hidden"  name="validar" value="agregarUsuario">
  
</form>
</div>



<div style="position: absolute;right: 3rem;">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Agregar Nuevo Usuario</h5>
    <h6 class="card-subtitle mb-2 text-muted"><img width="15px" src="img/menu/about.png"/> Modulo: Planillas</h6>
    <p class="card-text">Permite agregar un nuevo usuario con privilegios para la gestión de SISCO</p>
    <a href="seguridad?url=usuarios" id="a_link"><img width="20px" src="img/menu/list.png"/> Lista usuarios</a>
  </div>
</div>
</div>
</body>
</html>