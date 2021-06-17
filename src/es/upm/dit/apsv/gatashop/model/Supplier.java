package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Suppliers")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id  @OneToMany(mappedBy = "supplierID", fetch = FetchType.EAGER)
	private String supplierID;
	private String name;
	private String contactName;
	private String email;
	private String phone;
	private String country;
	private String city;
	private String address;
	private String postalCode;

	//Constructor//
	public Supplier() {
		super();
	}


	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public String getName() {
		return name;
	}
	public String getContactName() {
		return contactName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getCountry() {
		return country;
	}
	public String getCity() {
		return city;
	}
	public String getAddress() {
		return address;
	}
	public String getPostalCode() {
		return postalCode;
	}

	
	//Setters//
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	//toString//
	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", name=" + name + ", contactName=" + contactName + ", email="
				+ email + ", phone=" + phone + ", country=" + country + ", city=" + city + ", address=" + address
				+ ", postalCode=" + postalCode + "]";
	}

	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
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
		Supplier other = (Supplier) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
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
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (supplierID == null) {
			if (other.supplierID != null)
				return false;
		} else if (!supplierID.equals(other.supplierID))
			return false;
		return true;
	}
	
	
	
	
	

}

