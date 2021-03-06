<%@ include file="../../CONTENT/lib.jsp"%>
<%@ include file="../../CONTENT/title.jsp"%>
<%@ include file="../../CONTENT/header.jsp"%>
<%@ include file="../../CONTENT/funciones.jsp"%>
<%@ include file="../../CONTENT/consultas.jsp"%>


<% if (request.getAttribute("alert") == "103") { %>
<jsp:include page="/WEB-INF/ALERT/agregarValorSobre.jsp" />
<% } %>

<% if (request.getAttribute("alert") == "104") { %>
<jsp:include page="/WEB-INF/ALERT/agregarValorDinero.jsp" />
<% } %>

<%
String txtFechaPlanilla = "txtFechaPlanilla";

String selectServPlanilla = "selectServPlanilla";
String selectResponPlanilla = "selectResponPlanilla";

VTusuarios usuarios = (VTusuarios) request.getAttribute("usuario");


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



//LISTADO DINERO
LinkedList<TempoDineroPlanilla> list_dinero = PlanillasDAO.listarDinero();

int estado_validacion			= list_dinero.get(0).getEstado();

int b_cien			= list_dinero.get(0).getB_cien(); 
int b_cincuenta		= list_dinero.get(0).getB_cincuenta();  
int b_veinte		= list_dinero.get(0).getB_veinte();  
int b_diez			= list_dinero.get(0).getB_diez();  
int b_cinco			= list_dinero.get(0).getB_cinco();  
int b_dos			= list_dinero.get(0).getB_dos();  
int b_mil			= list_dinero.get(0).getB_mil(); 	 

int m_mil			= list_dinero.get(0).getM_mil(); 		 
int m_quiniento		= list_dinero.get(0).getM_quiniento();  
int m_dos			= list_dinero.get(0).getM_dos(); 		 
int m_cien			= list_dinero.get(0).getM_cien();  
int m_cincuenta		= list_dinero.get(0).getM_cincuenta();


int total_billetes 	= b_cien+ b_cincuenta+ b_veinte+ b_diez+ b_cinco+ b_dos+ b_mil;
int total_monedas 	= m_mil+ m_quiniento+ m_dos+ m_cien+ m_cincuenta;
int total_ingreso	= total_billetes+ total_monedas;


int diferencia_cuadre	= total_ingreso - total;

int total_sueltos	= total_ingreso - total;

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

	



	

<form action="${pageContext.request.contextPath}/planillas"	method="post">


<!-- CONTENT  -->

<div class="container">
  <div class="row align-items-start">
    <div class="col">
    
    <strong>Billetes</strong>
    
      <div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_cien" id="cantidad_b_100" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_cien > 0){ %><%=b_cien/100000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="100000" id="total_b_100" />
  <input type="text" name="txtb_cien" class="form-control-sm b_cien" placeholder="$100.000" id="aporte_b_100" readonly="readonly" value="<%if(b_cien > 0){ %><%=b_cien%><%}%>">

