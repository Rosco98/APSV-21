package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.dao.ProductDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SessionFactoryService;
import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Product;

/**
 * Servlet implementation class ProductsList
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(this.getServletContext()==null) {
				System.out.println("HOLA");
			}
			Client client = (Client) request.getSession().getAttribute("client");

			if (client != null) {
				request.getSession().setAttribute("client",client);
			}
			request.getSession().setAttribute("listProducts",ProductDAOImplementation.getInstance().readAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
