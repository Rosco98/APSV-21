package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.gatashop.dao.TFGDAOImplementation;
import es.upm.dit.apsv.gatashop.model.TFG;

/**
 * Servlet implementation class Form3AdminServlet
 */
@WebServlet("/Form3AdminServlet")
public class Form3AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form3AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	TFG tfg = TFGDAOImplementation.getInstancia().read(req.getParameter("tfgemail"));
    	tfg.setStatus(3);
    	TFGDAOImplementation.getInstancia().update(tfg);
    	req.getSession().setAttribute("tfgs",TFGDAOImplementation.getInstancia().readAll());
    	getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
