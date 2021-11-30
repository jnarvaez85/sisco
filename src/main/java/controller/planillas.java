package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.getRequestDispatcher("WEB-INF/PAGE/agregarPlanilla.jsp").forward(request, response);	
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
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
