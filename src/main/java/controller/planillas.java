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
			case "consultarPlanilla":
				this.consultarPlanilla(request, response);
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
	
	private void consultarPlanilla(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/consultarPlanilla.jsp").forward(request, response);	
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
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);			
	
	}
	
	
	// Agregar nuevo servicio
	private void agregarNuevoServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Servicios serv = new Servicios();
		ServiciosDAO addServ = new ServiciosDAO();
		
		serv.setNom_servicio(request.getParameter("txtNombreServicio"));
		serv.setHora_servicio( request.getParameter("txtHoraServicio"));

		
		addServ.agregarServicio(serv);  	
	
		request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregaDatos.jsp").forward(request, response);
	
	}
	
	

}
