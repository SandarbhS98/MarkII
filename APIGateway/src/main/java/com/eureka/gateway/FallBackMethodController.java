package com.eureka.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/userservicefallback")
	public String userservicefallbackmeth() {
		return "User Service Taking longer time than Expected" + "Please try again later";
	}
	
	@GetMapping("/departmentservicefb")
	public String departmentServiceFallback() {
		return "Departmental serv taking longer time than expected," + "Please try again" ;
	}

}
