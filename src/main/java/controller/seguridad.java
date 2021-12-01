package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seguridad.*;

/**
 * Servlet implementation class seguridad
 */
@WebServlet("/seguridad")
public class seguridad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seguridad() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    // INICIO GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("url");

		if (accion != null) {
			switch (accion) {
			case "usuarios":
				this.listarUsuarios(request, response);
				break;
			case "autorizarFirma":
				this.autorizarFirma(request, response);
				break;
			case "configurar":
				this.configurarUsuario(request, response);
				break;
			case "nuevoUsuario":
				this.agregarUsuario(request, response);
				break;
			}
			
		} else {
			response.sendRedirect("error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/segur_usuarios.jsp").forward(request, response);	
	}
	
	private void autorizarFirma(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/consultarPlanilla.jsp").forward(request, response);	
	}
	
	private void configurarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/planillaCompartida.jsp").forward(request, response);	
	}
	
	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/segur_agregarUsuario.jsp").forward(request, response);	
	}
	
	

	// FIN GET


	
	
	// INICIO POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("validar");

		if (accion != null) {
			switch (accion) {
			case "validarUsuario":
				this.validarUsuario(request, response);
				break;
		}
			
		} else {
			response.sendRedirect("error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	
	
	// Validar existencia de Usuario
	private void validarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		VTusuarios addUsuario = new VTusuarios();
		UsuariosDAO userValidate = new UsuariosDAO();		
		
		if(userValidate.validarUsuario(request.getParameter("txtIdentificacion")) == 0) {
    	
		response.sendRedirect("noexiste");
		}else {
			
			request.setAttribute("message", "hello");
			response.sendRedirect("seguridad?url=nuevoUsuario&req=101");
	}
	}


}
