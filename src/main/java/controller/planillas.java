package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import planillas.*;
import seguridad.*;


/**
 * @utor: Jairo Narvaez 2021
 * SISCO 3.0
 */
@WebServlet("/planillas")
public class planillas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public planillas() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
 // INICIO GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("url");

		if (accion != null) {
			switch (accion) {
			case "nuevaPlanilla":
				this.agregarPlanilla(request, response);
				break;
			case "add":
				this.agregarPlanillaGet(request, response);
				break;
			case "addSobres":
				this.agregarSobres(request, response);
				break;
			case "colaboladores":
				this.colaboladores(request, response);
				break;
			case "planillaCompartida":
				this.sharePlanilla(request, response);
				break;
				
			}
			
		} else {
			response.sendRedirect("error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

	private void agregarPlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_validaContador.jsp").forward(request, response);	
	}
	
	private void agregarPlanillaGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);	
	}
	
	private void agregarSobres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaSobres.jsp").forward(request, response);	
	}
	
	private void colaboladores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/colaboladores.jsp").forward(request, response);	
	}
	
	private void sharePlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_compartida.jsp").forward(request, response);	
	}	

	// FIN GET


	
	
	// INICIO POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("validar");
		
		switch (accion) {

		case "validarContador":
			validarContador(request, response);
			break;	
		case "agregarFechaPlanilla":
			agregarFechaPlanilla(request, response);
			break;
			
		case "agregarColaboladoresPlanillas":
			agregarColaboladoresPlanillas(request, response);
			break;
		
		case "eliminarTempoPlanilla":
			eliminarTempoPlanilla(request, response);
			break;
		case "agregarNuevoServicio":
			try {
				agregarNuevoServicio(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al insertar nuevo servicio: " + e);
				e.printStackTrace();
			}
			break;
		case "eliminarServicio":
			eliminarServicio(request, response);
			break;
		case "modificarServicio":
			try {
				modificarServicio(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al modificar servicio : " + e);
				e.printStackTrace();
			}
			break;
		case "agregarColaborador":
			try {
				agregarColaborador(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al agregar colaborador : " + e);
				e.printStackTrace();
			}
			break;
		case "bloquearColaborador":
			try {
				bloquearColaborador(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al bloquear colaborador : " + e);
				e.printStackTrace();
			}
			break;
		case "desbloquearColaborador":
			try {
				desbloquearColaborador(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al desbloquear colaborador : " + e);
				e.printStackTrace();
			}
			break;
		case "agregarSobre":
			try {
				agregarSobre(request, response);
			} catch (SQLException | IOException | ServletException e) {
				System.out.print("Error al agregar sobre : " + e);
				e.printStackTrace();
			}
			break;
			case "eliminarSobre":
			eliminarSobre(request, response);
			break;
			/*
		case "validarServicio":
			validarServicio(request, response);
			break;
			*/	
			case "compartirPlanilla":
				try {
					compartirPlanilla(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al compartir planilla : " + e);
					e.printStackTrace();
				}
				break;
			case "finalizarIngreso":
				try {
					finalizarIngreso(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al finalizar sobres de planilla : " + e);
					e.printStackTrace();
				}
				break;
		}
	
	}
	
	
	
	// Validar Contador
	private void validarContador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cod_persona = Integer.parseInt(request.getParameter("selectCodPersona"));
		String cod_contador = request.getParameter("txtCodContador");
		
		Contadores cont= new Contadores();
		ContadoresDAO contador= new ContadoresDAO();
		
		try {
			
			cont = contador.validarContador(cod_persona, cod_contador);
			
			if (cont.getCod_persona() == 1) {
				
				request.setAttribute("cod_persona", cont.getCod_persona());	   
				request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("WEB-INF/PAGE/no.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.print("Error al validar contador: " + e);
			e.printStackTrace();
		}
	}
	
	
	// Agregar Fecha Planilla
	private void agregarFechaPlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			VTtempoDatosPlanilla temPlanilla = new VTtempoDatosPlanilla();		
			
			temPlanilla.setCod_servicio(Integer.parseInt(request.getParameter("selectServPlanilla")));
			temPlanilla.setFecha_planilla(Date.valueOf(request.getParameter("txtFechaPlanilla")));
			int cursor= Integer.parseInt(request.getParameter("cursor"));	
			
			
			TempoDatosPlanillaDAO.preparaDatosPlanilla(temPlanilla, cursor);
			
		} catch (SQLException e) {
			System.out.print("Error al ingresar fecha y servicio en tempo planilla: " + e);
			e.printStackTrace();
		}	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);			
	
	}
	
	// Agregar colaboladores del conteo de Planilla
	
	
	private void agregarColaboladoresPlanillas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			VTtempoDatosPlanilla temPlanilla = new VTtempoDatosPlanilla();		
			
			temPlanilla.setCod_colabora1(Integer.parseInt(request.getParameter("selectResponPlanilla")));			
			int cursor= Integer.parseInt(request.getParameter("cursor"));	
			
			
			TempoDatosPlanillaDAO.preparaDatosPlanilla(temPlanilla, cursor);
			
		} catch (SQLException e) {
			System.out.print("Error al ingresar colaboladores en tempo planilla: " + e);
			e.printStackTrace();
		}	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);			
	
	}
	
	
	// Eliminar planilla temporal
	private void eliminarTempoPlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cod_temp_planilla = Integer.parseInt(request.getParameter("txtCodTempPlanilla"));
		try {
			TempoDatosPlanillaDAO.eliminarTempoPlanilla(cod_temp_planilla);
		} catch (SQLException e) {
			System.out.print("Error al eliminar planilla temporal: " + e);
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_validaContador.jsp").forward(request, response);			
	
	}
	
	
	// Agregar nuevo servicio
	private void agregarNuevoServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Servicios serv = new Servicios();
		ServiciosDAO servicio = new ServiciosDAO();	
		
		if(servicio.validarServicio(request.getParameter("txtNombreServicio")) == 0) {

		
		serv.setNom_servicio(request.getParameter("txtNombreServicio"));
		serv.setHora_servicio( request.getParameter("txtHoraServicio"));
		
		servicio.agregarServicio(serv);  	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);
		
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp");
			request.setAttribute("alert", "102");	
			dispatcher.forward(request, response);	

		}
	
	}
	
	// Eliminar Servicio
	private void eliminarServicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cod_servicio = Integer.parseInt(request.getParameter("txtCodServicio"));
		try {
			TempoDatosPlanillaDAO.eliminarServicio(cod_servicio);
		} catch (SQLException e) {
			System.out.print("Error al eliminar servicio: " + e);
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);			
	
	}
	
	
	// Modificar Servicio
	private void modificarServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		Servicios serv = new Servicios();
		ServiciosDAO servicio = new ServiciosDAO();	
		
		if(servicio.validarServicio(request.getParameter("txtNombreServicio")) == 0) {			
		
		serv.setCod_servicio(Integer.parseInt(request.getParameter("txtCodServicio")));
		serv.setNom_servicio(request.getParameter("txtNombreServicio"));
		serv.setHora_servicio(request.getParameter("txtHoraServicio"));
	
		TempoDatosPlanillaDAO.modificarServicio(serv);	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);	
		
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp");
			request.setAttribute("alert", "102");	
			dispatcher.forward(request, response);	
		}
	
	}
	
	// Agregar Colaborador
	private void agregarColaborador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		//Colaboradores colabora = new Colaboradores();
		ColaboradoresDAO colaborador = new ColaboradoresDAO();
		
		
		if(colaborador.validarColaborador(request.getParameter("txtIdentificacion")) == 0) {
	
		int cursor = Integer.parseInt(request.getParameter("cursor"));	
		int tipo_doc = Integer.parseInt(request.getParameter("selectTipoId"));		

		String doc_persona = request.getParameter("txtIdentificacion");
		String nom_persona = request.getParameter("txtNomColabora");
		String tel_persona = request.getParameter("txtTelColabora");
		String dir_persona = request.getParameter("txtDirColabora");
		
		colaborador.insertarColaborador(nom_persona, tipo_doc, doc_persona, dir_persona, tel_persona, cursor);    	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);
		
		
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp");
			request.setAttribute("alert", "103");	
			dispatcher.forward(request, response);	
			
		}
	
		
	
	}
	
	
	// Bloquear colaborador
	
	private void bloquearColaborador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
	
		
		Colaboradores editColabora = new Colaboradores();		
		
		editColabora.setCod_colabora(Integer.parseInt(request.getParameter("txtCodColabora")));
		editColabora.setEstado_colabora(Integer.parseInt(request.getParameter("txtEstadoColabora")));
	
		ColaboradoresDAO.bloquearColaborador(editColabora);
	
		
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);
	
	}
	
	
	// Desbloquear colaborador
	
	private void desbloquearColaborador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
	
		
		Colaboradores editColabora = new Colaboradores();		
		
		editColabora.setCod_colabora(Integer.parseInt(request.getParameter("txtCodColabora")));
		editColabora.setEstado_colabora(Integer.parseInt(request.getParameter("txtEstadoColabora")));
	
		ColaboradoresDAO.desbloquearColaborador(editColabora);
	
		
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);
	
	}
	
	
	
	// Agregar Sobres
		private void agregarSobre(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			TempoSobresPlanilla sobres = new TempoSobresPlanilla();
			SobresPlanillasDAO sobre = new SobresPlanillasDAO();
			
			String txtDiezmos= request.getParameter("txtDiezmos");
			String txtOfrendas= request.getParameter("txtOfrendas");
			String txtNecesitados= request.getParameter("txtNecesitados");
			String txtMercados= request.getParameter("txtMercados");
			String txtConstruccion= request.getParameter("txtConstruccion");
			String txtMisiones= request.getParameter("txtMisiones");
			
			
			if(txtDiezmos=="" && txtOfrendas=="" && txtNecesitados==""	&& txtMercados==""	
					&& txtConstruccion==""	&& txtMisiones==""
					
			) 	{
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaSobres.jsp");
				request.setAttribute("alert", "103");	
				dispatcher.forward(request, response);
				
			}else {
				

			String nom_persona = request.getParameter("txtNombrePersona");
			
			if(txtDiezmos=="") { txtDiezmos="0";}else {			
			sobres.setDiezmos(Integer.parseInt(txtDiezmos));}
			
			if(txtOfrendas=="") { txtOfrendas="0";}else {			
			sobres.setOfrendas(Integer.parseInt(txtOfrendas));}
			
			if(txtNecesitados=="") { txtNecesitados="0";}else {			
			sobres.setNecesitados(Integer.parseInt(txtNecesitados));}
			
			if(txtMercados=="") { txtMercados="0";}else {			
			sobres.setMercados(Integer.parseInt(txtMercados));}
			
			if(txtConstruccion=="") { txtConstruccion="0";}else {			
			sobres.setConstruccion(Integer.parseInt(txtConstruccion));}
			
			if(txtMisiones=="") { txtMisiones="0";}else {			
			sobres.setMisiones(Integer.parseInt(txtMisiones));}
			
			sobre.agregarSobre(nom_persona, sobres);    	
		
			request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaSobres.jsp").forward(request, response);
			
				
				}
				
			}
		
			
		// Eliminar Sobre
		private void eliminarSobre(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			int cod_sobre = Integer.parseInt(request.getParameter("txtCodigoSobre"));
			try {
				SobresPlanillasDAO.eliminarSobre(cod_sobre);
			} catch (SQLException e) {
				System.out.print("Error al eliminar sobre: " + e);
				e.printStackTrace();
			}
		
			//request.getRequestDispatcher("WEB-INF/PAGE/planillas?url=addSobres").forward(request, response);		
			response.sendRedirect("planillas?url=addSobres");
		
		}
		
		
		// Compartir Planilla
		private void compartirPlanilla(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			
			VTtempoDatosPlanilla comp = new VTtempoDatosPlanilla();
			//SobresPlanillasDAO compartir = new SobresPlanillasDAO();	
			
			
			comp.setCod_temp_planilla(Integer.parseInt(request.getParameter("txtCodPlanilla")));
			comp.setCompartida(Integer.parseInt(request.getParameter("txtCompartir")));
		
			SobresPlanillasDAO.compartirPlanilla(comp);	
		
			request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaSobres.jsp").forward(request, response);			
		
		}
		
		
		// Finalizar Ingreso
		
		private void finalizarIngreso(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		
			
			VTtempoDatosPlanilla finalizaIngreso = new VTtempoDatosPlanilla();		
			
			finalizaIngreso.setCod_temp_planilla(Integer.parseInt(request.getParameter("txtCodPlanilla")));
			finalizaIngreso.setEstado_planilla(Integer.parseInt(request.getParameter("txtEstadoPlanilla")));
		
			SobresPlanillasDAO.finalizarIngresos(finalizaIngreso);	
		
			
			request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDinero.jsp").forward(request, response);
		
		}
		


}
