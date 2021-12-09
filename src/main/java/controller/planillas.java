package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				request.getRequestDispatcher("WEB-INF/PAGE/planilla_agregarResponsables.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("WEB-INF/PAGE/no.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.print("Error al validar contador: " + e);
			e.printStackTrace();
		}
	}

}
