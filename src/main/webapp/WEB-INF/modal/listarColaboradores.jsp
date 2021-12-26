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
LinkedList<Colaboradores> mostrar_colabora = ColaboradoresDAO.mostrarColaboradores();
%>



<div class="modal fade" id="listarColaboradores" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Listado
					colaboradores del conteo</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">



				<div id="table-wrapper">
					<div id="table-scroll">
						<table class="table">
							<thead>
								<tr>
									<th scope="col"><span class="text">Nombre y
											apeliidos</span></th>
									<th scope="col"><span class="text">Identificación</span></th>
									<th scope="col"><span class="text">Block</span></th>
								</tr>
							</thead>
							<tbody>


								<%
								String estado = null;
								for (int i = 0; i < mostrar_colabora.size(); i++) {

									int cod_colabora = mostrar_colabora.get(i).getCod_colabora();
									String nom_colabora = mostrar_colabora.get(i).getNom_colabora();
									String doc_colabora = mostrar_colabora.get(i).getDoc_colabora();
									int estado_colabora = mostrar_colabora.get(i).getEstado_colabora();

									if (estado_colabora == 0) {

										estado = "desbloquearColaborador";

									} else {
										estado = "bloquearColaborador";
									}
								%>

								<tr>

									<td><%=nom_colabora%></td>
									<td><%=doc_colabora%></td>
									<td>


										<form action="${pageContext.request.contextPath}/planillas"
											method="post">
											<div>
												<button type="submit" class="btn btn-link">

													<%
													if (estado_colabora == 1) {
													%>
													<img width="18px" src="img/menu/bloquear.png" />
													<%
													} else {
													%>
													<img width="18px" src="img/menu/activado.png" />
													<%
													}
													%>
												</button>
											</div>
											<input type="hidden" name="txtCodColabora"
												value="<%=cod_colabora%>"> <input type="hidden"
												name="txtEstadoColabora" value="<%=estado_colabora%>">
											<input type="hidden" name="validar" value="<%=estado%>">
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
				<hr>
				<div>
					<img width="18px" src="img/menu/bloquear.png" /> Bloquear
					colaborador
				</div>
				<div>
					<img width="18px" src="img/menu/activado.png" /> Habilitar
					colaborador
				</div>
			</div>

		</div>

	</div>
</div>



<%@ include file="../js/scriptPlanillas.jsp"%>