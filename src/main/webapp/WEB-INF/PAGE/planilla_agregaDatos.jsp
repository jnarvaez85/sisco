<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>



<% if(request.getAttribute("alert") == "101"){ %>
<jsp:include page="/WEB-INF/validate/agregarColaborador.jsp" />
<% } %>

<% if (request.getAttribute("alert") == "102") { %>
<jsp:include page="/WEB-INF/ALERT/servicioExiste.jsp" />
<% } %>

<% if (request.getAttribute("alert") == "103") { %>
<jsp:include page="/WEB-INF/ALERT/colaboradorExiste.jsp" />
<% } %>


<% if (request.getAttribute("alert") == "104") { %>
<jsp:include page="/WEB-INF/ALERT/noExistePersona.jsp" />
<% } %>








<%
String txtFechaPlanilla = "txtFechaPlanilla";

String selectServPlanilla = "selectServPlanilla";
String selectResponPlanilla = "selectResponPlanilla";

VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");

//DEFINIENDO LAS OPCIONES DE LOS ROLES
int getRolColabor = (int) session.getAttribute("mi_rol");


// Boton para cancelar planilla
// Recibe por parametro cod_menu
VTmenu btn_cancelar = MenuDAO.menuGeneral(getRolColabor, 44);

String btn_opcion = btn_cancelar.getOpcion();
String btn_link = btn_cancelar.getLink_menu();


//Opcion para Agregar colaboradores de planilla
// Recibe por parametro cod_menu
VTmenu btn_add_colabora = MenuDAO.menuGeneral(getRolColabor, 40);

int btn_add_colabora_permiso = btn_add_colabora.getPermiso();
String btn_add_colabora_icon = btn_add_colabora.getIcon_menu();
String btn_add_colabora_opcion = btn_add_colabora.getOpcion();
String btn_add_colabora_link = btn_add_colabora.getLink_menu();





//DATOS TEMPORALES DE PLANILLAS
final int tmp_plan = 1;
VTtempoDatosPlanilla tmp_dato_planilla = TempoDatosPlanillaDAO.consultarDatosPlanillaTemp(tmp_plan);

int cod_tmp_planilla = tmp_dato_planilla.getCod_temp_planilla();

String nom_contador = tmp_dato_planilla.getNom_contador();
int cod_colabora1 = tmp_dato_planilla.getCod_colabora1();
String nom_colabora1 = tmp_dato_planilla.getNom_colabora1();
int cod_colabora2 = tmp_dato_planilla.getCod_colabora2();
String nom_colabora2 = tmp_dato_planilla.getNom_colabora2();
int cod_colabora3 = tmp_dato_planilla.getCod_colabora3();
String nom_colabora3 = tmp_dato_planilla.getNom_colabora3();
int codigo_servicio = tmp_dato_planilla.getCod_servicio();

String servicio = tmp_dato_planilla.getNom_servicio();
String hora = tmp_dato_planilla.getHora_servicio();

String fecha_planilla = null;
Date format_fecha_planilla = tmp_dato_planilla.getFecha_planilla();

if (format_fecha_planilla != null) {
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	fecha_planilla = formatDate.format(format_fecha_planilla);

}

int cursor = 1;
%>

<%
if (fecha_planilla != null) {

	int contador = tmp_dato_planilla.getCont_colabora();
	cursor = contador;
}
%>




<%
// Deshabilita las opciones de la fecha y el servicio

String estado_habilita;
String estado_habilita2;

if (codigo_servicio > 0) {
	estado_habilita = "disabled";
} else {
	estado_habilita = "enable";
}

// Deshabilita las opciones de los responsable

