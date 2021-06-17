package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id  @OneToMany(mappedBy = "categoryID", fetch = FetchType.EAGER)
	private String categoryID;
	private String name;
	private String description;

	
	//Constructor//
	public Category() {
		super();
	}


	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCategoryID() {
		return categoryID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}


	
	//Setters//
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//toString//
	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", name=" + name + ", description=" + description + "]";
	}

	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		return true;
	}
	
	
	
}
