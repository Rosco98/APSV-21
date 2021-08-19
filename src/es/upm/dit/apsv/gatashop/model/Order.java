package es.upm.dit.apsv.gatashop.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
@Entity
@Table(name="ORDERS")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar orderDate;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderDetail> details;
	
	@ManyToOne (cascade = {		
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(insertable=true, updatable=true)
	private Client client;
	
	@ManyToOne (cascade = {		
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(insertable=true, updatable=true)
	private Shipper shipper;
	
	

	
	//Constructor//
	public Order() {
		super();
	}

	
	//Getters//
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}
	public Client getClient() {
		return client;
	}
	public Shipper getShipper() {
		return shipper;
	}
	public Calendar getOrderDate() {
		return orderDate;
	}
	public List<OrderDetail> getDetails() {
		return details;
	}

	
	//Setters//
	public void setId(Long id) {
		this.id = id;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}


	//toString//
	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", shipper=" + shipper + ", orderDate=" + orderDate
				+ ", details=" + details + "]";
	}


	//HashCode//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((shipper == null) ? 0 : shipper.hashCode());
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
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (shipper == null) {
			if (other.shipper != null)
				return false;
		} else if (!shipper.equals(other.shipper))
			return false;
		return true;
	}



}