<button type="button" class="btn btn-light" id="cl_b_cien"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
</div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_cincuenta" id="cantidad_b_50" onkeypress='return isNumberKey(event)' placeholder="0" value="<%if(b_cincuenta > 0){ %><%=b_cincuenta/50000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="50000" id="total_b_50"  />
  <input type="text" name="txtb_cincuenta" class="form-control-sm b_cincuenta" placeholder="$50.000" id="aporte_b_50" readonly="readonly" value="<%if(b_cincuenta > 0){ %><%=b_cincuenta%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_cincuenta"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_veinte" id="cantidad_b_20" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_veinte > 0){ %><%=b_veinte/20000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="20000" id="total_b_20"  />
  <input type="text" name="txtb_veinte" class="form-control-sm b_veinte" placeholder="$20.000" id="aporte_b_20" readonly="readonly" value="<%if(b_veinte > 0){ %><%=b_veinte%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_veinte"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_diez" id="cantidad_b_10" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_diez > 0){ %><%=b_diez/10000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="10000" id="total_b_10"  />
  <input type="text" name="txtb_diez" class="form-control-sm b_diez" placeholder="$10.000" id="aporte_b_10" readonly="readonly" value="<%if(b_diez > 0){ %><%=b_diez%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_diez"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_cinco" id="cantidad_b_5" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_cinco > 0){ %><%=b_cinco/5000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="5000" id="total_b_5"  />
  <input type="text" name="txtb_cinco" class="form-control-sm b_cinco" placeholder="$5.000" id="aporte_b_5" readonly="readonly" value="<%if(b_cinco > 0){ %><%=b_cinco%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_cinco"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_dos" id="cantidad_b_2" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_dos > 0){ %><%=b_dos/2000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="2000" id="total_b_2"  />
  <input type="text" name="txtb_dos" class="form-control-sm b_dos" placeholder="$2.000" id="aporte_b_2" readonly="readonly" value="<%if(b_dos > 0){ %><%=b_dos%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_dos"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control b_mil" id="cantidad_b_1" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(b_mil > 0){ %><%=b_mil/1000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="1000" id="total_b_1"  />
  <input type="text" name="txtb_mil" class="form-control-sm b_mil" placeholder="$1.000" id="aporte_b_1" readonly="readonly" value="<%if(b_mil > 0){ %><%=b_mil%><%}%>">
<button type="button" class="btn btn-light" id="cl_b_mil"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>
</div>    
    
    
    
    
    
    <div class="col">
    <strong>Monedas</strong>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control m_mil" id="cantidad_m_1" onkeypress='return isNumberKey(event)' placeholder="0" value="<%if(m_mil > 0){ %><%=m_mil/1000%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="1000" id="total_m_1"  />
  <input type="text" name="txtm_mil" class="form-control-sm m_mil" placeholder="$1.000" id="aporte_m_1" readonly="readonly" value="<%if(m_mil > 0){ %><%=m_mil%><%}%>">
<button type="button" class="btn btn-light" id="cl_m_mil"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control m_quiniento" id="cantidad_m_5" onkeypress='return isNumberKey(event)' placeholder="0" value="<%if(m_quiniento > 0){ %><%=m_quiniento/500%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="500" id="total_m_5"  />
  <input type="text" name="txtm_quiniento" class="form-control-sm m_quiniento" placeholder="$500" id="aporte_m_5" readonly="readonly" value="<%if(m_quiniento > 0){ %><%=m_quiniento%><%}%>">
<button type="button" class="btn btn-light" id="cl_m_quiniento"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control m_dos" id="cantidad_m_2" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(m_dos > 0){ %><%=m_dos/200%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="200" id="total_m_2"  />
  <input type="text" name="txtm_dos" class="form-control-sm m_dos" placeholder="$200" id="aporte_m_2" readonly="readonly" value="<%if(m_dos > 0){ %><%=m_dos%><%}%>">
<button type="button" class="btn btn-light" id="cl_m_dos"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control m_cien" id="cantidad_m_100" onkeypress='return isNumberKey(event)' placeholder="0" value="<%if(m_cien > 0){ %><%=m_cien/100%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="100" id="total_m_100"  />
  <input type="text" name="txtm_cien" class="form-control-sm m_cien" placeholder="$100" id="aporte_m_100" readonly="readonly" value="<%if(m_cien > 0){ %><%=m_cien%><%}%>">
<button type="button" class="btn btn-light" id="cl_m_cien"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>

<div class="input-group mb-3">
  <span style="width:50px" id="basic-addon1">
  <input type="text"  class="form-control m_cincuenta" id="cantidad_m_50" onkeypress='return isNumberKey(event)'  placeholder="0" value="<%if(m_cincuenta > 0){ %><%=m_cincuenta/50%><%}%>" autocomplete="off">
  </span>
  <input type="hidden" value="50" id="total_m_50"  />
  <input type="text" name="txtm_cincuenta" class="form-control-sm m_cincuenta" placeholder="$50" id="aporte_m_50" readonly="readonly" value="<%if(m_cincuenta > 0){ %><%=m_cincuenta%><%}%>">
<button type="button" class="btn btn-light" id="cl_m_cincuenta"> <img width="20px" src="img/menu/btn_eliminar.png" /></button>
  </div>
  
  <hr>
 <button type="submit" class="btn btn-success">VALIDAR</button>
 
 <%if (diferencia_cuadre > 0) { %>
			<a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#aprobarPlanilla">APROBAR</a>
<%} %>

	<% if(btn_permiso == 1){ %>
			<a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#<%=btn_link%>">CANCELAR</a>
			<% } %>
  <p>
  
  
  <%if (diferencia_cuadre > 0) { %>
 <div><img width="20px" src="img/menu/check.png" /> <strong>La planilla esta cuadrada!</strong></div>
 
 <%}else{ %> 
 
  <%if (estado_validacion!=0) { %>
 <div><img width="20px" src="img/menu/alert.png" /> <strong>Existe un descuadre de $<%=diferencia_cuadre * -1 %></strong></div> 
  <%} %>
 
 <%} %>
 
 <input type="hidden" name="validar"  value="validarCuadre"/>
 <input type="hidden" name="txtCodPlanilla"  value="1"/>
 <input type="hidden" name="txtEstadoValidacion"  value="1"/>   
 
 </form>
  
 </div>   
    
    
</div>
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
      <th scope="row">Total sobres ingresados</th>
      <td>$<%=total %></td>
      
    </tr>
    <tr>
      <th scope="row">Total Billetes ingresados</th>
      <td>$<%=total_billetes %></td>
     
    </tr>
    <tr>
      <th scope="row">Total Monedas ingresadas</th>
      <td>$<%=total_monedas %></td>      
    </tr>
    
      <%if (estado_validacion!=0) { %>
        <tr>
      <th scope="row">Total sueltos</th>
      <td>$<%=total_sueltos %></td>      
    </tr>
      <% } %>

        <tr>
      <th scope="row"></th>
      <td></td>      
    </tr>
        <tr>
      <th scope="row">TOTAL PLANILLA</th>
      <th>$<%=total_ingreso %></th>      
    </tr>
  </tbody>
  
  
</table>

			</div>
			
			
		</div>
	</div>
</body>
</html>






<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<%@ include file="../../modal/validarDocumento.jsp"%>
<%@ include file="../../modal/listarAportantes.jsp"%>
<%@ include file="../../modal/listarSobres.jsp"%>
<%@ include file="../../modal/agregarSobreEspecial.jsp"%>
<%@ include file="../../modal/cancelarPlanilla.jsp"%>
<%@ include file="../../modal/compartirPlanilla.jsp"%>
<%@ include file="../../modal/compartirPlanillaNO.jsp"%>
<%@ include file="../../modal/finalizarIngreso.jsp"%>
<%@ include file="../../modal/aprobarPlanilla.jsp"%>


<%@ include file="../../js/scriptUsuarios.jsp"%>
<%@ include file="../../js/scriptPersonas.jsp"%>
<%@ include file="../../js/scriptPersonas.jsp"%>

<%@ include file="../../jquery/calcularMonedas.jsp"%>
<%@ include file="../../jquery/functionsJavascript.jsp"%>




