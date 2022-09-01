package com.infy.DTO;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.infy.Entity.CustomerAddress;

public class CustomerAddressDTO {

	private Integer addressId;
	@Length(min=0,max=25,message = "Address should be maximum of 25 characters")
	private String address;
	@Pattern(regexp = "^[ A-Za-z]+$", message = "City should not contain any special characters except space")
	private String city;
	@Length(min=6,max=6,message = "Pin should be 6 digit number")
	private String pincode;
	@Pattern(regexp = "^[ A-Za-z]+$", message = "State should not contain any special characters except space")
	private String state;
	
	public CustomerAddressDTO() {
		
	}
	public CustomerAddressDTO(Integer addressId, String address, String city, String pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}
	
	public CustomerAddress convertCustomerAddressDTOtoCustomerAddressEntity()
	{
		return new CustomerAddress(this.addressId,this.address,this.city,
				this.pincode, this.state);
	}
	
	
}
