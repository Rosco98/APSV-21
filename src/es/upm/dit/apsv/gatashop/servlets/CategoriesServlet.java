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


//Intentar eliminar este Servlet y hacerlo automaticamente cuando cargue index//

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/CategoriesServlet")
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("listCategories",CategoryDAOImplementation.getInstance().readAll());
		getServletContext().getRequestDispatcher("/ProductRegister.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
