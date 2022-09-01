package com.infy.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Entity.SimDetails;
import com.infy.Entity.SimOffers;
import com.infy.Service.SimDetailsService;
import com.infy.Service.SimOffersService;


@RestController
@Validated
@Transactional
public class SimActivationController {

	
	Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	SimDetailsService simDetailsService;
	@Autowired
	SimOffersService simOffersService;
	
	@GetMapping("/SIMDetails/{serviceNumber}/{simNumber}")
	public ResponseEntity<String> getSimDetails(@PathVariable @Pattern(regexp = "[0-9]{10}",message="Service Number Invalid") String serviceNumber, @PathVariable @Pattern(regexp = "[0-9]{13}",message="SIM Number Invalid") String simNumber) throws Exception
	{
		SimDetails simDetails = simDetailsService.findSimIdFromSimDetails(serviceNumber, simNumber);
		List<SimOffers> simOffers = simOffersService.findOffersForSim(simDetails.getSimId());
		String ans = simOffers.stream().map(Object::toString)
        .collect(Collectors.joining(", "));
		if(simDetails.getSimStatus().equals("active"))
		{
			return new ResponseEntity<>("SIM is already Active\n"+ans,HttpStatus.ALREADY_REPORTED);
		}
		
		
		return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/SIMDetail/{simId}")
	public String findTheSimdDetailsUsingSimDd(@PathVariable Integer simId) throws Exception
	{
		logger.info("inside sim");
		if(simId==2)
			throw new RuntimeException();
		SimDetails simDetails = simDetailsService.findByIdd(simId);
		simDetails.setSimStatus("active");
		return "Sim is now Active";
	}
	
	
	
//	@GetMapping("/CustomerDetail")
//	public List<Customer> getCustomerDetails() throws Exception
//	{
//		List<Customer> listofCustomers = customerService.findallthecustomers();	
//		return listofCustomers;
//	}
	
//	@PostMapping("/CustomerDetails")
//	public ResponseEntity<String> verifyCustomerDetails(@RequestBody @Valid CustomerDTO customerDTO) throws Exception
//	{
//		return new ResponseEntity<>(customerService.checkTheCustomer(customerDTO),HttpStatus.ACCEPTED);
//	}
//	
//	@PostMapping("/CustomerPersonalDetails")
//	public ResponseEntity<String> verifyCustomerNameDetails(@RequestBody @Valid CustomerDTO customerDTO) throws Exception
//	{
//		return new ResponseEntity<>(customerService.checkTheCustomerName(customerDTO),HttpStatus.ACCEPTED);
//			
//	}
//	
//	@PostMapping("/CustomerIdProof")
//	public ResponseEntity<String> verifyCustomerIdProof(@RequestBody @Valid CustomerDTO customerDTO) throws Exception
//	{
//		return new ResponseEntity<>(customerService.checkTheCustomerIdProof(customerDTO),HttpStatus.ACCEPTED);
//	}
	
	
	
//	@GetMapping("/AllAddresses")
//	public List<CustomerAddress> findAllTheAddress() throws Exception
//	{
//		return customerAddressService.findAllTheAddressofCustomer();
//	}
	
//	@PutMapping("/AddressUpdate")
//	public ResponseEntity<String> updateTheAddress(@RequestBody @Valid CustomerAddressDTO customerAddressDTO) throws Exception
//	{
//		return new ResponseEntity<>(customerAddressService.updateTheAddressofCustomer(customerAddressDTO),HttpStatus.ACCEPTED);
//	}
	
	
	
	
}
