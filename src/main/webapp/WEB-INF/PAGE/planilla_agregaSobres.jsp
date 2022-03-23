<%@ include file="../CONTENT/lib.jsp"%>
<%@ include file="../CONTENT/title.jsp"%>
<%@ include file="../CONTENT/header.jsp"%>
<%@ include file="../CONTENT/funciones.jsp"%>
<%@ include file="../CONTENT/consultas.jsp"%>


<% if (request.getAttribute("alert") == "103") { %>
<jsp:include page="/WEB-INF/ALERT/agregarValorSobre.jsp" />
<% } %>

<%
String txtFechaPlanilla = "txtFechaPlanilla";

String selectServPlanilla = "selectServPlanilla";
String selectResponPlanilla = "selectResponPlanilla";

VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");

//DEFINIENDO LAS OPCIONES DE LOS ROLES
int getRolColabor = (int) session.getAttribute("mi_rol");

//Opcion para Agregar colaboradores de planilla
//Recibe por parametro cod_menu
VTmenu btn_add_colabora = MenuDAO.menuGeneral(getRolColabor, 40);

int btn_add_colabora_permiso = btn_add_colabora.getPermiso();
String btn_add_colabora_icon = btn_add_colabora.getIcon_menu();
String btn_add_colabora_opcion = btn_add_colabora.getOpcion();
String btn_add_colabora_link = btn_add_colabora.getLink_menu();


//Opcion para Agregar sobres especiales
VTmenu btn_add_especial = MenuDAO.menuGeneral(getRolColabor, 43);

int btn_add_especial_permiso = btn_add_especial.getPermiso();
String btn_add_especial_icon = btn_add_especial.getIcon_menu();
String btn_add_especial_opcion = btn_add_especial.getOpcion();
String btn_add_especial_link = btn_add_especial.getLink_menu();


//Opcion para compartir planilla
VTmenu btn_add_share = MenuDAO.menuGeneral(getRolColabor, 45);

int btn_add_share_permiso = btn_add_share.getPermiso();
String btn_add_share_opcion = btn_add_share.getOpcion();
String btn_add_share_link = btn_add_share.getLink_menu();

//Opcion para dejar de compartir planilla
VTmenu btn_add_no_share = MenuDAO.menuGeneral(getRolColabor, 46);

int btn_add_no_share_permiso = btn_add_no_share.getPermiso();
String btn_add_no_share_opcion = btn_add_no_share.getOpcion();
String btn_add_no_share_link = btn_add_no_share.getLink_menu();


//Boton para cancelar planilla
VTmenu btn_cancelar = MenuDAO.menuGeneral(getRolColabor, 44);

int btn_permiso = btn_cancelar.getPermiso();
String btn_opcion = btn_cancelar.getOpcion();
String btn_link = btn_cancelar.getLink_menu();

//Boton para finalizar ingreso planilla
VTmenu btn_finalizar = MenuDAO.menuGeneral(getRolColabor, 47);

int btn_finalizar_permiso = btn_finalizar.getPermiso();
String btn_finalizar_opcion = btn_finalizar.getOpcion();
String btn_finalizar_link = btn_finalizar.getLink_menu();


//LISTADO DE PERSONAS
LinkedList<Personas> datos_per = PersonasDAO.listarPersonas();



//DATOS TEMPORALES DE PLANILLAS
final int tmp_plan = 1;
VTtempoDatosPlanilla tmp_dato_planilla = TempoDatosPlanillaDAO.consultarDatosPlanillaTemp(tmp_plan);

int cod_tmp_planilla = tmp_dato_planilla.getCod_temp_planilla();
int compartida = tmp_dato_planilla.getCompartida();


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

//SUMA OFRENDAS
VTtempoSobresPlanilla sum_ofrendas = SobresPlanillasDAO.sumarOfrendas();
int ofrendas = sum_ofrendas.getOfrendas();

//SUMA NECESITADOS
VTtempoSobresPlanilla sum_necesitados = SobresPlanillasDAO.sumarNecesitados();
int necesitados = sum_necesitados.getNecesitados();

//SUMA MERCADOS
VTtempoSobresPlanilla sum_mercados = SobresPlanillasDAO.sumarMercados();
int mercados = sum_mercados.getMercados();

//SUMA CONSTRUCCION
VTtempoSobresPlanilla sum_construccion = SobresPlanillasDAO.sumarConstruccion();
int construccion = sum_construccion.getConstruccion();

