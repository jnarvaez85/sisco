<%@ include file="../CONTENT/lib.jsp" %>
<%@ include file="../CONTENT/title.jsp" %>
<%@ include file="../CONTENT/header.jsp" %>
<%@ include file="../CONTENT/funciones.jsp" %>
<%@ include file="../CONTENT/consultas.jsp" %>



<%
final int tmp_cod_plan=1;
String fecha_planilla=null;
VTtempoDatosPlanilla tmp_dato_planilla = TempoDatosPlanillaDAO.consultarDatosPlanillaTemp(tmp_cod_plan);

		int compartida = tmp_dato_planilla.getCompartida();
		


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


<div class="div_content">


<% if(compartida == 0){  %> 

 <div> 
 <div>
Lo sentimos, no hay planillas compartidas por ingresar
  </div>
  

  <% } else{ %> 
  
  
<div style="text-align: center;padding: 20px;">
  
<button type="button" class="btn btn-primary position-relative">
 Jairo Narvaez ha compartido una planilla
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    1+
    <span class="visually-hidden">unread messages</span>
  </span>
</button>
<br>
<br>



<a href="${pageContext.request.contextPath}/planillas?url=addSobres"  class="btn btn-success">INGRESAR</a>
<div>
<small>¿Desea ayudar con el ingreso de los sobres de la planilla compartida?</small>
</div>		
</div>
  
  
   <% } %> 
  
 
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


<%@ include file="../modal/cancelarPlanilla.jsp"%>