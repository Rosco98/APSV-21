package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.gatashop.dao.ClientDAOImplementation;
import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Product;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = (Product) request.getSession().getAttribute("product");
		Client client = (Client) request.getSession().getAttribute("client");
		
		List<Product> list = client.getCart();
		list.add(product);
		client.setCart(list);
		request.getSession().setAttribute("message", "Product added successfully");
		try {
			System.out.println("-------------Client--------------");
			ClientDAOImplementation.getInstance().update(client);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("message", "Product was not added");
		}
		getServletContext().getRequestDispatcher("/Product.jsp").forward(request,response);
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
