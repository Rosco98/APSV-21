package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id  @OneToMany(mappedBy = "clientID", fetch = FetchType.EAGER)
	private String clientID;
	private String email;
	private String user;
	private String password;
	private String country;
	private String city;
	private String address;
	private String postalCode;
	private ArrayList<Product> cart;
	
	//Constructor//
	public Client() {
		super();
	}
	
	//Getters//
	public String getClientID() {
		return clientID;
	}
	public String getEmail() {
		return email;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
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
	public ArrayList<Product> getCart() {
		return cart;
	}

	//Setters//
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
		
	//toString//
	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", email=" + email + ", user=" + user + ", password=" + password
				+ ", country=" + country + ", city=" + city + ", address=" + address + ", postalCode=" + postalCode
				+ ", cart=" + cart + "]";
	}

	
	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
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
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


}
