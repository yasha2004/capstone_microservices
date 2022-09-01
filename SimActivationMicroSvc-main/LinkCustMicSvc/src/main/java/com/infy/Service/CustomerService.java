package com.infy.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.Controller.FeignConfigController;
import com.infy.DTO.CustomerDTO;
import com.infy.Entity.Customer;
import com.infy.Repository.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RestTemplate restTemplate;
	Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	FeignConfigController simFeignConfigController;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	public List<Customer> findallthecustomers()
	{
		return customerRepository.findAll();
	}
	
	
	public String checkTheCustomer(CustomerDTO customerDTO)
	{
		Customer customer = customerDTO.convertCustomerDTOtoCustomerEntity();
		Optional<Customer> custOptional = Optional.ofNullable(customerRepository.findByDateOfBirthAndEmailAddress(customer.getDateOfBirth(),customer.getEmailAddress()));
		if(custOptional.isPresent())
		{
			return "Verified";
		}
		else
		{
			return "No request placed for you";
		}
	}
	

	public String checkTheCustomerIdProof(CustomerDTO customerDTO)
	{
		logger.info("inside");
		Customer customer = customerDTO.convertCustomerDTOtoCustomerEntity();
		Optional<Customer> custOptional = Optional.ofNullable(customerRepository.findByDateOfBirthAndEmailAddressAndUniqueIdNumberAndFirstNameAndLastName(customer.getDateOfBirth(),customer.getEmailAddress(),customer.getUniqueIdNumber(),customer.getFirstName(),customer.getLastName()));
		if(custOptional.isPresent())
		{
			Customer customer2=custOptional.get();
//			String simUri;
//			List<ServiceInstance> listofSimInstances = discoveryClient.getInstances("SimMS");
//			if(listofSimInstances!=null && !listofSimInstances.isEmpty())
//			{
//				simUri=listofSimInstances.get(0).getUri().toString();
//			}
//			else {
//				throw new Exception("Sim Server not responding");
//			}
			String responseEntity = simFeignConfigController.changeSimStatus(customer2.getSimId());
//			restTemplate.getForEntity("http://SimMS/SIMDetail/"+customer2.getSimId(),String.class);
//			"localhost:9000/SIMDetail/"+customer2.getSimId()
			return responseEntity;
		}
		else
		{
			return "INVALID DETAILS";
		}
	}
	
	
	public String checkTheCustomerName(CustomerDTO customerDTO)
	{
		Customer customer = customerDTO.convertCustomerDTOtoCustomerEntity();
		Optional<Customer> custOptional = Optional.ofNullable(customerRepository.findByFirstNameAndLastName(customer.getFirstName(),customer.getLastName()));
		if(custOptional.isPresent())
		{
			Customer customer2=custOptional.get();
			if(!customer2.getEmailAddress().equals(customer.getEmailAddress()))
				return "Invalid email details!!";
			return "Verified";
		}
		else
		{
			return "No customer found for the provided details";
		}
	}
}
