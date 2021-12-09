<%@ include file="../CONTENT/lib.jsp" %>
<%@ include file="../CONTENT/title.jsp" %>
<%@ include file="../CONTENT/header.jsp" %>
<%@ include file="../CONTENT/funciones.jsp" %>
<%@ include file="../CONTENT/consultas.jsp" %>


<%

VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


<div class="div_content">
 <div class="col-md-3"> 
 
 
 <div class="container">
  <div class="row">
  <div style="width: 25%;
border-right: 1px solid #d0d0d0;
position: absolute;
top: 0;
bottom: 0;">
    <div style="top: 10%;
position: relative;">
      <div>CLAUDIA LUGO DIAZ</div>
      <small>Contador Responsable</small>
    </div>
   </div> 
    

   
  </div>
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