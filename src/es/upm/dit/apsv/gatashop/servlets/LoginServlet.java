package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.gatashop.dao.CategoryDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ClientDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDetailDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ProductDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ProfessorDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ShipperDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SupplierDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.TFGDAOImplementation;
import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.OrderDetail;
import es.upm.dit.apsv.gatashop.model.Product;
import es.upm.dit.apsv.gatashop.model.Professor;
import es.upm.dit.apsv.gatashop.model.Shipper;
import es.upm.dit.apsv.gatashop.model.Supplier;
import es.upm.dit.apsv.gatashop.model.TFG;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		TFG tfg = TFGDAOImplementation.getInstancia().login(email, password);
		Professor professor = ProfessorDAOImplementation.getInstancia().login(email, password);
		
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			request.getSession().setAttribute("admin", true);
			
			List<Client> clients = (List<Client>) ClientDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("clients", clients);
			
			List<Supplier> suppliers = (List<Supplier>) SupplierDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("shippers", shippers);

			List<Shipper> shippers = (List<Shipper>) ShipperDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("suppliers", suppliers);
			
			List<Order> orders = (List<Order>) OrderDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("orders", orders);
			
			List<OrderDetail> orderDetails = (List<OrderDetail>) OrderDetailDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("orderDetails", orderDetails);
			
			List<Product> products = (List<Product>) ProductDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("products", products);
			
			List<Category> categories = (List<Category>) CategoryDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("categories", categories);

			getServletContext().getRequestDispatcher("/Admin.jsp").forward(request,response);
			
		} else if ( null != tfg ) {
			request.getSession().setAttribute("tfg", tfg);
			getServletContext().getRequestDispatcher("/TFG.jsp").forward(request,response);
			
		} else if ( null != professor ) {
			request.getSession().setAttribute("profesor", ProfessorDAOImplementation.getInstancia().read(professor.getEmail()));
			getServletContext().getRequestDispatcher("/Profesor.jsp").forward(request,response);
			
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(request,response);
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
