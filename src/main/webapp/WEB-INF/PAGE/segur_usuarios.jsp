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
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Firma</th>
					<th scope="col">Estado</th>
					<th scope="col">Nombre</th>
					<th scope="col">Usuario</th>					
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>


				<% for (int i = 0; i < datos_usuario.size(); i++) { 
	
	int cod_persona = datos_usuario.get(i).getCod_persona();
	int estado = datos_usuario.get(i).getCod_estado();
	int firma = datos_usuario.get(i).getEstado_firma();
	String nombre = datos_usuario.get(i).getNom_persona();
	String apellidos = datos_usuario.get(i).getApell_persona();
	String usuario = datos_usuario.get(i).getUsuario();
	String rol = datos_usuario.get(i).getRol();

%>
				<tr>
					<td>
					<% if (firma==1){ %>
					<img width="25px" src="img/menu/firma.png" />
					<% }else{ %> 
					Sin asignar
					<% } %>
					
					</td>
					<td>
					
					<% if (estado==1) { %>					
					<img width="25px" src="img/menu/desblock.png" />
					<% } else { %>	
					<img width="25px" src="img/menu/block.png" />
					<% }  %>	
					
					
					</td>
					<td><%=  nombre+" "+apellidos %></td>
					<td><%=  usuario %></td>					
					<td><%=  rol %></td>
					<td>

						<nav class="navbar navbar-expand-lg navbar-light" id="nav-link">
							<div class="container-fluid">
								<button class="navbar-toggler" type="button"
									data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
									aria-controls="navbarNavDropdown" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
								<div class="collapse navbar-collapse" id="navbarNavDropdown">
									<ul class="navbar-nav">

										<li class="nav-item dropdown"><a
											class="nav-link dropdown-toggle" href="#" id="navbar"
											role="button" data-bs-toggle="dropdown" aria-expanded="false">
												<img width="18px" src="img/menu/config.png" /> Opciones
										</a>
											<ul class="dropdown-menu"
												aria-labelledby="navbarDropdownMenuLink">



												<li>
													<%
       
      
       LinkedList<VTmenu> submenu = MenuDAO.datosMenu(getRol);
       
       
       
      	for (int x = 0; x < menu.size(); x++) {

      		
    		int param = submenu.get(x).getCod_modulo();
    		String opcion = submenu.get(x).getOpcion();
    		String icon = submenu.get(x).getIcon_menu();
    		String link = submenu.get(x).getLink_menu();
    		int tipo = submenu.get(x).getCod_enlace();
    		
    		if(param==10 && tipo==0){ // opciones de usuarios, enlace tipo modal    		
    		%> <a href="#" class="dropdown-item"
				data-bs-toggle="modal" data-bs-target="#<%= link %>"
				data-bs-cod-persona="<%= cod_persona %>" > <img
				width="18px" src="img/menu/<%= icon %>.png" /> <%= opcion %></a>

				<%
 			}else{ 
 			
 				if(param==10 && tipo != 0){
 			%>
 				<a href="seguridad?url=<%= link %>&id=<%= cod_persona %>" class="dropdown-item"> <img
				width="18px" src="img/menu/<%= icon %>.png" /> <%= opcion %></a>
 				
 	<%		}
 		}
 }
 %>


												</li>

											</ul></li>
									</ul>
								</div>
							</div>
						</nav>

					</td>
				</tr>
				<%
				}
				%>



			</tbody>
		</table>
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


<%@ include file="../modal/asignarContador.jsp"%>
<%@ include file="../modal/eliminarUsuario.jsp"%>
<%@ include file="../js/scriptUsuarios.jsp"%>





