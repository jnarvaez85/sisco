<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>



<%
VTcontadores contador = (VTcontadores) request.getAttribute("contador");

String nombre_contador = contador.getNom_contador();
int cod_persona = contador.getCod_persona();
int estado = contador.getCod_estado();

String funciones = "Los usuarios con rol de contador serán responsables de los cuadres, movimientos de ingresos y egresos, y la firma de nominas 	y cuentas de cobro entre otras responsabilidades.";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>



	<div class="div_content">

		<%
		if (nombre_contador != null && estado==1) {
		%>

		<h2>
			<img width="50px" src="img/menu/perfil.png" />
			<%=nombre_contador%>
			es actualmente contador
		</h2>


		<div>
			<%=funciones%>
		</div>

		<p>
		
		<form action="${pageContext.request.contextPath}/seguridad" method="post">
		<div style="text-align: center;">
		
		
		<input type="hidden" name="txtCodPersona" value="<%= cod_persona %>">
		<input type="hidden" name="validar" value="deshabilitarContador"> 
			<button type="submit" class="btn btn-danger">Deshabilitar
				como contador</button>
		</form>		
		</div>
		<hr>
		<small>*Al deshabilitar como contador, el usuario será eximido
			de estas funciones, más sin embargo el sistema deja registrado en
			detalle las acciones realizadas como contador o revisor mientras su
			usuario estuvo activo en sus funciones.</small>



		<%
		} else {
		%>

		<h2>Asignar usuario contador</h2>
		<%=funciones%>

		<p>
		<div style="text-align: center;">
			<button type="submit" class="btn btn-success">Habilitar como
				contador</button>
			<hr>
			<div class="input-group flex-nowrap" style="width: 180px;margin: auto;">
				<input minlength="1" maxlength="4" onkeypress="return valideKey(event);" type="text" class="form-control" placeholder="Digite clave contador"
					aria-label="Username" aria-describedby="addon-wrapping">
					
			</div>
			<small>La clave permitida solo son cuatro (4) digitos numericos</small>
		</div>

		<%
		}
		%>

	</div>



	<div style="position: absolute; right: 3rem;">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Asignar contador</h5>
				<h6 class="card-subtitle mb-2 text-muted">
					<img width="15px" src="img/menu/about.png" /> Modulo: Seguridad
				</h6>
				<p class="card-text">Agrega al usuario con rol de contador o
					revisor de planillas</p>
				<a href="seguridad?url=usuarios" id="a_link"><img width="20px"
					src="img/menu/list.png" /> Lista usuarios</a>
			</div>
		</div>
	</div>
</body>
</html>









