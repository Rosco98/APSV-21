package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shipper implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id  @OneToMany(mappedBy = "shipperID", fetch = FetchType.EAGER)
	private String shipperID;
	private String name;
	private String phone;
	private String email;
	
	
	//Constructor//
	public Shipper() {
		super();
	}
	
	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getShipperID() {
		return shipperID;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	
	
	//Setters//
	public void setShipperID(String shipperID) {
		this.shipperID = shipperID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//toString//
	@Override
	public String toString() {
		return "Suppliers [shipperID=" + shipperID + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((shipperID == null) ? 0 : shipperID.hashCode());
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
		Shipper other = (Shipper) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (shipperID == null) {
			if (other.shipperID != null)
				return false;
		} else if (!shipperID.equals(other.shipperID))
			return false;
		return true;
	}
	
	
}
