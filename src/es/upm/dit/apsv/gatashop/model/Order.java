package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String orderID;
	@ManyToOne
	private String clientID;
	@ManyToOne
	private String ShipperID;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	//Constructor//
	public Order() {
		super();
	}

	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getClientID() {
		return clientID;
	}

	public String getShipperID() {
		return ShipperID;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	
	//Setters//

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public void setShipperID(String shipperID) {
		ShipperID = shipperID;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	
	//toString//
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", clientID=" + clientID + ", ShipperID=" + ShipperID + ", orderDate="
				+ orderDate + "]";
	}


	
	//hashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ShipperID == null) ? 0 : ShipperID.hashCode());
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
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
		Order other = (Order) obj;
		if (ShipperID == null) {
			if (other.ShipperID != null)
				return false;
		} else if (!ShipperID.equals(other.ShipperID))
			return false;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}

	
	
	
	

}
