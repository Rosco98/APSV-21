package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
//AAAAAAAAAAAAAAAAAAAAAA
@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String unit;
	private double price;
	private boolean available;
		
	@ManyToOne (cascade = {		
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(insertable=true, updatable=true)
	private Supplier supplier;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = {		
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	private List<OrderDetail> orderDetails;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(insertable=false, updatable=false)
	private List<Category> categories;
	
	@ManyToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = {		
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	private List<Client> customers;
	
	//Constructor//
	public Product() {
		super();
	}

	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public String getUnit() {
		return unit;
	}
	public double getPrice() {
		return price;
	}
	public boolean getAvailable() {
		return available;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public List<Client> getCustomers() {
		return customers;
	}
	
	//Setters//
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void setCustomers(List<Client> customers) {
		this.customers = customers;
	}
	
	
	//toString//
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + ", available="
				+ available + ", supplier=" + supplier + ", orderDetails=" + orderDetails + ", categories=" + categories
				+ ", customers=" + customers + "]";
	}

	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Product other = (Product) obj;
		if (available != other.available)
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
}
