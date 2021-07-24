package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
@Entity
@Table(name="SHIPPERS")
public class Shipper implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy = "shipper", fetch = FetchType.EAGER)
	private List<Order> shipments;
	
	
	//Constructor//
	public Shipper() {
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
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}	
	public List<Order> getShipments() {
		return shipments;
	}
	
	
	//Setters//
	public void setId(Long id) {
		this.id = id;
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
	public void setShipments(List<Order> shipments) {
		this.shipments = shipments;
	}
	

	//toString//
	@Override
	public String toString() {
		return "Suppliers [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + 
				", shipments=" + shipments + "]";
	}

	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shipments == null) ? 0 : shipments.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shipments == null) {
			if (other.shipments != null)
				return false;
		} else if (!shipments.equals(other.shipments))
			return false;
		return true;
	}
	
	
}
