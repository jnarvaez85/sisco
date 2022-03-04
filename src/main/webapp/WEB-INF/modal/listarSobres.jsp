<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!--  Paquetes JAVA -->
<%@page import="planillas.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
LinkedList<VTtempoSobresPlanilla> listado_sobres = SobresPlanillasDAO.listarSobres();
%>




<div class="modal fade" id="listarSobres" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Listado
					de sobres ingresados</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">



				<div >
					<div id="table-scroll">
						<table class="table">
							<thead>
								<tr>
									<th scope="col"><span class="text">#</span></th>
									<th scope="col"><span class="text">Aportante</span></th>
									<th scope="col"><span class="text">Diezmos</span></th>
									<th scope="col"><span class="text">Ofrendas</span></th>
									<th scope="col"><span class="text">Necesitados</span></th>
									<th scope="col"><span class="text">Mercados</span></th>
									<th scope="col"><span class="text">Construccion</span></th>
									<th scope="col"><span class="text">Misiones</span></th>
									<th scope="col"><span class="text">Otros</span></th>
									<th scope="col"><span class="text">Especial</span></th>
									<th scope="col"><span class="text">TOTAL</span></th>
									<th scope="col"><span class="text">Quitar</span></th>
								</tr>
							</thead>
							<tbody>


						<%
								int count=1;
								for (int i = 0; i < listado_sobres.size(); i++) {
									
									int s= count ++;
									
									int sobre_codigo = listado_sobres.get(i).getCod_sobre();

									String sobre_persona = listado_sobres.get(i).getNom_persona();
									int sobre_diezmo = listado_sobres.get(i).getDiezmos();
									int sobre_ofrendas = listado_sobres.get(i).getOfrendas();
									int sobre_necesitados = listado_sobres.get(i).getNecesitados();
									int sobre_mercados = listado_sobres.get(i).getMercados();
									int sobre_construccion = listado_sobres.get(i).getConstruccion();
									int sobre_misiones = listado_sobres.get(i).getMisiones();
									int sobre_otros = listado_sobres.get(i).getOtros();
									int sobre_especial = listado_sobres.get(i).getEspecial();
									
									int total_sobres= sobre_diezmo+ sobre_ofrendas+ sobre_necesitados+ 
											sobre_mercados+ sobre_construccion+ sobre_misiones+	sobre_otros+ 
											sobre_especial;
									

								%>

								<tr>
									<td><%=s%></td>
									<td><%=sobre_persona%></td>
									<td>$<%=sobre_diezmo%></td>
									<td>$<%=sobre_ofrendas%></td>
									<td>$<%=sobre_necesitados%></td>
									<td>$<%=sobre_mercados%></td>
									<td>$<%=sobre_construccion%></td>
									<td>$<%=sobre_misiones%></td>
									<td>$<%=sobre_otros%></td>
									<td>$<%=sobre_especial%></td>
									<td>$<%=total_sobres%></td>
									<td>
									
									
									<form action="${pageContext.request.contextPath}/planillas"
											method="post">
									
									
									
									<button type="submit" class="btn btn-link">
									<img width="18px" src="img/menu/eliminar.png" />
									</button>
									
									<input type="hidden" name="validar" value="eliminarSobre">
									<input type="hidden" name="txtCodigoSobre" value="<%=sobre_codigo%>">
									</form>
									</td>	
									
									
									


								</tr>

								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			
		
			</div>

		</div>

	</div>
</div>



<%@ include file="../js/scriptPlanillas.jsp"%>