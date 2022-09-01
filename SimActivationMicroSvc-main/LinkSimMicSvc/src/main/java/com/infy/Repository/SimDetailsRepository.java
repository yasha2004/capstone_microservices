package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.SimDetails;

public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer>{

	SimDetails findByServiceNumberAndSimNumber(String serviceNumber, String simNumber);
}
