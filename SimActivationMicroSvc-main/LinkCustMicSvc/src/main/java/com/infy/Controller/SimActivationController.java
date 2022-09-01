package com.infy.Controller;


import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.CustomerAddressDTO;
import com.infy.DTO.CustomerDTO;
import com.infy.Entity.Customer;
import com.infy.Service.CustomerAddressService;
import com.infy.Service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@Validated
@Transactional
public class SimActivationController {

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerAddressService customerAddressService;
	

	Log logger = LogFactory.getLog(this.getClass());
	
	@GetMapping("/CustomerDetail")
	public List<Customer> getCustomerDetails() throws Exception
	{
		List<Customer> listofCustomers = customerService.findallthecustomers();	
		return listofCustomers;
	}
	
	@PostMapping("/CustomerDetails")
	public ResponseEntity<String> verifyCustomerDetails(@RequestBody @Valid CustomerDTO customerDTO) throws Exception
	{
		return new ResponseEntity<>(customerService.checkTheCustomer(customerDTO),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/CustomerPersonalDetails")
	public ResponseEntity<String> verifyCustomerNameDetails(@RequestBody @Valid CustomerDTO customerDTO) throws Exception
	{
		return new ResponseEntity<>(customerService.checkTheCustomerName(customerDTO),HttpStatus.ACCEPTED);
			
	}
	@CircuitBreaker(name = "CustomerMS",fallbackMethod = "verifyCustomerIdProoffallback")
	@PostMapping("/CustomerIdProof")
	public ResponseEntity<String> verifyCustomerIdProof(@RequestBody @Valid CustomerDTO customerDTO)
	{
		return new ResponseEntity<>(customerService.checkTheCustomerIdProof(customerDTO),HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<String> verifyCustomerIdProoffallback(CustomerDTO customerDTO,Throwable throwable)
	{
		return new ResponseEntity<>("SIM DOWN",HttpStatus.ACCEPTED);
	}
	
	
//	@GetMapping("/AllAddresses")
//	public List<CustomerAddress> findAllTheAddress() throws Exception
//	{
//		return customerAddressService.findAllTheAddressofCustomer();
//	}
	
	@PutMapping("/AddressUpdate")
	public ResponseEntity<String> updateTheAddress(@RequestBody @Valid CustomerAddressDTO customerAddressDTO) throws Exception
	{
		return new ResponseEntity<>(customerAddressService.updateTheAddressofCustomer(customerAddressDTO),HttpStatus.ACCEPTED);
	}
	
	
	
	
}
