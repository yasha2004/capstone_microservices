package com.infy.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.SimDetails;
import com.infy.Repository.SimDetailsRepository;

@Service
@Transactional
public class SimDetailsService {
	
	@Autowired
	SimDetailsRepository simDetailsRepository;
	
	public SimDetails findSimIdFromSimDetails(String serviceNumber, String simNumber) throws Exception
	{
		Optional<SimDetails> simDetails=Optional.ofNullable(simDetailsRepository.findByServiceNumberAndSimNumber(serviceNumber,simNumber));
		if(simDetails.isPresent())
		{
			return simDetails.get();
		}
		else
		{
			throw new Exception("No such SIM exists");
		}
	}

	public SimDetails findByIdd(Integer simId) throws Exception
	{
		
		Optional<SimDetails> simDetails = simDetailsRepository.findById(simId);
		if(simDetails.isPresent())
		{
			return simDetails.get();
		}
		else
		{
			throw new Exception("No such SIM exists");
		}
	}
}
