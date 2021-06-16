package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id @OneToMany(mappedBy = "productID", fetch = FetchType.EAGER)
	private String productID;
	private String name;
	@ManyToOne
	private String supplierID;
	@ManyToMany(mappedBy = "categoryID", fetch = FetchType.EAGER)
	private String categoryID;
	private String unit;
	private double price;
	
	//Constructor//
	public Product() {
		super();
	}

	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getProductID() {
		return productID;
	}
	public String getName() {
		return name;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public String getUnit() {
		return unit;
	}
	public double getPrice() {
		return price;
	}
	
	//Setters//
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	//toString//
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", supplierID=" + supplierID + ", categoryID="
				+ categoryID + ", unit=" + unit + ", price=" + price + "]";
	}
	
	
	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
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
		if (categoryID == null) {
			if (other.categoryID != null)
				return false;
		} else if (!categoryID.equals(other.categoryID))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (supplierID == null) {
			if (other.supplierID != null)
				return false;
		} else if (!supplierID.equals(other.supplierID))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
