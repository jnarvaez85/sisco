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
		
		
		
		switch (accion) {

		case "usuarios":
			listarUsuarios(request, response);
			break;
		case "validate":
			validarExisteUsuario(request, response);
			break;
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp").forward(request, response);	
	}
	

	private void validarExisteUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_validarUsuario.jsp").forward(request, response);	
	}

	
	

	// FIN GET


	
	
	// INICIO POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("validar");
		
		try {
			switch (accion) {
		
			case "agregarPersona":
				agregarPersona(request, response);
				break;
			case "validarDocumento":
				validarDocumento(request, response);
				break;
			case "agregarUsuario":
				agregarUsuario(request, response);
				break;
			case "eliminarUsuario":
				eliminarUsuario(request, response);
				break;
			case "bloquearUsuario":
				bloquearUsuario(request, response);
				break;
			case "resetearPassword":
				resetearPassword(request, response);
				break;
			case "modificarUsuario":
				modificarUsuario(request, response);
				break;
			case "consultarUsuario":
				consultarUsuario(request, response);
				break;
			case "deshabilitarContador":
				deshabilitarContador(request, response);
				break;
			case "habilitarContador":
				habilitarContador(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}
	
	
	
	// Agregar Persona
	private void agregarPersona(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		String redireccionarUrl = request.getParameter("validarUrl");
		
		Personas per = new Personas();
		PersonasDAO persona = new PersonasDAO();
		
		String nom_persona=request.getParameter("txtNombres");
		
		if(persona.validarNombrePersona(nom_persona)==0) {
		
		
		per.setNom_persona(request.getParameter("txtNombres"));		
		per.setTipo_doc_persona(Integer.parseInt(request.getParameter("selectTipoId")));
		per.setDoc_persona(request.getParameter("txtIdentificacion"));
		per.setDir_persona(request.getParameter("txtDireccion"));
		per.setTel_persona(request.getParameter("txtTelefono"));
		
		persona.agregarPersona(per);  
		
		
		switch (redireccionarUrl) {

		case "agregarPersona":
			redireccionarUrl="WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp";
			break;
		case "agregarPersonaDesdeSobres":
			redireccionarUrl="WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp";
			break;	
		}			
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(redireccionarUrl);		
		dispatcher.forward(request, response);	
		
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp");
			request.setAttribute("alert", "101");	
			dispatcher.forward(request, response);	
		}
	}
	
	
	
	// Consultar persona
	private void validarDocumento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PersonasDAO per = new PersonasDAO();
		Personas persona = new Personas();		

		String documento = request.getParameter("txtIdentificacion");		
		String redireccionarUrl = request.getParameter("validarUrl");
		String cancelar = request.getParameter("cancelar");
		String data_bs = request.getParameter("doc");
		String modal = request.getParameter("modal");

		try {			
			
			switch (redireccionarUrl) {

			case "redirectUsuarios":
				redireccionarUrl="WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp";
				break;
			case "redirectColaboradores":
				redireccionarUrl="WEB-INF/PAGE/PLANILLAS/planilla_agregaDatos.jsp";
				break;
			case "redirectSobres":
				redireccionarUrl="WEB-INF/PAGE/PLANILLAS/planilla_agregaSobres.jsp";
				break;	
			}	
			

			persona = per.consultarPersona(documento);			
			
			if (per.validarPersona(request.getParameter("txtIdentificacion")) == 0) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(redireccionarUrl);
				request.setAttribute("alert", "104");
				request.setAttribute("doc_user", documento);
				request.setAttribute("cancelar", cancelar);
				request.setAttribute("modal", modal);
				request.setAttribute("data_bs", data_bs);
				dispatcher.forward(request, response);				

			} else {		
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(redireccionarUrl);
				request.setAttribute("alert", "101"); //Despliega modal para agregar persona
				request.setAttribute("persona", persona);
				dispatcher.forward(request, response);
				
			}
		} catch (SQLException e) {
			System.out.print("Error al logearse: " + e);
			e.printStackTrace();
		}
		
		
	}
	

	
	
	// Agregar nuevo usuario
	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Personas per = new Personas();
		UsuariosDAO addUser = new UsuariosDAO();
		
		int cursor = Integer.parseInt(request.getParameter("cursor"));
		
		per.setNom_persona(request.getParameter("txtNomUsuario"));		
		per.setTipo_doc_persona(Integer.parseInt(request.getParameter("selectTipoId")));
		per.setDoc_persona(request.getParameter("txtIdentificacion"));
		per.setDir_persona(request.getParameter("txtDirUsuario"));
		per.setTel_persona(request.getParameter("txtTelUsuario"));
		per.setRol_persona(Integer.parseInt(request.getParameter("selectPermisos")));
		
		addUser.insertarUsuario(per, cursor);    	
	
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp").forward(request, response);
	
	}
	
	// Eliminar usuario
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		int cod_persona = Integer.parseInt(request.getParameter("cod_persona"));
		UsuariosDAO.eliminarUsuario(cod_persona);	
	
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp").forward(request, response);
	
	}
	
	// Bloquear/desbloquear usuario
	private void bloquearUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
	
		
		Usuarios editUsuario = new Usuarios();		
		
		editUsuario.setCod_persona(Integer.parseInt(request.getParameter("txtCodPersona")));
		editUsuario.setEstado_user(Integer.parseInt(request.getParameter("txtEstadoUsuario")));
	
		UsuariosDAO.bloquearUsuario(editUsuario);
		//request.getRequestDispatcher("WEB-INF/PAGE/segur_usuarios.jsp").forward(request, response);
		
		
		if(Integer.parseInt(request.getParameter("txtEstadoUsuario")) == 1){
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ALERT/usuarioBloqueado.jsp");
		dispatcher.forward(request, response);
		
		}else {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ALERT/usuarioDesbloqueado.jsp");
		dispatcher.forward(request, response);
			
			
		}
		
		
		
	
	}
	
	// Resetear contraseña
	private void resetearPassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Usuarios editUsuario = new Usuarios();		
		
		editUsuario.setCod_persona(Integer.parseInt(request.getParameter("txtCodPersona")));
		editUsuario.setSegur_password(request.getParameter("txtSegurPassword"));
	
		UsuariosDAO.resetearPassword(editUsuario);	
	
		request.getRequestDispatcher("logout").forward(request, response);	
	
	}
	
	// Modificar Usuario
	private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Personas editPersona = new Personas();		
		
		editPersona.setCod_persona(Integer.parseInt(request.getParameter("txtCodPersona")));
		editPersona.setRol_persona(Integer.parseInt(request.getParameter("selectPermisos")));
		editPersona.setNom_persona(request.getParameter("txtNomPersona"));		
		editPersona.setDir_persona(request.getParameter("txtDirPersona"));
		editPersona.setTel_persona(request.getParameter("txtTelPersona"));
	
		UsuariosDAO.modificarUsuario(editPersona);	
	
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp").forward(request, response);	
	
	}
	
	
	// Consultar Usuario
	private void consultarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		

		int cod_persona = Integer.parseInt(request.getParameter("txtCodPersona"));
		 
		VTusuarios usuario=UsuariosDAO.consultarUsuario(cod_persona);
		  
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_asignarContador.jsp");
		request.setAttribute("usuario", usuario);	
		dispatcher.forward(request, response);
	
	}
	
	
	// Deshabilitar contador
	private void deshabilitarContador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
			
		Contadores deshContador = new Contadores();		
		
		deshContador.setCod_persona(Integer.parseInt(request.getParameter("txtCodPersona")));
	
		ContadoresDAO.deshabilitarContador(deshContador);
		request.getRequestDispatcher("WEB-INF/url/Segur_listadoUsuarios.jsp").forward(request, response);	
	
	}
	
	
	// Habilitar contador
	private void habilitarContador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
			
		Contadores habContador = new Contadores();	
		
		habContador.setCod_persona(Integer.parseInt(request.getParameter("txtCodPersona")));
		String cod_cont = request.getParameter("txtCodContador");
		
		ContadoresDAO.habilitarContador(habContador, cod_cont);
		request.getRequestDispatcher("WEB-INF/PAGE/SEGURIDAD/segur_usuarios.jsp").forward(request, response);	
	
	}
	
	



}
