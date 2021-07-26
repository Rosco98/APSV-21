package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="AREAS")
public class Area implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private double price;
	
	@ManyToMany(mappedBy="areas", fetch = FetchType.EAGER)
	private List<Shipper> coveredBy;

	
	//Constructor//
	public Area() {
		super();
	}
	
	
	//Getters//
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public List<Shipper> getCoveredBy() {
		return coveredBy;
	}

	
	//Setters//
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCoveredBy(List<Shipper> coveredBy) {
		this.coveredBy = coveredBy;
	}
	
	
	//toString//
	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", coveredBy=" + coveredBy + "]";
	}

	
	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coveredBy == null) ? 0 : coveredBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Area other = (Area) obj;
		if (coveredBy == null) {
			if (other.coveredBy != null)
				return false;
		} else if (!coveredBy.equals(other.coveredBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	
	
	
}
