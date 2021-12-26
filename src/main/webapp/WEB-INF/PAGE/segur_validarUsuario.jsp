<%@ include file="../CONTENT/lib.jsp" %>
<%@ include file="../CONTENT/title.jsp" %>
<%@ include file="../CONTENT/header.jsp" %>
<%@ include file="../CONTENT/funciones.jsp" %>
<%@ include file="../CONTENT/consultas.jsp" %>



<% if(request.getAttribute("alert") == "101"){ %>
<jsp:include page="/WEB-INF/ALERT/usuarioExiste.jsp" />
<% } %>





<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="div_content">
<form class="row g-3 needs-validation" action="seguridad" method="post" >



  <div class="col-md-3">
    <label for="validationCustom05" class="form-label">Ingresar número</label>
    <input type="text" class="form-control" name="txtIdentificacion" autocomplete="off" required placeholder="Validar identificación">

  </div>


  <div class="col-12">
    <button class="btn btn-primary" type="submit">VALIDAR</button>
  </div>
  
        <input type="hidden"  name="validar" value="validarUsuario">
  
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