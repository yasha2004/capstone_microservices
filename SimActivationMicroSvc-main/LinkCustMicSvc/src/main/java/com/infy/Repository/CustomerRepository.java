package com.infy.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByDateOfBirthAndEmailAddress(LocalDate dateOfBirth,String emailAddress);
	
	Customer findByFirstNameAndLastName(String firstname,String Lastname);
	Customer findByDateOfBirthAndEmailAddressAndUniqueIdNumberAndFirstNameAndLastName(LocalDate dateOfBirth,String emailAddress,String uniqueIdNumber,String firstname,String Lastname);
}
