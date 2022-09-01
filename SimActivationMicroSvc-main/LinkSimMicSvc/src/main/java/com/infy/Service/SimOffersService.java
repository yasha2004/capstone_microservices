package com.infy.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.SimOffers;
import com.infy.Repository.SimOffersRepository;

@Service
@Transactional
public class SimOffersService {
	
	@Autowired
	SimOffersRepository simOffersRepository;
	
	public List<SimOffers> findOffersForSim(Integer simId)
	{
		List<SimOffers> simOffers = simOffersRepository.findBySimId(simId);
		return simOffers;
	}
}
