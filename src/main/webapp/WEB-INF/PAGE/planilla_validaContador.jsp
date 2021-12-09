<%@ include file="../CONTENT/lib.jsp" %>
<%@ include file="../CONTENT/title.jsp" %>
<%@ include file="../CONTENT/header.jsp" %>
<%@ include file="../CONTENT/funciones.jsp" %>
<%@ include file="../CONTENT/consultas.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


<div class="div_content">
 <div class="col-md-3"> 
 
 
 <div class="div_center_25">
 <form action="${pageContext.request.contextPath}/planillas" method="post"> 
 
 
    <label for="validationCustom04" class="form-label">Contador responsable</label>
    <select class="form-select" name="selectCodPersona" id="validationCustom04" required>      
      <option selected value="">-- Seleccionar --</option>
      <% for (int i = 0; i < datos_contador.size(); i++) {  
      	
    	  String nom_contador = datos_contador.get(i).getNom_contador();
    	  int cod_persona = datos_contador.get(i).getCod_persona();
    	  int estado_cont = datos_contador.get(i).getCod_estado();
    	  
    	if(estado_cont==1){
       %>
      <option value="<%= cod_persona%>"><%= nom_contador%></option>
      <% 	
    	  }
      	}
      %>
      
    </select>
    <br>
   <input required name="txtCodContador" minlength="1" maxlength="4" onkeypress="return valideKey(event);" type="password" class="form-control" placeholder="Digite clave contador" autocomplete="off">
    <br>
    <button type="submit" class="btn btn-success">Validar</button>
    
    <input type="hidden" name="validar" value="validarContador"> 
 </form>
 <br>
 <small>Deberá seleccionar el contador o revisor responsable de la firma de la planilla a ingresar</small>
  </div>
  

  
  
 
</div>
</div>


<div style="position: absolute;right: 3rem;">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Nueva Planillas</h5>
    <h6 class="card-subtitle mb-2 text-muted"><img width="15px" src="img/menu/about.png"/> Modulo: Planillas</h6>
    <p class="card-text">Permite generar el ingreso de sobres para una nueva planilla de cuadre</p>
    <a href="#" id="a_link"><img width="20px" src="img/menu/buscar.png"/> Consultar planilla</a>
  </div>
</div>
</div>
</body>
</html>