if (cursor == 5) {
	estado_habilita2 = "disabled";
} else {
	estado_habilita2 = "enable";
}
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
							<%=nom_contador%>
						</div>
						<small>Contador Responsable</small>


						<%
						if (fecha_planilla != null) {
						%>
						<br> <br> <strong>Responsables del conteo</strong>
						<p>


							<%
							if (nom_colabora1 == null && nom_colabora2 == null && nom_colabora3 == null) {
							%>
						
						<div style="text-align: center">
							<img width="60px" src="img/menu/alert.png" />
						</div>
						<div style="text-align: center">
							<small>Debe seleccionar al menos un (1) colaborador
								responsable</small>
						</div>

						<%
						} else {
						%>


						<div>
							<%
							if (cod_colabora1 > 0) {
							%>
							<img width="20px" src="img/menu/colabolador.png" />
							<%=nom_colabora1%>
							<%
							}
							%>
						</div>
						<div>
							<%
							if (cod_colabora2 > 0) {
							%>
							<img width="20px" src="img/menu/colabolador.png" />
							<%=nom_colabora2%>
							<%
							}
							%>
						</div>
						<div>
							<%
							if (cod_colabora3 > 0) {
							%>
							<img width="20px" src="img/menu/colabolador.png" />
							<%=nom_colabora3%>
							<%
							}
							%>
						</div>


						<%
						}

						}
						%>


						<br> <br> <br>
						<div>
							<img width="20px" src="img/menu/desblock.png" />
							${usuario.getNom_persona()}
						</div>
						<small>Usuario que genera</small>
					</div>

				</div>

			</div>
		</div>


		<!--  Layaout Derecho -->

		<div class="layout_right">

			<%
			if (fecha_planilla != null) {
			%>

			<div style="font-size: 1.5em;">
				Fecha de la planilla:
				<%=fecha_planilla%></div>
			<div>
				Servicio:
				<%=servicio%>
				-
				<%=hora%></div>

			<%
			} else {
			%>

			<div>Por favor seleccione una fecha y un servicio</div>

			<%
			}
			%>

			<br>
			<form class="row g-3"
				action="${pageContext.request.contextPath}/planillas" method="post">
				<div class="input-group mb-3" style="width: 35%;">
					<span class="input-group-text"> <img width="20px"
						src="img/menu/fecha.png" /></span> <input type="date"
						max="<%=currentDate%>" class="form-control"
						name="<%=txtFechaPlanilla%>" <%=estado_habilita%> required>
				</div>
				<div class="col-auto">
					<label class="visually-hidden">Servicio</label> <select
						class="form-select" name="<%=selectServPlanilla%>"
						<%=estado_habilita%> required>


						<!-- COMBO DE LOS SERVICIOS  -->

						<option selected value="">-- Seleccionar servicio --</option>
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
					<div style="position: absolute;">
						<a href="#" data-bs-toggle="modal"
							data-bs-target="#agregarServicio"><img width="25px"
							src="img/menu/action_mas.png" /></a> <a href="#"
							data-bs-toggle="modal" data-bs-target="#listarServicios"><img
							width="25px" src="img/menu/btn_buscar.png" /></a>
						<button type="submit" class="btn btn-secondary btn-sm"
							<%=estado_habilita%>>Agregar</button>
					</div>
				</div>

				<input type="hidden" name="validar" value="agregarFechaPlanilla">
				<input type="hidden" name="cursor" value="<%=cursor%>">
			</form>

			<hr>

			<!-- COMBO DE LOS  RESPONSABLES DEL CONTEO -->


			<%
			if (fecha_planilla != null) {
			%>


			<form action="${pageContext.request.contextPath}/planillas"
				method="post">


				<div class="input-group">
					<select class="form-select form-select-sm" required
						name="<%=selectResponPlanilla%>" <%=estado_habilita2%>>
						<option selected value="">-- Seleccione el nombre del
							responsable --</option>


						<%
						for (int i = 0; i < datos_colaborador.size(); i++) {
							String nom_colaborador = datos_colaborador.get(i).getNombre_colaborador();
							int cod_colabora = datos_colaborador.get(i).getCod_colabora();
							int estado_cola = datos_colaborador.get(i).getCod_estado();
						%>
						<option value="<%=cod_colabora%>"><%=nom_colaborador%></option>

						<%
						}
						%>


					</select>





					</span> <span class="input-group-text"> 
 

 <%	if (btn_add_colabora_permiso == 1) { %> 
 
 	<a href="#" data-bs-toggle="modal" data-bs-target="#<%=btn_add_colabora_link%>" 
	 data-bs-url="redirectColaboradores"
	 data-bs-canc="planillas?url=add"
	 data-bs-modl="getIdentificacion"
	 data-bs-doc="data-bs-getDoc" >
	 <img width="25px" src="img/menu/<%=btn_add_colabora_icon%>.png" /></a> 
  
 <% } %>

					</span> <span class="input-group-text"><button type="sumbit"
							class="btn btn-secondary btn-sm" <%=estado_habilita2%>>Elegir</button></span>
				</div>
				<small>Elija min un (1) o max (3) responsables del conteo</small>

				<hr>
				<br>

				<%
				}
			%>



				<input type="hidden" name="validar"
					value="agregarColaboladoresPlanillas"> <input type="hidden"
					name="cursor" value="<%=cursor%>">
			</form>


			<!-- FOOTER  -->

			<%
			if (fecha_planilla != null) {
			%>

			<form action="${pageContext.request.contextPath}/planillas"
				method="post">
				<div style="float: left; margin-right: 2%;">			
				
					
			<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#<%=btn_link %>"><%=btn_opcion %></button>

			</div>

				<input type="hidden" name="validar" value="eliminarTempoPlanilla">
				<input type="hidden" name="txtCodTempPlanilla"
					value="<%=cod_tmp_planilla%>">
			</form>

			<%
			if (cursor >= 3) {
			%>
			<a href="${pageContext.request.contextPath}/planillas?url=addSobres"  class="btn btn-primary">Siguiente</a>

			<%
			}
			}
			%>
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



<%@ include file="../modal/validarDocumento.jsp"%>
<%@ include file="../modal/agregarServicio.jsp"%>
<%@ include file="../modal/listarServicios.jsp"%>
<%@ include file="../modal/listarColaboradores.jsp"%>
<%@ include file="../modal/agregarColaborador.jsp"%>
<%@ include file="../modal/cancelarPlanilla.jsp"%>


<%@ include file="../js/scriptUsuarios.jsp"%>
<%@ include file="../js/scriptPersonas.jsp"%>
