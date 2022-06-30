<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--  Paquetes JAVA -->
<%@page import="admin.*"%>
<%@page import="seguridad.*"%>
<%@page import="planillas.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%> 
<%

//SERVICIOS
 LinkedList<SobresEspeciales> datos_conceptos = SobresPlanillasDAO.listarConceptosIngresos();
%>


<!-- Modal -->
<div class="modal fade" id="otrosIngresos" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><img width="20px" src="img/menu/share.png" /> Ingresos Especiales</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
<form class="row g-3 needs-validation" action="${pageContext.request.contextPath}/planillas" method="post" >

 <div>
 
 
 <div class="input-group">
 <select class="form-select"  name="selectConceptoEspecial" required>


						<!-- COMBO DE LOS SERVICIOS  -->

						<option selected value="">-- Seleccione el concepto --</option>
						<%
						for (int i = 0; i < datos_conceptos.size(); i++) {
							String nom_concepto_esp = datos_conceptos.get(i).getNom_sobre_especial();
							int cod_concepto_esp = datos_conceptos.get(i).getCod_especial();
						%>
						<option value="<%=nom_concepto_esp%>"><%=nom_concepto_esp%></option>

						<%
						}
						%>
					</select>
  <span class="input-group-text">
<a href="#" data-bs-toggle="modal" data-bs-target="#agregarConceptoIngreso"><img width="25px" src="img/menu/btn_mas.png" /></a> 

</span>

</div>
 
 
 
 


<br>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">$</span>
  <input type="text" name="txtEspeciales" class="form-control-sm" placeholder="Ingrese cant dinero" onkeypress='return isNumberKey(event)' autocomplete="off" required>
</div>

  </div>


      </div>
      <div class="modal-footer">      
      
        <button class="btn btn-primary" type="submit">GUARDAR</button>
        
  
        <input type="hidden"  name="validar" value="agregarSobreEspecial">
        
        </form>
      </div>
    </div>
  </div>
</div>


<%@ include file="../modal/agregarConceptoIngreso.jsp"%>

<%@ include file="../jquery/functionsJavascript.jsp"%>
