package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
			case "validarExisteUsuario":
				this.validarExisteUsuario(request, response);
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
	

	private void validarExisteUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/segur_validarUsuario.jsp").forward(request, response);	
	}
	
	

	// FIN GET


	
	
	// INICIO POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("validar");
		
		try {
			switch (accion) {
		
			case "validarUsuario":
				validarUsuario(request, response);
				break;
			case "agregarUsuario":
				agregarUsuario(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}
	
	
	
	
	
	// Validar existencia de Usuario
	private void validarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuariosDAO userValidate = new UsuariosDAO();		
		
		if(userValidate.validarUsuario(request.getParameter("txtIdentificacion")) == 0) {
			
		    String doc = request.getParameter("txtIdentificacion");	
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/segur_agregarUsuario.jsp");
			request.setAttribute("doc_user", doc);	
			dispatcher.forward(request, response);				
		
		}else {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/segur_validarUsuario.jsp");
			request.setAttribute("alert", "101");	
			dispatcher.forward(request, response);
		}
	}
	
	
	// Agregar nuevo usuario
	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Personas per = new Personas();
		UsuariosDAO addUser = new UsuariosDAO();
		
		per.setNom_persona(request.getParameter("txtNombres"));
		per.setApell_persona( request.getParameter("txtApellidos"));
		per.setTipo_doc_persona(Integer.parseInt(request.getParameter("selectTipoId")));
		per.setDoc_persona(request.getParameter("txtIdentificacion"));
		per.setDir_persona(request.getParameter("txtDireccion"));
		per.setTel_persona(request.getParameter("txtTelefono"));
		per.setRol_persona(Integer.parseInt(request.getParameter("selectPermisos")));
		
		addUser.insertarUsuario(per);    	
	
		request.getRequestDispatcher("WEB-INF/PAGE/segur_usuarios.jsp").forward(request, response);
	
	}


}
