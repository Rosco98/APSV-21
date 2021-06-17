package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	private String orderDetailID;
	@ManyToOne
	private String orderID;
	@ManyToOne
	private String productID;
	private int quantity;
	
	
	//Constructor//
	public OrderDetail() {
		super();
	}


	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrderDetailID() {
		return orderDetailID;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getProductID() {
		return productID;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//Setters//
	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
	//toString//
	@Override
	public String toString() {
		return "OrderDetails [orderDetailID=" + orderDetailID + ", orderID=" + orderID + ", productID=" + productID
				+ ", quantity=" + quantity + "]";
	}


	
	
	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDetailID == null) ? 0 : orderDetailID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		result = prime * result + quantity;
		return result;
	}


	
	//Equals//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		if (orderDetailID == null) {
			if (other.orderDetailID != null)
				return false;
		} else if (!orderDetailID.equals(other.orderDetailID))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	
	

	

}
