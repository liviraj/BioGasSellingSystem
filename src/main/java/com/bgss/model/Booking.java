package com.bgss.model;

import java.io.Serializable;

public class Booking implements Serializable {
	private int bookingId;
	private String customerNumber;
	private String gasType;
	private String serviceProvider;
	private String address1;
	private String address2;
	private String city;
	private String pincode;
	private String contactNo;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getGasType() {
		return gasType;
	}

	public void setGasType(String gasType) {
		this.gasType = gasType;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerNumber=" + customerNumber + ", gasType=" + gasType
				+ ", serviceProvider=" + serviceProvider + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", pincode=" + pincode + ", contactNo=" + contactNo + "]";
	}

}
