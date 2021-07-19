package es.upm.dit.apsv.gatashop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.dao.SessionFactoryService;
import es.upm.dit.apsv.gatashop.model.Product;

/**
 * Servlet implementation class ProductsList
 */
@WebServlet("/ProductsListServlet")
public class ProductsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		ArrayList<Product> prod = (ArrayList<Product>) session.createQuery("SELECT * FROM PRODUCTS").list();
		if(prod != null) {
			request.setAttribute("arrayListProducts", prod);
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
