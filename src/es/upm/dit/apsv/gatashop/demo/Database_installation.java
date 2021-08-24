package es.upm.dit.apsv.gatashop.demo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import java.util.ArrayList;

import es.upm.dit.apsv.gatashop.dao.AreaDAOImplementation;
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
			Category cat2 = new Category();
			Category cat3 = new Category();
			Product p1 = new Product();
			Product p2 = new Product();
			Product p3 = new Product();
			Product p4 = new Product();
			Supplier s1 = new Supplier();
			Supplier s2 = new Supplier();
			OrderDetail od1 = new OrderDetail();
			OrderDetail od2 = new OrderDetail();
			OrderDetail od3 = new OrderDetail();
			Order o1 = new Order();
			Order o2 = new Order();
			Client c1 = new Client();
			Client c2 = new Client();
			Client c3 = new Client();
			Shipper sh1 = new Shipper();			
			Shipper sh2 = new Shipper();			
			Area a1 = new Area();	
			Area a2 = new Area();	
			
			
			//Category//
			cat1.setId((long) (Math.random()*10000));
			cat1.setName("Frutas");
			cat1.setDescription("descripcion frutas");		
			List<Product> productsAssociated1 = new ArrayList();
			productsAssociated1.add(p1);
			cat1.setProductsAssociated(productsAssociated1);
			
			cat2.setId((long) (Math.random()*10000));
			cat2.setName("Automovil");
			cat2.setDescription("4 ejes y mas descripcion");		
			List<Product> productsAssociated2 = new ArrayList();
			productsAssociated2.add(p2);
			cat2.setProductsAssociated(productsAssociated2);
			
			
			//Product//
			p1.setId((long) (Math.random()*10000));
			p1.setName("Platano");
			p1.setPrice(3);
			p1.setUnit("pack de 6");
			p1.setAvailable(true);
			p1.setSupplier(s1);
			List<Category> categories1 = new ArrayList();
			categories1.add(cat1);
			p1.setCategories(categories1);
			List<Client> customers = new ArrayList();
			customers.add(c1);
			p1.setCustomers(customers);
			
			p2.setId((long) (Math.random()*10000));
			p2.setName("Coche");
			p2.setPrice(20000.20);
			p2.setUnit("sin Extras");
			p2.setAvailable(false);
			p2.setSupplier(s2);
			List<Category> categories2 = new ArrayList();
			categories2.add(cat2);
			p2.setCategories(categories2);
			p2.setCustomers(customers);
			
			p3.setId((long) (Math.random()*10000));
			p3.setName("Perro");
			p3.setPrice(345.78);
			p3.setUnit("Yorkshire");
			p3.setAvailable(true);
			p3.setSupplier(s1);
			List<Category> categories3 = new ArrayList();
			categories3.add(cat1);
			p3.setCategories(categories3);
			
			p4.setId((long) (Math.random()*10000));
			p4.setName("Mango");
			p4.setPrice(5);
			p4.setUnit("1 unidad");
			p4.setAvailable(true);
			p4.setSupplier(s1);
			List<Category> categories4 = new ArrayList();
			categories4.add(cat1);
			p4.setCategories(categories4);
			
			
			
			//Supplier//
			s1.setId((long) (Math.random()*10000));
			s1.setEmail("supplier@gmail.com");
			s1.setPassword("supplier");
			s1.setName("Supi-1");
			s1.setPhone("+34722512031");
			s1.setContactName("Pepe");
			s1.setAddress("C/Paises Bajos, 7");
			s1.setCity("Caceres");
			s1.setCountry("ESP");
			s1.setPostalCode("10005");
			List<Product> suppliedProducts1 = new ArrayList();
			suppliedProducts1.add(p2);
			s1.setSuppliedProducts(suppliedProducts1);
			
			s2.setId((long) (Math.random()*10000));
			s2.setEmail("supplier2@gmail.com");
			s2.setPassword("supplier2");
			s2.setName("Supi-2");
			s2.setPhone("+34619861005");
			s2.setContactName("Manolo");
			s2.setAddress("C/Poeta Angela Figuera, 5");
			s2.setCity("Madrid");
			s2.setCountry("ESP");
			s2.setPostalCode("28040");
			List<Product> suppliedProducts2 = new ArrayList();
			suppliedProducts2.add(p1);
			suppliedProducts2.add(p3);
			s2.setSuppliedProducts(suppliedProducts2);
			
			
			//OrderDetail//
			od1.setId((long) (Math.random()*10000));
			od1.setOrder(o1);
			od1.setProduct(p1);
			od1.setQuantity(1);
			
			od2.setId((long) (Math.random()*10000));
			od2.setOrder(o2);
			od2.setProduct(p4);
			od2.setQuantity(3);
			
			od3.setId((long) (Math.random()*10000));
			od3.setOrder(o1);
			od3.setProduct(p2);
			od3.setQuantity(1);
			
			
			//Order//
			o1.setId((long) (Math.random()*10000));
			o1.setOrderDate(java.util.Calendar.getInstance());
			o1.setClient(c1);
			o1.setShipper(sh1);
			List<OrderDetail> orderDetails1 = new ArrayList();
			orderDetails1.add(od1);
			o1.setDetails(orderDetails1);
			
			o2.setId((long) (Math.random()*10000));
			o2.setOrderDate(java.util.Calendar.getInstance());
			o2.setClient(c2);
			o2.setShipper(sh2);
			List<OrderDetail> orderDetails2 = new ArrayList();
			orderDetails2.add(od2);
			o2.setDetails(orderDetails2);
			
			
			
			//Client//
			c1.setId((long) (Math.random()*100000));
			c1.setEmail("jorge@gmail.com");
			c1.setPassword("client");
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
			
			c2.setId((long) (Math.random()*100000));
			c2.setEmail("maria@gmail.com");
			c2.setPassword("maria");
			c2.setUser("Maria");
			c2.setCity("Chiclana");
			c2.setCountry("ESP");
			c2.setAddress("C//Casa abuela,4");
			c2.setPostalCode("10005");

			
			c3.setId((long) (Math.random()*100000));
			c3.setEmail("antonio@gmail.com");
			c3.setPassword("antonio");
			c3.setUser("Antonio");
			c3.setCity("Madrid");
			c3.setCountry("ESP");
			c3.setAddress("C//Moncloa, 32");
			c3.setPostalCode("10005");
			
			
			
			//Shipper//
			sh1.setId((long) (Math.random()*10000));
			sh1.setName("Correos");
			sh1.setEmail("shipper@gmail.com");
			sh1.setPassword("shipper");
			sh1.setPhone("+34999999999");
			List<Area> areas = new ArrayList();
			areas.add(a1);
			sh1.setAreas(areas);
			List<Order> shipments = new ArrayList();
			shipments.add(o1);
			sh1.setShipments(shipments);
			
			sh2.setId((long) (Math.random()*10000));
			sh2.setName("SEUR");
			sh2.setEmail("shipper2@gmail.com");
			sh2.setPassword("shipper2");
			sh2.setPhone("+3411111111");
			sh2.setAreas(areas);			
			
			
			//Area//
			a1.setId((long) (Math.random()*10000));
			a1.setName("Europa");
			a1.setPrice(15);
			a1.setDescription("Union Europea");
			List<Shipper> coveredBy = new ArrayList();
			coveredBy.add(sh1);
			a1.setCoveredBy(coveredBy);
			
			
			
			CategoryDAOImplementation.getInstance().create(cat1);
			CategoryDAOImplementation.getInstance().create(cat2);
			SupplierDAOImplementation.getInstance().create(s1);
			SupplierDAOImplementation.getInstance().create(s2);
			ProductDAOImplementation.getInstance().create(p1);
			ProductDAOImplementation.getInstance().create(p2);
			ProductDAOImplementation.getInstance().create(p3);
			ProductDAOImplementation.getInstance().create(p4);
			ShipperDAOImplementation.getInstance().create(sh1);
			ShipperDAOImplementation.getInstance().create(sh2);
			ClientDAOImplementation.getInstance().create(c1);
			ClientDAOImplementation.getInstance().create(c2);
			ClientDAOImplementation.getInstance().create(c3);
			AreaDAOImplementation.getInstance().create(a1);
			OrderDetailDAOImplementation.getInstance().create(od1);
			OrderDetailDAOImplementation.getInstance().create(od2);
			OrderDetailDAOImplementation.getInstance().create(od3);
			OrderDAOImplementation.getInstance().create(o1);
			OrderDAOImplementation.getInstance().create(o2);
			
			/*
			System.out.println("\n\n\n\n\n\n\n");
			List<Product> temp = c1.getCart();
			temp.add(p2);
			c1.setCart(cart);
			ClientDAOImplementation.getInstance().update(c1);
			*/
		}finally {}

	}
}
