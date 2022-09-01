package com.infy.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SimMS")
public interface FeignConfigController {

	@GetMapping(value="/SIMDetail/{simId}")
	String changeSimStatus(@PathVariable(value = "simId") Integer simId);
}
