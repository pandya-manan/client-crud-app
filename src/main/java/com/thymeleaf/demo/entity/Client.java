package com.thymeleaf.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private Integer clientId;
	
	@Column(name="client_name",length=100)
	private String clientName;
	
	@Column(name="client_address",length=255)
	private String clientAddress;
	
	@Column(name="client_mobile_number",length=10)
	private String clientMobileNumber;
	
	@Column(name="client_age")
	private Integer clientAge;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientMobileNumber() {
		return clientMobileNumber;
	}

	public void setClientMobileNumber(String clientMobileNumber) {
		this.clientMobileNumber = clientMobileNumber;
	}

	public Integer getClientAge() {
		return clientAge;
	}

	public void setClientAge(Integer clientAge) {
		this.clientAge = clientAge;
	}
	
	
	

}
