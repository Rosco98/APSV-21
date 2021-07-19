package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//AAAAAAAAAAAAAAAAAAAAAAA
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private int quantity;
	@ManyToOne (cascade = CascadeType.ALL)
	private Order order;
	@ManyToOne (cascade = CascadeType.ALL)
	private Product product;
	
	
	//Constructor//
	public OrderDetail() {
		super();
	}


	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public Order getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//Setters//
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
	//toString//
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}


	
	
	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
