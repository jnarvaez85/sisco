<%@ include file="../../CONTENT/lib.jsp" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="div_content">
<h2>Acceso denegado por tiempo de inactividad!</h2>

<img  src="img/vector/expired.png"/>
</div>



<div style="position: absolute;right: 3rem;">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Su sessión ha sido cerrada</h5>
    <h6 class="card-subtitle mb-2 text-muted"><img width="15px" src="img/menu/Clock_50px.png"/> tiempo agotado</h6>
    <p class="card-text">Favor Ingresar nuevamente...</p>
    <a href="index.jsp" id="a_link"><img width="20px" src="img/menu/seguridad.png"/> Ingresar</a>
  </div>
</div>
</div>
</body>
</html>