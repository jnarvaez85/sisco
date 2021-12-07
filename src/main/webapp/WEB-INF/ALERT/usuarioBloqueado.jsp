<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="div_content">
	<div>
	<div><img style="float:left" width="300px" src="img/vector/bloqueado.png" /></div>
	<h1>Usuario Bloqueado!</h1>
		El usuario ha sido Bloqueado temparalmente... <BR>
        A partir de ahora no podrá acceder al sistema mientras permanezca en su estado actual de Inactivo!
	</div>
	<hr>
	<div><a href="seguridad?url=usuarios" id="a_link"><img width="20px" src="img/menu/list.png"/> Regresar al listado</a></div>
</div>


	<div style="position: absolute; right: 3rem;">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Usuarios</h5>
				<h6 class="card-subtitle mb-2 text-muted">
					<img width="15px" src="img/menu/about.png" /> Modulo: Seguridad
				</h6>
				<p class="card-text">Listado de usuarios con acceso a los
					privilegios de SISCO</p>
				<a href="seguridad?url=validarExisteUsuario" id="a_link"><img
					width="20px" src="img/menu/nuevo_cierre.png" /> Agregar Usuario</a>
			</div>
		</div>
	</div>
</body>
</html>









