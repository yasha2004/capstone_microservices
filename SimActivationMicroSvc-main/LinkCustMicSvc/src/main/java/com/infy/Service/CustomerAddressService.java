package com.infy.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.CustomerAddressDTO;
import com.infy.Entity.CustomerAddress;
import com.infy.Repository.CustomerAddressRepository;


@Service
@Transactional
public class CustomerAddressService {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	
	public String updateTheAddressofCustomer(CustomerAddressDTO customerAddressDTO)
	{
		CustomerAddress customerAddress = customerAddressDTO.convertCustomerAddressDTOtoCustomerAddressEntity();
		Optional<CustomerAddress> custOptional = customerAddressRepository.findById(customerAddress.getAddressId());
		if(custOptional.isPresent())
		{
			CustomerAddress customerAddress2=custOptional.get();
			customerAddress2.setAddress(customerAddress.getAddress());
			customerAddress2.setPincode(customerAddress.getPincode());
			customerAddress2.setCity(customerAddress.getCity());
			customerAddress2.setState(customerAddress.getState());
		}
		else
		{
		}
		return "Updated";
	}
	public List<CustomerAddress> findAllTheAddressofCustomer()
	{
		return customerAddressRepository.findAll();
	}

}
