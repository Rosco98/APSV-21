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
@WebServlet("/ProductRegisterServlet")
public class ProductRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Supplier supplier = (Supplier) request.getSession().getAttribute("supplier");

    	String name = request.getParameter("name");
    	String unit = request.getParameter("unit");
    	Double price = (Double) request.getSession().getAttribute("price");
		request.getSession().removeAttribute("price");
    	boolean available = (boolean) request.getSession().getAttribute("available");
    	request.getSession().removeAttribute("available");
    	
    	
    	Product product = new Product();
    	//CAMBIAR FUTURO//
    	product.setId((long) (Math.random()*10000));
    	product.setName(name);
    	product.setUnit(unit);
    	product.setPrice(price);
    	product.setSupplier(supplier);
    	product.setAvailable(available);
    	
    	try {
    		ProductDAOImplementation.getInstance().create(product);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    	getServletContext().getRequestDispatcher("/LoggedSupplier.jsp").forward(request,response);


    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
