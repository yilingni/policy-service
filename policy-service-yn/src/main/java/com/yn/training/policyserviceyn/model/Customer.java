package com.yn.training.policyserviceyn.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	@JsonAlias("cusId")
	private String customerId;
	
	@JsonAlias("cusName")
	private String customerName;
	
	@JsonAlias("address")
	private String customerAddress;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String toString() {
		return "Customer{" + "name=" + customerName + ", level=" + customerAddress + "}";
	}
	
}