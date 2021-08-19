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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = (String) request.getSession().getAttribute("type");
		
		if (type == "client") {
			String email = request.getParameter("email");
			String user = request.getParameter("user");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("postalCode");
			String password = request.getParameter("password");
			
			Client client = new Client();
			client.setId((long) (Math.random()*10000));
			client.setEmail(email);
			client.setUser(user);
			client.setCity(city);
			client.setAddress(address);
			client.setCountry(country);
			client.setPostalCode(postalCode);
			client.setPassword(password);
			try {
				ClientDAOImplementation.getInstance().create(client);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("client", client);
			getServletContext().getRequestDispatcher("/LoggedClient.jsp").forward(request,response);
			
		} else if (type == "supplier") {
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("postalCode");
			String contactName = request.getParameter("contactName");
			String password = request.getParameter("password");
			
			Supplier supplier = new Supplier();
			supplier.setId((long) (Math.random()*10000));
			supplier.setEmail(email);
			supplier.setPhone(phone);
			supplier.setName(name);
			supplier.setCity(city);
			supplier.setAddress(address);
			supplier.setCountry(country);
			supplier.setPostalCode(postalCode);
			supplier.setContactName(contactName);
			supplier.setPassword(password);
			try {
				SupplierDAOImplementation.getInstance().create(supplier);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("supplier", supplier);
			getServletContext().getRequestDispatcher("/LoggedSupplier.jsp").forward(request,response);
			
		} else if (type == "shipper") {
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String name = request.getParameter("name");
			String contactName = request.getParameter("contactName");
			String password = request.getParameter("password");
			
			Shipper shipper = new Shipper();
			shipper.setId((long) (Math.random()*10000));
			shipper.setEmail(email);
			shipper.setName(name);
			shipper.setPhone(phone);
			shipper.setPassword(password);
			
			try {
				ShipperDAOImplementation.getInstance().create(shipper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getSession().setAttribute("shipper", shipper);
			getServletContext().getRequestDispatcher("/LoggedShipper.jsp").forward(request,response);
			
		}else {
			getServletContext().getRequestDispatcher("/Sign_in.jsp").forward(request,response);
			request.getSession().setAttribute("message", "Sign in error. Try again");
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
