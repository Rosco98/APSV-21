package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.gatashop.dao.ProfessorDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.TFGDAOImplementation;
import es.upm.dit.apsv.gatashop.model.Professor;
import es.upm.dit.apsv.gatashop.model.TFG;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		List<Professor> profesores = (List<Professor>) ProfessorDAOImplementation.getInstancia().readAll();
		List<TFG> tfgs = (List<TFG>) TFGDAOImplementation.getInstancia().readAll();
		TFG tfg = TFGDAOImplementation.getInstancia().login(email, password);
		Professor professor = ProfessorDAOImplementation.getInstancia().login(email, password);
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("profesores", profesores);
			req.getSession().setAttribute("tfgs", tfgs);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else if ( null != tfg ) {
			req.getSession().setAttribute("tfg", tfg);
			getServletContext().getRequestDispatcher("/TFG.jsp").forward(req,resp);
		} else if ( null != professor ) {
			req.getSession().setAttribute("profesor", ProfessorDAOImplementation.getInstancia().read(professor.getEmail()));
			getServletContext().getRequestDispatcher("/Profesor.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
