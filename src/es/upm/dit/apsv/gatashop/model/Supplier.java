package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
@Entity
@Table(name="SUPPLIERS")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String contactName;
	private String email;
	private String password;
	private String phone;
	private String country;
	private String city;
	private String address;
	private String postalCode;
	
	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	private List<Product> suppliedProducts;

	//Constructor//
	public Supplier() {
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
	public String getContactName() {
		return contactName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
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
	public List<Product> getSuppliedProducts() {
		return suppliedProducts;
	}

	
	//Setters//
	public void setId(Long id) {
		this.id = id;
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
	public void setPassword(String password) {
		this.password = password;
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
	public void setSuppliedProducts(List<Product> suppliedProducts) {
		this.suppliedProducts = suppliedProducts;
	}

	
	//toString//
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", contactName=" + contactName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", country=" + country + ", city=" + city + 
				", address=" + address + ", postalCode=" + postalCode + ", suppliedProducts=" + suppliedProducts + "]";
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
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((suppliedProducts == null) ? 0 : suppliedProducts.hashCode());
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (suppliedProducts == null) {
			if (other.suppliedProducts != null)
				return false;
		} else if (!suppliedProducts.equals(suppliedProducts))
			return false;
		return true;
	}
	
}

