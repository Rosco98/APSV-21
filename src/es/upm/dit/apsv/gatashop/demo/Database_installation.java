package es.upm.dit.apsv.gatashop.demo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import java.util.ArrayList;

import es.upm.dit.apsv.gatashop.dao.CategoryDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ClientDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.OrderDetailDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.ProductDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SessionFactoryService;
import es.upm.dit.apsv.gatashop.dao.ShipperDAOImplementation;
import es.upm.dit.apsv.gatashop.dao.SupplierDAOImplementation;
import es.upm.dit.apsv.gatashop.model.*;

public class Database_installation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			
			//Creacion objetos//
			Category cat1 = new Category();
			Product p1 = new Product();
			Supplier s1 = new Supplier();
			OrderDetail od1 = new OrderDetail();
			Order o1 = new Order();
			Client c1 = new Client();
			Shipper sh1 = new Shipper();			
			
			
			//Category//
			//cat1.setId((long) Math.random()*10000);
			cat1.setName("Frutas");
			cat1.setDescription("descripcion frutas");		
			List<Product> productsAssociated = new ArrayList();
			productsAssociated.add(p1);
			cat1.setProductsAssociated(productsAssociated);
			
			
			//Product//
			//p1.setId((long) Math.random()*10000);
			p1.setName("Platano");
			p1.setPrice(3);
			p1.setUnit("pack de 6");
			
			p1.setSupplier(s1);
			List<Category> categories = new ArrayList();
			categories.add(cat1);
			p1.setCategories(categories);
			List<Client> customers = new ArrayList();
			customers.add(c1);
			p1.setCustomers(customers);
			
			
			//Supplier//
			//s1.setId((long) Math.random()*10000);
			s1.setEmail("supplier@gmail.com");
			s1.setName("Supi");
			s1.setPhone("+34722512031");
			s1.setContactName("Pepe");
			s1.setAddress("C/Paises Bajos, 7");
			s1.setCity("Caceres");
			s1.setCountry("ESP");
			s1.setPostalCode("10005");
			List<Product> suppliedProducts = new ArrayList();
			suppliedProducts.add(p1);
			s1.setSuppliedProducts(suppliedProducts);
			
			
			//OrderDetail//
			//od1.setId((long) Math.random()*10000);
			od1.setOrder(o1);
			od1.setProduct(p1);
			od1.setQuantity(1);
			
			
			//Order//
			//o1.setId((long) Math.random()*10000);
			o1.setOrderDate(java.util.Calendar.getInstance());
			o1.setClient(c1);
			o1.setShipper(sh1);
			List<OrderDetail> orderDetails = new ArrayList();
			orderDetails.add(od1);
			o1.setOrderDetails(orderDetails);
			
			
			
			//Client//
			//c1.setId((long) Math.random()*10000);
			c1.setEmail("jorge@gmail.com");
			c1.setPassword("paco");
			c1.setUser("Paco");
			c1.setCity("Madrid");
			c1.setCountry("ESP");
			c1.setAddress("C//Los Huertos,28");
			c1.setPostalCode("10005");
			List<Order> orders = new ArrayList();
			orders.add(o1);
			c1.setOrders(orders);
			List<Product> cart = new ArrayList();
			cart.add(p1);
			c1.setCart(cart);
			
			
			
			//Shipper//
			//sh1.setId((long) Math.random()*10000);
			sh1.setName("Correos");
			sh1.setEmail("mercadona@gmail.com");
			sh1.setPhone("+34999999999");
			List<Order> shipments = new ArrayList();
			shipments.add(o1);
			sh1.setShipments(shipments);
			
			
			
			CategoryDAOImplementation.getInstance().create(cat1);
			ProductDAOImplementation.getInstance().create(p1);
			SupplierDAOImplementation.getInstance().create(s1);
			OrderDetailDAOImplementation.getInstance().create(od1);
			OrderDAOImplementation.getInstance().create(o1);
			ClientDAOImplementation.getInstance().create(c1);
			ShipperDAOImplementation.getInstance().create(sh1);
		}finally {}

	}
}
