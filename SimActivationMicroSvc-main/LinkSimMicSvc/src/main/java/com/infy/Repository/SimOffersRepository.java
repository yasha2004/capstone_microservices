package com.infy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.SimOffers;

public interface SimOffersRepository extends JpaRepository<SimOffers, Integer>{

	List<SimOffers> findBySimId(Integer simId);
}
