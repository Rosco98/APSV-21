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
			try {
				Product product = ProductDAOImplementation.getInstance().read(productID);
				List<Client> clientList = ClientDAOImplementation.getInstance().readAllByProductCart(product);
				List<Integer> indexesRemove = new ArrayList<Integer>();

				for(Client client : clientList) {
					List<Product> cart = client.getCart();
					Integer index = 0;
					for(Product pCart : cart) {
						Long a = pCart.getId();
						if(pCart.getId()-product.getId()==0) {
							indexesRemove.add(index);
						}
						index++;
					}
					for(int i : indexesRemove) {
						cart.remove(i);
					}
					ClientDAOImplementation.getInstance().update(client);
				}
				ProductDAOImplementation.getInstance().delete(product);
				//Da un error, pero no nos importa porque el resultado es
				//el deseado, no eliminandose los orders ya realizados
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
		else if (request.getParameter("orderID") != null) {
			Long orderID = Long.valueOf(request.getParameter("orderID"));
			try {
				Order order = OrderDAOImplementation.getInstance().read(orderID);
				OrderDAOImplementation.getInstance().delete(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (request.getParameter("orderDetailID") != null) {
			Long orderDetailID = Long.valueOf(request.getParameter("orderDetailID"));
			try {
				OrderDetail orderDetail = OrderDetailDAOImplementation.getInstance().read(orderDetailID);
				OrderDetailDAOImplementation.getInstance().delete(orderDetail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			Long categoryID = Long.valueOf(request.getParameter("categoryID"));
			try {
				Category category = CategoryDAOImplementation.getInstance().read(categoryID);
				List<Product> productList = ProductDAOImplementation.getInstance().readAllByCategory(category);
				List<Integer> indexesRemove = new ArrayList<Integer>();

				for(Product product : productList) {
					int index = 0;
					List<Category> categoriesProduct = product.getCategories();
					for(Category cat : categoriesProduct) {
						if (cat.getId()-category.getId()==0) {
							indexesRemove.add(index);
						}
						index++;
					}
					for(int i : indexesRemove) {
						categoriesProduct.remove(i);
					}
					product.setCategories(categoriesProduct);
					ProductDAOImplementation.getInstance().update(product);
				}
				CategoryDAOImplementation.getInstance().delete(category);
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
