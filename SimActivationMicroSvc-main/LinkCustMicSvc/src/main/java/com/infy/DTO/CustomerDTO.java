package com.infy.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.infy.Entity.Customer;

public class CustomerDTO {
	@Pattern(regexp = "[0-9]{16}" , message = "Id should be 16 digit")
	private String uniqueIdNumber;
//	@NotNull(message = "DOB value is required")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dateOfBirth;
	@Email(message = "Invalid Email")
//	@NotNull(message = "Email value is required")
	private String emailAddress;
	@Pattern(regexp = "[a-zA-Z]+" , message = "First Name contains non alphabets")
	@Length(min = 0,max = 15)
	private String firstName;
	@Pattern(regexp = "[a-zA-Z]+" , message = "Last Name contains non alphabets")
	@Length(min = 0,max = 15)
	private String lastName;
	private String idType;
	private Integer customerAddress_addressId;
	private Integer simId;
	private String state;
	
	public CustomerDTO() {
		
	}
	public CustomerDTO(String uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName, String lastName,
			String idType, Integer customerAddress_addressId, Integer simId, String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.customerAddress_addressId = customerAddress_addressId;
		this.simId = simId;
		this.state = state;
	}
	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public Integer getCustomerAddress_addressId() {
		return customerAddress_addressId;
	}
	public void setCustomerAddress_addressId(Integer customerAddress_addressId) {
		this.customerAddress_addressId = customerAddress_addressId;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerDTO [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", customerAddress_addressId=" + customerAddress_addressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}
	
	public Customer convertCustomerDTOtoCustomerEntity()
	{
		return new Customer(this.uniqueIdNumber, this.dateOfBirth, this.emailAddress,
				this.firstName, this.lastName, this.idType, 
				this.customerAddress_addressId, this.simId, this.state);
	}
}
