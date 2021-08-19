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

import es.upm.dit.apsv.gatashop.dao.ClientDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ProductDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ShipperDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SupplierDAOImplementation;
import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Product;
import es.upm.dit.apsv.gatashop.model.Shipper;
import es.upm.dit.apsv.gatashop.model.Supplier;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("productID") != null) {
			Long productID = Long.valueOf(request.getParameter("productID"));
			Product product;
			try {
				product = ProductDAOImplementation.getInstance().read(productID);
				ProductDAOImplementation.getInstance().delete(product);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (request.getParameter("supplierID") != null) {
			Long supplierID = Long.valueOf(request.getParameter("supplierID"));
			try {
				Supplier supplier = SupplierDAOImplementation.getInstance().read(supplierID);

				List<Product> productList = ProductDAOImplementation.getInstance().readAllBySupplier(supplier);
				List<Client> clientList = null;
				List<Integer> indexesRemove = new ArrayList<Integer>();

				
				for(Product p : productList) {
					Long b = p.getId();
					clientList = ClientDAOImplementation.getInstance().readAllByProductCart(p);
					for(Client client : clientList) {
						List<Product> cart = client.getCart();
						Integer index = 0;
						for(Product pCart : cart) {
							Long a = pCart.getId();
							if((a-b)==0) {
								indexesRemove.add(index);
							}
							index++;
						}
						for(int i : indexesRemove) {
							cart.remove(i);
						}
						ClientDAOImplementation.getInstance().update(client);
					}
					ProductDAOImplementation.getInstance().delete(p);					
				}
				SupplierDAOImplementation.getInstance().delete(supplier);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		else if (request.getParameter("shipperID") != null) {
			Long shipperID = Long.valueOf(request.getParameter("shipperID"));
			try {
				Shipper shipper = ShipperDAOImplementation.getInstance().read(shipperID);
				ShipperDAOImplementation.getInstance().delete(shipper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (request.getParameter("clientID") != null) {
			Long clientID = Long.valueOf(request.getParameter("clientID"));
			try {
				Client client = ClientDAOImplementation.getInstance().read(clientID);
				ClientDAOImplementation.getInstance().delete(client);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (request.getParameter("shipperID") != null) {
			Long shipperID = Long.valueOf(request.getParameter("shipperID"));
			try {
				Shipper shipper = ShipperDAOImplementation.getInstance().read(shipperID);
				ShipperDAOImplementation.getInstance().delete(shipper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			Long shipperID = Long.valueOf(request.getParameter("shipperID"));
			try {
				Shipper shipper = ShipperDAOImplementation.getInstance().read(shipperID);
				ShipperDAOImplementation.getInstance().delete(shipper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		getServletContext().getRequestDispatcher("/Admin.jsp").forward(request,response);
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
