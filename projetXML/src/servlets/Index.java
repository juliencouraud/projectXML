/**
 * @author julien couraud.
 *
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String path;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   /* public void init(ServletConfig servletConfig) throws ServletException{
        this.path = servletConfig.getInitParameter("path");
      }*/

   public void init() throws ServletException{
    this.path = getInitParameter("path");
    Model.initModel(path);
    System.out.println("Initialisation réussie.");
  }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static String getPath(){
		return path;
	}

}
