<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>




<%
String txtFechaPlanilla = "txtFechaPlanilla";

String selectServPlanilla = "selectServPlanilla";
String selectResponPlanilla = "selectResponPlanilla";

VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");

//DEFINIENDO LAS OPCIONES DE LOS ROLES
int getRolColabor = (int) session.getAttribute("mi_rol");
LinkedList<VTmenu> menuColabora = MenuDAO.datosMenu(getRolColabor);

//LISTADO DE PERSONAS
LinkedList<Personas> datos_per = PersonasDAO.listarPersonas();



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



// CANTIDAD DE SOBRES
VTtempoSobresPlanilla cant_sobres = SobresPlanillasDAO.contarSobres();
int sobres = cant_sobres.getCod_sobre();




// SUMA DIEZMOS
VTtempoSobresPlanilla sum_diezmos = SobresPlanillasDAO.sumarDiezmos();
int diezmos = sum_diezmos.getDiezmos();

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
					<strong><small>Fecha planilla: <%=fecha_planilla%></small></strong>
					
						<div>						
							<img width="20px" src="img/menu/auditoria.png" />
							<small><%=nom_contador%></small>
						</div>
						<small>Contador Responsable</small>


						<%
						if (fecha_planilla != null) {
						%>
						<br> <br> <strong>Responsables del conteo</strong>
						
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
							<small><%=nom_colabora1%></small>
							<%
							}
							%>
						</div>
						<div>
							<%
							if (cod_colabora2 > 0) {
							%>
							<img width="20px" src="img/menu/colabolador.png" />
							<small><%=nom_colabora2%></small>
							<%
							}
							%>
						</div>
						<div>
							<%
							if (cod_colabora3 > 0) {
							%>
							<img width="20px" src="img/menu/colabolador.png" />
							<small><%=nom_colabora3%></small>
							<%
							}
							%>
						</div>


						<%
						}

						}
						%>

									
						<br> 
						<div>
							<img width="20px" src="img/menu/desblock.png" />
							<small>${usuario.getNom_persona()}</small>
						</div>
						<small>Usuario que genera</small>
						<br><br>
					</div>
					
<small><%=servicio%> -	<%=hora%></small>
				</div>

			</div>
		</div>


		<!--  Layaout Derecho -->

		<div class="layout_right">

	



	

			<form action="${pageContext.request.contextPath}/planillas"
				method="post">


				<div class="input-group">
<input required class="form-control" name="txtNombrePersona" list="datalistOptions" id="exampleDataList" placeholder="Ingresa el nombre del aportante" autocomplete="off">
<datalist id="datalistOptions">

<%for (int x = 0; x < datos_per.size(); x++) { 

	String nom_persona = datos_per.get(x).getNom_persona();
%>
  <option value="<%=nom_persona %>">
<% }%>
 
</datalist>


					<%
					for (int y = 0; y < menuColabora.size(); y++) {

						int param = menuColabora.get(y).getCod_modulo();
						String opcion = menuColabora.get(y).getOpcion();
						String icon = menuColabora.get(y).getIcon_menu();
						String link = menuColabora.get(y).getLink_menu();
						int tipo = menuColabora.get(y).getCod_enlace();

						if (param == 12 && tipo == 0 && opcion == "Agregar") { // opciones de colaboradores, enlace tipo modal=0
					%>
					<span class="input-group-text"> <a href="#"
						data-bs-toggle="modal" data-bs-target="#<%=link%>" data-bs-url="redirectColaboradores"
						 data-bs-canc="planillas?url=add"
						 data-bs-modl="agregarColaborador"
						><img
							width="25px" src="img/menu/<%=icon%>.png" /></a> <%
 }
 }
 %>


					</span> <span class="input-group-text"> <%
 for (int y = 0; y < menuColabora.size(); y++) {

 	int param = menuColabora.get(y).getCod_modulo();
 	String opcion = menuColabora.get(y).getOpcion();
 	String icon = menuColabora.get(y).getIcon_menu();
 	String link = menuColabora.get(y).getLink_menu();
 	int tipo = menuColabora.get(y).getCod_enlace();

 	if (param == 12 && tipo == 0) { // opciones de colaboradores, enlace tipo modal=0
 %> <a href="#" data-bs-toggle="modal" data-bs-target="#<%=link%>" 
 data-bs-url="redirectColaboradores"
 data-bs-canc="planillas?url=add"
 data-bs-modl="getIdentificacion"
 data-bs-doc="data-bs-getDoc"
 ><img
							width="25px" src="img/menu/<%=icon%>.png" /></a> <%
 }
 }
					 %>

		<img width="25px" src="img/menu/especial.png" />		
				</div>

				<hr>
				



<!-- CONTENT  -->

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtDiezmos" class="form-control-sm" placeholder="Diezmos" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtOfrendas" class="form-control-sm" placeholder="Ofrendas" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtNecesitados" class="form-control-sm" placeholder="Necesitados" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtMercados" class="form-control-sm" placeholder="Mercados" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtConstruccion" class="form-control-sm" placeholder="Construcción" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtMisiones" class="form-control-sm" placeholder="Misiones" aria-label="Username" aria-describedby="basic-addon1">
</div>





		
			
				<div class="bts_sobres">
			<div>
<span class="badge btn-secondary">Compartir planilla</span>
<span class="badge bg-danger">Eliminar planilla</span>
</div>
<br>
<br>		
				
		    <input type="hidden" name="validar"	value="agregarSobre">
		
			<div style="text-align:center">
			<button type="subbmit" class="btn btn-primary btn-lg">Agregar sobre</button>
			<button type="subbmit" class="btn btn-success btn-lg">Finalizar ingreso</button>
			</div>
			
<hr>
<div class="cant_sobres">
<%=sobres %>
</div>


	</form>
	

		</div>

</div>


	</div>




	<div style="position: absolute; right: 3rem;">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Resumen de ingresos</h5>
				
			<table class="table">

  <tbody>
    <tr>
      <th scope="row">Diezmos</th>
      <td>$<%=diezmos %></td>
      
    </tr>
    <tr>
      <th scope="row">Ofrendas</th>
      <td>$0</td>
     
    </tr>
    <tr>
      <th scope="row">Necesitados</th>
      <td>$0</td>      
    </tr>
        <tr>
      <th scope="row">Mercados</th>
      <td>$0</td>      
    </tr>
        <tr>
      <th scope="row">Construcción</th>
      <td>$0</td>      
    </tr>
        <tr>
      <th scope="row">Misiones</th>
      <td>$0</td>      
    </tr>
        <tr>
      <th scope="row">Otros</th>
      <td>$0</td>      
    </tr>
        <tr>
      <th scope="row">TOTAL</th>
      <td>$0</td>      
    </tr>
  </tbody>
</table>
			</div>
		</div>
	</div>
</body>
</html>



<%@ include file="../modal/validarDocumento.jsp"%>
<%@ include file="../modal/listarColaboradores.jsp"%>

<%@ include file="../js/scriptUsuarios.jsp"%>
<%@ include file="../js/scriptPersonas.jsp"%>
