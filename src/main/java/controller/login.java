package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seguridad.Usuarios;
import seguridad.UsuariosDAO;
import seguridad.VTusuarios;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("validar");

		if (accion != null) {
			switch (accion) {
			case "validateLogin":
				this.validarLogin(request, response);
				break;
		
			}
			
		} else {
			response.sendRedirect("error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doGet(request, response);
	}
	
	
	public void validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosDAO usuario = new UsuariosDAO();
		VTusuarios login = new VTusuarios();
		Usuarios rol = new Usuarios();

		String user = request.getParameter("txtUsuario");
		String password = request.getParameter("txtPassword");
		


		try {

			login = usuario.validarLogin(user, password);
			rol = usuario.validarRol(user);
			
			if (login.getUsuario() != null) {
				
	    		HttpSession session= request.getSession(true);

	    		 // DEJAR CONFIGURADO TIEMPO DE SESSION EN web.xml
	    		session.setMaxInactiveInterval(5);	
	    		//response.setHeader("Refresh","10;url=logout");
	    		
	    		//response.setIntHeader("Refresh", 5);
	    		session.setAttribute("mi_rol", rol.getCod_rol()); // Retorna el rol
	    		
	    		session.setAttribute("usuario", login);
	    		request.getRequestDispatcher("WEB-INF/PAGE/home.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("WEB-INF/PAGE/EXCEPTION/error_login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.print("Error al logearse: " + e);
			e.printStackTrace();
		}
		
		
	}

}
