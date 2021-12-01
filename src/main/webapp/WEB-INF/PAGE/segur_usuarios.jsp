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
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Firma</th>
      <th scope="col">Estado</th>
      <th scope="col">Nombre</th>
      <th scope="col">Usuario</th>
      <th scope="col">Rol</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    
<% for (int i = 0; i < datos_usuario.size(); i++) { 
	
	int estado = datos_usuario.get(i).getCod_estado();
	int firma = datos_usuario.get(i).getEstado_firma();
	String nombre = datos_usuario.get(i).getNom_persona();
	String apellidos = datos_usuario.get(i).getApell_persona();
	String usuario = datos_usuario.get(i).getUsuario();
	String rol = datos_usuario.get(i).getRol();

%>    
      <td><%=  firma %></td>
      <td><%=  estado %></td>
      <td><%=  nombre+" "+apellidos %></td>
      <td><%=  usuario %></td>
      <td><%=  rol %></td>
      <td>@mdo</td>
      
<% } %>      
      
    </tr>

  </tbody>
</table>
</div>



<div style="position: absolute;right: 3rem;">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Usuarios</h5>
    <h6 class="card-subtitle mb-2 text-muted"><img width="15px" src="img/menu/about.png"/> Modulo: Seguridad</h6>
    <p class="card-text">Listado de usuarios con acceso a los privilegios de SISCO</p>
    <a href="seguridad?url=nuevoUsuario" id="a_link"><img width="20px" src="img/menu/nuevo_cierre.png"/> Agregar Usuario</a>
  </div>
</div>
</div>
</body>
</html>