//SUMA MISIONES
VTtempoSobresPlanilla sum_misiones = SobresPlanillasDAO.sumarMisiones();
int misiones = sum_misiones.getMisiones();

//SUMA OTROS
VTtempoSobresPlanilla sum_otros = SobresPlanillasDAO.sumarOtros();
int otros = sum_otros.getOtros();

//SUMA ESPECIAL
VTtempoSobresPlanilla sum_especial = SobresPlanillasDAO.sumarEspeciales();
int especial = sum_especial.getEspecial();



int total = diezmos+ ofrendas+ necesitados+ mercados+ construccion+ misiones+ otros+ especial;

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





 <%	if (btn_add_colabora_permiso == 1) { %> 
 
 	<a href="#" data-bs-toggle="modal" data-bs-target="#<%=btn_add_colabora_link%>" 
	 data-bs-url="redirectColaboradores"
	 data-bs-canc="planillas?url=add"
	 data-bs-modl="getIdentificacion"
	 data-bs-doc="data-bs-getDoc" >
	 <img width="25px" src="img/menu/<%=btn_add_colabora_icon%>.png" /></a> 
  
 <% } %>





 <a href="#" data-bs-toggle="modal" data-bs-target="#<%=btn_add_especial_link %>" 
 data-bs-url="redirectColaboradores"
 data-bs-canc="planillas?url=add"
 data-bs-modl="getIdentificacion"
 data-bs-doc="data-bs-getDoc"
 ><img width="25px" src="img/menu/<%=btn_add_especial_icon %>.png" /></a> 

</span> 
			
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

<% if (compartida == 0) { 

     if (btn_add_share_permiso == 1) {

%>

			
			
<a href="#" style="text-decoration: none;" class="badge btn-secondary" data-bs-toggle="modal" data-bs-target="#<%=btn_add_share_link %>"><%=btn_add_share_opcion %></a>

<% }
     
}else { 

	if (btn_add_no_share_permiso  == 1) {
%>	

<a href="#" style="text-decoration: none;" class="badge btn-secondary" data-bs-toggle="modal" data-bs-target="#<%=btn_add_no_share_link %>"><%=btn_add_no_share_opcion %></a>

<% } 
}
%>	


<% if(btn_permiso==1){ %>
<a href="#" style="text-decoration: none;" class="badge bg-danger" data-bs-toggle="modal" data-bs-target="#<%=btn_link %>"><%=btn_opcion  %></a>
<% } %>
</div>
<br>
<br>		
				
		    <input type="hidden" name="validar"	value="agregarSobre">
		
			<div style="text-align:center">
			<button type="subbmit" class="btn btn-primary btn-lg">Agregar sobre</button>
			
			
			<% if (btn_finalizar_permiso ==1) {%>
			<button type="subbmit" class="btn btn-success btn-lg"><%=btn_finalizar_opcion  %></button>
			<% } %>
			</div>
			
<hr>


	</form>
	

		</div>
		<a href="#" data-bs-toggle="modal" data-bs-target="#listarSobres">
<div class="cant_sobres">

<%=sobres %>

</div>
</a>

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
      <td>$<%=ofrendas %></td>
     
    </tr>
    <tr>
      <th scope="row">Necesitados</th>
      <td>$<%=necesitados %></td>      
    </tr>
        <tr>
      <th scope="row">Mercados</th>
      <td>$<%=mercados %></td>      
    </tr>
        <tr>
      <th scope="row">Construcción</th>
      <td>$<%=construccion %></td>      
    </tr>
        <tr>
      <th scope="row">Misiones</th>
      <td>$<%=misiones %></td>      
    </tr>
        <tr>
      <th scope="row">Otros</th>
      <td>$<%=otros %></td>      
    </tr>
        <tr>
      <th scope="row">TOTAL</th>
      <th>$<%=total %></th>      
    </tr>
  </tbody>
</table>
			</div>
		</div>
	</div>
</body>
</html>



<%@ include file="../modal/validarDocumento.jsp"%>
<%@ include file="../modal/listarAportantes.jsp"%>
<%@ include file="../modal/listarSobres.jsp"%>
<%@ include file="../modal/agregarSobreEspecial.jsp"%>
<%@ include file="../modal/cancelarPlanilla.jsp"%>
<%@ include file="../modal/compartirPlanilla.jsp"%>
<%@ include file="../modal/compartirPlanillaNO.jsp"%>


<%@ include file="../js/scriptUsuarios.jsp"%>
<%@ include file="../js/scriptPersonas.jsp"%>
