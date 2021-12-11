<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>


<%
VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");

//DATOS TEMPORALES DE PLANILLAS
final int tmp_plan=1;
VTtempoDatosPlanilla tmp_dato_planilla = TempoDatosPlanillaDAO.consultarDatosPlanillaTemp(tmp_plan);

		String nom_contador = tmp_dato_planilla.getNom_contador();
		String nom_colabora1 = tmp_dato_planilla.getNom_colabora1();
		String nom_colabora2 = tmp_dato_planilla.getNom_colabora2();
		String nom_colabora3 = tmp_dato_planilla.getNom_colabora3();
		
		Date fecha_planilla = tmp_dato_planilla.getFecha_planilla();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


	<div class="div_content">
		<div class="col-md-3">


			<!--  Layaout Izquierdo -->

			<div class="container">
				<div class="row">
					<div>
						<div>
							<img width="20px" src="img/menu/auditoria.png" /> 
							<%= nom_contador %>
						</div>
						<small>Contador Responsable</small> 
						
						
						<% if(fecha_planilla != null){ %>
						<br> <br> <strong>Responsables	del conteo</strong>
						<p>
						
						
						<% if(nom_colabora1==null && nom_colabora2==null && nom_colabora3==null) {	%>
						
						<div style="text-align:center">
						<img width="60px" src="img/menu/alert.png" /></div>
						<div style="text-align:center">
						<small >Debe seleccionar al menos un (1) colaborador responsable</small>
						</div>
						
						<% } else{ %>
						
						
						<div>
							<img width="20px" src="img/menu/colabolador.png" /> RAFAEL
							CALDERON
						</div>
						<div>
							<img width="20px" src="img/menu/colabolador.png" /> OLIVIA
							OLIVERA
						</div>
						<div>
							<img width="20px" src="img/menu/colabolador.png" /> RODRIGO
							PRADA
						</div>
						
						
						<% } 
						
					}
						
						%>
						

						<br> <br> <br>
						<div>
							<img width="20px" src="img/menu/desblock.png" />
							${usuario.getNom_persona()} ${usuario.getApell_persona()}
						</div>
						<small>Usuario que genera</small>
					</div>

				</div>

			</div>
		</div>


		<!--  Layaout Derecho -->

		<div class="layout_right">

			<% if(fecha_planilla != null){ %>
			
			<div>Fecha de la planilla: <%=fecha_planilla %></div>
			<div>Servicio: Tercera Escuela Dominical - 06:00am a 10:00am</div>
			
			<% }else{ %>

			<div>Por favor seleccione una fecha y un servicio </div>
			
			<% } %>

			<br>
			<form class="row g-3">
				<div class="input-group mb-3" style="width: 35%;">
					<span class="input-group-text" id="basic-addon3"><img
						width="20px" src="img/menu/fecha.png" /></span> <input type="date"
						class="form-control" id="staticEmail2" value="email@example.com">
				</div>
				<div class="col-auto">
					<label for="inputPassword2" class="visually-hidden">Password</label>
					<select class="form-select" aria-label="Default select example">


						<!-- COMBO DE LOS SERVICIOS  -->

						<option selected>-- Seleccionar servicio --</option>
						<%
						for (int i = 0; i < datos_servicios.size(); i++) {
							String nom_servicio = datos_servicios.get(i).getNom_servicio();
							int cod_servicio = datos_servicios.get(i).getCod_servicio();
						%>
						<option value="<%=cod_servicio%>"><%=nom_servicio%></option>

						<%
						}
						%>
					</select>
				</div>

				<div class="col-auto">
					<div>
						<img width="25px" src="img/menu/action_mas.png" /> <img
							width="25px" src="img/menu/btn_buscar.png" />
						<button type="button" class="btn btn-secondary btn-sm">Agregar</button>
					</div>
				</div>

			</form>

			<hr>

			<!-- COMBO DE LOS  RESPONSABLES DEL CONTEO -->
			
			
			<% if(fecha_planilla != null){ %>
			

			<div class="input-group">
				<select class="form-select form-select-sm"
					aria-label=".form-select-sm example">
					<option selected>-- Seleccione el nombre del responsable
						--</option>


					<%
					for (int i = 0; i < datos_colaborador.size(); i++) {
						String nom_colaborador = datos_colaborador.get(i).getNom_colabora();
						int cod_colabora = datos_colaborador.get(i).getCod_colabora();
					%>
					<option value="<%=cod_colabora%>"><%=nom_colaborador%></option>

					<%
					}
					%>


				</select> <span class="input-group-text"><img width="25px"
					src="img/menu/action_mas.png" /></span> <span class="input-group-text"><img
					width="25px" src="img/menu/btn_buscar.png" /></span> <span
					class="input-group-text"><button type="button"
						class="btn btn-secondary btn-sm">Seleccionar</button></span>
			</div>
			<small>Elija min un (1) o max (3) responsables del conteo</small>

			<hr>
			<br>
			
			<% } %>

			<!-- FOOTER  -->
			
			<% if(fecha_planilla != null){ %>

			<button type="button" class="btn btn-danger">Cancelar</button>
			<button type="button" class="btn btn-primary">Continuar</button>
			
			<% } %>
		</div>



	</div>




	<div style="position: absolute; right: 3rem;">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Nueva Planillas</h5>
				<h6 class="card-subtitle mb-2 text-muted">
					<img width="15px" src="img/menu/about.png" /> Modulo: Planillas
				</h6>
				<p class="card-text">Permite generar el ingreso de sobres para
					una nueva planilla de cuadre</p>
				<a href="#" id="a_link"><img width="20px"
					src="img/menu/buscar.png" /> Consultar planilla</a>
			</div>
		</div>
	</div>
</body>
</html>