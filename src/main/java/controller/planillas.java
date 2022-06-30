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
import admin.*;
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
		
		
		// CONTROLA QUE NO EJECUTE NINGUNA ACCION CUANDO EL TIEMPO DE INACTIVIDAD SE CUMPLA
		String accion = null;
		HttpSession session= request.getSession(true);

		if (session.getAttribute("usuario") != null) {
			accion = request.getParameter("url");
		}else{
			
			response.sendRedirect("expired");
			
			
		}
		
		

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
			case "validarIngreso":
				this.validarIngreso(request, response);
				break;
			case "validaContador":
				this.validaContador(request, response);
				break;
				
			}
			
		} 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

	private void agregarPlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_validaContador.jsp").forward(request, response);	
	}
	
	private void agregarPlanillaGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);	
	}
	
	private void agregarSobres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp").forward(request, response);	
	}
	
	private void colaboladores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/colaboladores.jsp").forward(request, response);	
	}
	
	private void sharePlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_compartida.jsp").forward(request, response);	
	}
	
	private void validarIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDinero.jsp").forward(request, response);	
	}
	
	private void validaContador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_validaContador.jsp").forward(request, response);	
	}

	// FIN GET


	
	
	// INICIO POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		
		// CONTROLA QUE NO EJECUTE NINGUNA ACCION CUANDO EL TIEMPO DE INACTIVIDAD SE CUMPLA
		String accion = null;
		HttpSession session= request.getSession(true);

		if (session.getAttribute("usuario") != null) {
			accion = request.getParameter("validar");
		}else{
			
			response.sendRedirect("expired");
			
			
		}
		
		
		
		
	if (accion != null) {
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
			case "validarCuadre":
				try {
					validarCuadre(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al validar cuadre : " + e);
					e.printStackTrace();
				}
				break;
			case "aprobarPlanilla":
				try {
					aprobarPlanilla(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al aprobar planilla : " + e);
					e.printStackTrace();
				}
			case "agregarNuevoConceptoIngreso":
				try {
					agregarNuevoConceptoIngreso(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al insertar nuevo concepto de ingreso: " + e);
					e.printStackTrace();
				}
				break;
			case "agregarSobreEspecial":
				try {
					agregarSobreEspecial(request, response);
				} catch (SQLException | IOException | ServletException e) {
					System.out.print("Error al insertar nuevo sobre especial: " + e);
					e.printStackTrace();
				}
				break;
		}
	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
				
				contador.insertarContador(cod_persona);
				
				request.setAttribute("cod_persona", cont.getCod_persona());	   
				request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);

			} else {				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_validaContador.jsp");
				request.setAttribute("alert", "102");	
				dispatcher.forward(request, response);	
				
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);			
	
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);			
	
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_validaContador.jsp").forward(request, response);			
	
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);
		
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp");
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);			
	
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);	
		
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp");
			request.setAttribute("alert", "102");	
			dispatcher.forward(request, response);	
		}
	
	}
	
	// Agregar Colaborador
	private void agregarColaborador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		ColaboradoresDAO colaborador = new ColaboradoresDAO();
		PersonasDAO persona = new PersonasDAO();
		
		String nom_colaborador = request.getParameter("txtNomColabora");
		
		if((colaborador.validarColaborador(request.getParameter("txtIdentificacion")) == 0)
		&& persona.validarNombrePersona(nom_colaborador)==0) {
	
		int cursor = Integer.parseInt(request.getParameter("cursor"));	
		int tipo_doc = Integer.parseInt(request.getParameter("selectTipoId"));		

		String doc_persona = request.getParameter("txtIdentificacion");
		String nom_persona = request.getParameter("txtNomColabora");
		String tel_persona = request.getParameter("txtTelColabora");
		String dir_persona = request.getParameter("txtDirColabora");
		
		colaborador.insertarColaborador(nom_persona, tipo_doc, doc_persona, dir_persona, tel_persona, cursor); 
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);
		
		
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp");
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
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);
	
	}
	
	
	// Desbloquear colaborador
	
	private void desbloquearColaborador(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {	
		
		Colaboradores editColabora = new Colaboradores();		
		
		editColabora.setCod_colabora(Integer.parseInt(request.getParameter("txtCodColabora")));
		editColabora.setEstado_colabora(Integer.parseInt(request.getParameter("txtEstadoColabora")));
	
		ColaboradoresDAO.desbloquearColaborador(editColabora);			
		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp").forward(request, response);
	
	}
	
	
	
	// Agregar Sobres
		private void agregarSobre(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			Administracion admin = new Administracion();
			PersonasDAO persona = new PersonasDAO();
			TempoSobresPlanilla sobres = new TempoSobresPlanilla();
			SobresPlanillasDAO sobre = new SobresPlanillasDAO();
			
			
			String nom_persona = request.getParameter("txtNombrePersona");	
			

			int txtDiezmos = admin.validarCampoNumero(request.getParameter("txtDiezmos"));
			int txtOfrendas = admin.validarCampoNumero(request.getParameter("txtOfrendas"));
			int txtNecesitados = admin.validarCampoNumero(request.getParameter("txtNecesitados"));
			int txtMercados = admin.validarCampoNumero(request.getParameter("txtMercados"));
			int txtConstruccion = admin.validarCampoNumero(request.getParameter("txtConstruccion"));
			int txtMisiones = admin.validarCampoNumero(request.getParameter("txtMisiones"));
			
			
			if((admin.validaIngresoSobres(txtDiezmos, txtOfrendas, txtNecesitados, txtMercados, txtConstruccion, txtMisiones)== false)) 	{
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp");
				request.setAttribute("alert", "103");	
				dispatcher.forward(request, response);
				
			}else {	
				if(persona.validarNombrePersona(nom_persona)==0) 	{
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp");
						request.setAttribute("alert", "105");	
						dispatcher.forward(request, response);
				
			}else {
					
			sobres.setDiezmos(txtDiezmos);			
			sobres.setOfrendas(txtOfrendas);			
			sobres.setNecesitados(txtNecesitados);			
			sobres.setMercados(txtMercados);			
			sobres.setConstruccion(txtConstruccion);			
			sobres.setMisiones(txtMisiones);
			
			sobre.agregarSobre(nom_persona, sobres); 
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp").forward(request, response);
			
					}
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
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp").forward(request, response);			
		
		}
		
		
		// Finalizar Ingreso
		
		private void finalizarIngreso(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		
			
			VTtempoDatosPlanilla finalizaIngreso = new VTtempoDatosPlanilla();		
			
			finalizaIngreso.setCod_temp_planilla(Integer.parseInt(request.getParameter("txtCodPlanilla")));
			finalizaIngreso.setEstado_planilla(Integer.parseInt(request.getParameter("txtEstadoPlanilla")));
		
			SobresPlanillasDAO.finalizarIngresos(finalizaIngreso);
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDinero.jsp").forward(request, response);
		
		}
		
		
		
		// Validar Cuadre
		private void validarCuadre(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			Administracion admin = new Administracion();			
			TempoDineroPlanilla valida = new TempoDineroPlanilla();	
			
			int txtb_cien= admin.validarCampoNumero(request.getParameter("txtb_cien"));
			int txtb_cincuenta= admin.validarCampoNumero(request.getParameter("txtb_cincuenta"));
			int txtb_veinte= admin.validarCampoNumero(request.getParameter("txtb_veinte"));
			int txtb_diez= admin.validarCampoNumero(request.getParameter("txtb_diez"));
			int txtb_cinco= admin.validarCampoNumero(request.getParameter("txtb_cinco"));
			int txtb_dos= admin.validarCampoNumero(request.getParameter("txtb_dos"));
			int txtb_mil= admin.validarCampoNumero(request.getParameter("txtb_mil")); 
			int txtm_mil= admin.validarCampoNumero(request.getParameter("txtm_mil"));
			int txtm_quiniento= admin.validarCampoNumero(request.getParameter("txtm_quiniento"));
			int txtm_dos= admin.validarCampoNumero(request.getParameter("txtm_dos"));
			int txtm_cien= admin.validarCampoNumero(request.getParameter("txtm_cien"));
			int txtm_cincuenta= admin.validarCampoNumero(request.getParameter("txtm_cincuenta"));
			
			if(admin.validaIngresoDinero(txtb_cien, txtb_cincuenta, txtb_veinte, txtb_diez, txtb_cinco, txtb_dos, txtb_mil, txtm_mil, txtm_quiniento, txtm_dos, txtm_cien, txtm_cincuenta) == false) {
								
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDinero.jsp");
				request.setAttribute("alert", "104");	
				dispatcher.forward(request, response);	
				
			}else {
				
				valida.setCod_planilla(Integer.parseInt(request.getParameter("txtCodPlanilla")));
				valida.setB_cien(txtb_cien);
				valida.setB_cincuenta(txtb_cincuenta);
				valida.setB_veinte(txtb_veinte);
				valida.setB_diez(txtb_diez);
				valida.setB_cinco(txtb_cinco);
				valida.setB_dos(txtb_dos);
				valida.setB_mil(txtb_mil);
				valida.setM_mil(txtm_mil);
				valida.setM_quiniento(txtm_quiniento);
				valida.setM_dos(txtm_dos);
				valida.setM_cien(txtm_cien);
				valida.setM_cincuenta(txtm_cincuenta);
				
				valida.setEstado(Integer.parseInt(request.getParameter("txtEstadoValidacion")));			
			
			PlanillasDAO.validarCuadre(valida);			
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaDinero.jsp").forward(request, response);	
			
			}
		}
		
		
		// Aprobar Planilla
		
		private void aprobarPlanilla(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		
			String 	nom_aprueba= 	request.getParameter("txtPersonaGenera");
			int	cod_estado_pla=	Integer.parseInt(request.getParameter("txtEstadoPlanilla")); 			
			
			PlanillasDAO.aprobarPlanilla(nom_aprueba, cod_estado_pla);
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_finalizada.jsp").forward(request, response);
		
		}
		
		
		
		// Agregar nuevo concepto de Ingreso
		private void agregarNuevoConceptoIngreso(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			SobresEspeciales sobre = new SobresEspeciales();
			SobresPlanillasDAO sobres = new SobresPlanillasDAO();
			
			String nom_concepto= request.getParameter("txtNombreConcepto");
			
			if(sobres.validarConceptoIngreso(nom_concepto) == 0) {
			
			sobre.setNom_sobre_especial(nom_concepto);
			
			sobres.agregarConceptoIngreso(sobre);  	
		
			request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp").forward(request, response);
			
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp");
				request.setAttribute("alert", "102");	
				dispatcher.forward(request, response);	

			}
		
		}
		
		
		
		// Agregar Sobre especial
				private void agregarSobreEspecial(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, IOException, ServletException {
					
					Administracion admin = new Administracion();
					TempoSobresPlanilla sobres = new TempoSobresPlanilla();
					SobresPlanillasDAO sobre = new SobresPlanillasDAO();
					
					
					String nom_persona = request.getParameter("selectConceptoEspecial");
					String txtEspeciales = request.getParameter("txtEspeciales");

					//int txtEspeciales = admin.validarCampoNumero(request.getParameter("txtEspeciales"));					
											
					sobres.setEspecial(Integer.parseInt(txtEspeciales));	
					
					sobre.agregarSobreEspecial(nom_persona, sobres); 
					request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp").forward(request, response);
					
							
						
						
					}


}
