package com.infy.DTO;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import com.infy.Entity.SimDetails;

public class SimDetailsDTO {
	
	private Integer simId;
	@Length(min=10,max=10)
	@NumberFormat
	private String serviceNumber;
	@Pattern(regexp = "[0-9]{13}",message="SIM Number Invalid")
	private String simNumber;
	private String simStatus;
	
	public SimDetailsDTO(){
		
	}
	
	
	public SimDetailsDTO(Integer simId, String serviceNumber, String simNumber, String simStatus) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	@Override
	public String toString() {
		return "SimDetailsDTO [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	
	public SimDetails convertSimDetailsDTOtoSimDetailsEntity()
	{
		return new SimDetails(this.simId, this.serviceNumber, this.simNumber, this.simStatus);
	}
	
	
}
