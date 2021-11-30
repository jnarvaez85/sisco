package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class views
 */
@WebServlet("/views")
public class views extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public views() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("url");

		if (accion != null) {
			switch (accion) {
			case "home":
				this.viewsHome(request, response);
				break;
			case "login":
				this.viewsLogin(request, response);
				break;
		}
			
		} else {
			response.sendRedirect("error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	private void viewsHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/PAGE/home.jsp").forward(request, response);	
	}
	
	private void viewsLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
