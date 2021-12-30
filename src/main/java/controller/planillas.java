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
			case "planillaCompartida":
				this.planillaCompartida(request, response);
				break;
			case "colaboladores":
				this.colaboladores(request, response);
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
	
	private void planillaCompartida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planillaCompartida.jsp").forward(request, response);	
	}
	
	private void colaboladores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/colaboladores.jsp").forward(request, response);	
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
			/*
		case "validarServicio":
			validarServicio(request, response);
			break;
			*/	
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
		
		Colaboradores colabora = new Colaboradores();
		ColaboradoresDAO colaborador = new ColaboradoresDAO();
		
		
		if(colaborador.validarColaborador(request.getParameter("txtDocColabora")) == 0) {
	
		colabora.setCod_persona(Integer.parseInt(request.getParameter("selectTipoId")));
	
		
		colaborador.insertarColaborador(colabora);    	
	
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
	


}
