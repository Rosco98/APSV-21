package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.gatashop.dao.CategoryDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ClientDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDetailDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ProductDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ShipperDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SupplierDAOImplementation;
import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.OrderDetail;
import es.upm.dit.apsv.gatashop.model.Product;
import es.upm.dit.apsv.gatashop.model.Shipper;
import es.upm.dit.apsv.gatashop.model.Supplier;

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
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("client");
		request.getSession().removeAttribute("supplier");
		request.getSession().removeAttribute("shipper");
		
		Product product = (Product) request.getSession().getAttribute("product");
		request.getSession().removeAttribute("path");
		request.getSession().removeAttribute("type");

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Client client = ClientDAOImplementation.getInstance().login(email, password);
		Supplier supplier = SupplierDAOImplementation.getInstance().login(email, password);
		Shipper shipper = ShipperDAOImplementation.getInstance().login(email, password);
		
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			/*Cookie cookieSession = new Cookie ("sessionUser", "Admin");
			int minutesSession = 8;
			cookieSession.setMaxAge(minutesSession*60);
		    response.addCookie(cookieSession);
		    */
			
			request.getSession().setAttribute("admin", true);
			
			List<Client> clients = (List<Client>) ClientDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("clients", clients);
			
			List<Supplier> suppliers = (List<Supplier>) SupplierDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("suppliers", suppliers);

			List<Shipper> shippers = (List<Shipper>) ShipperDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("shippers", shippers);
			
			List<Order> orders = (List<Order>) OrderDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("orders", orders);
			
			List<OrderDetail> orderDetails = (List<OrderDetail>) OrderDetailDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("orderDetails", orderDetails);
			
			List<Product> products = (List<Product>) ProductDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("products", products);
			List<Product> availableProducts = (List<Product>) ProductDAOImplementation.getInstance().readAvailables();
			request.getSession().setAttribute("availableProducts", availableProducts);
			
			List<Category> categories = (List<Category>) CategoryDAOImplementation.getInstance().readAll();
			request.getSession().setAttribute("categories", categories);

			
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(request,response);
			
		} else if ( null != client ) {
			/*Cookie cookieSession = new Cookie ("sessionUser", "admin");
			int minutesSession = 8;
			cookieSession.setMaxAge(minutesSession*60);
		    response.addCookie(cookieSession);
		    */
		    
			request.getSession().setAttribute("client", client);
			
			if(product != null) {
				getServletContext().getRequestDispatcher("/Product.jsp").forward(request,response);
			}else {
			getServletContext().getRequestDispatcher("/LoggedClient.jsp").forward(request,response);
			}
			
		} else if ( null != supplier ) {
			/*Cookie cookieSession = new Cookie ("sessionUser", "supplier");
			int minutesSession = 8;
			cookieSession.setMaxAge(minutesSession*60);
		    response.addCookie(cookieSession);
		    */
		    
			request.getSession().setAttribute("supplier", supplier);
			getServletContext().getRequestDispatcher("/LoggedSupplier.jsp").forward(request,response);
			
		} else if ( null != shipper ) {
			/*
			Cookie cookieSession = new Cookie ("sessionUser", "shipper");
			int minutesSession = 8;
			cookieSession.setMaxAge(minutesSession*60);
		    response.addCookie(cookieSession);
		    */
			request.getSession().setAttribute("shipper", shipper);
			getServletContext().getRequestDispatcher("/LoggedShipper.jsp").forward(request,response);
			
		}else {
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
			request.getSession().setAttribute("message", "Login error. Try again");
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
