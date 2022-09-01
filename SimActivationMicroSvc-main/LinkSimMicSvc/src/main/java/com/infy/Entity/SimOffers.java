package com.infy.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimOffers {

	@Id
	private Integer offerId;
	private Integer callOty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerNameString;
	private Integer simId;
	
	public SimOffers() {
		
	}

	public SimOffers(Integer offerId, Integer callOty, Integer cost, Integer dataQty, Integer duration,
			String offerNameString, Integer simId) {
		super();
		this.offerId = offerId;
		this.callOty = callOty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerNameString = offerNameString;
		this.simId = simId;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getCallOty() {
		return callOty;
	}

	public void setCallOty(Integer callOty) {
		this.callOty = callOty;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getDataQty() {
		return dataQty;
	}

	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getOfferNameString() {
		return offerNameString;
	}

	public void setOfferNameString(String offerNameString) {
		this.offerNameString = offerNameString;
	}

	public Integer getSimId() {
		return simId;
	}

	public void setSimId(Integer simId) {
		this.simId = simId;
	}

	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callOty=" + callOty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerNameString=" + offerNameString + ", simId=" + simId + "]";
	}
	
	
	
}
