package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cierre
 */
@WebServlet("/cierre")
public class cierre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cierre() {
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
   				
   			}
   			
   		} else {
   			response.sendRedirect("error.jsp");
   		}
   		response.getWriter().append("Served at: ").append(request.getContextPath());
   	}
   	
   	

   	private void agregarPlanilla(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException {
   		request.getRequestDispatcher("WEB-INF/PAGE/PLANILLAS/planilla_validaContador.jsp").forward(request, response);	
   	}
   	
   

   	// FIN GET

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
