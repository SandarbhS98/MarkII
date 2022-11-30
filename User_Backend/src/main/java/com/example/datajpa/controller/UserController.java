package com.example.datajpa.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datajpa.model.UserDTO;
import com.example.datajpa.pojo.loanDTO;
import com.example.datajpa.response.ResponseValueObject;
import com.example.datajpa.response.UserResponse;
import com.example.datajpa.service.userService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	public userService service;

	@Autowired
	public UserResponse response;

	@PostMapping("saveUser")
	public ResponseEntity<UserResponse> saveLoan(@RequestBody UserDTO dto) {
		System.out.println("In Save user");
		UserDTO saveLoan = service.saveLoan(dto);
		if (saveLoan != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList()); // by using Arrays.asList we can save the products by using commas ,or we
			System.err.println("in save");
												// // can
			// save the list
			return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getUserbyid/{id}") // loanDataDTO getProductDTO
	public ResponseEntity<UserResponse> getUserById(@PathVariable("id") int id) {
		UserDTO getuserById = service.getUserById(id);
		// user needed
		if (getuserById != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(getuserById)); // by using Arrays.asList wecan save the products by using
															// commas ,or we can // save the list
			return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/fetchUserLoanById/{id}")
	public ResponseValueObject fetchUserLoanById(@PathVariable("id") int id) {	
		return service.fetchUserLoanById(id);
	}
	/*
	 * @PutMapping("updateProduct") public ResponseEntity<ProductResponse>
	 * updateProduct(@RequestBody ProductDTO productDTO) { ProductDTO
	 * updateProductDTO = service.updateProduct(productDTO); if (updateProductDTO !=
	 * null) { response.setResponsecode(200); response.setError(false);
	 * response.setDtos(Arrays.asList(updateProductDTO)); return new
	 * ResponseEntity<ProductResponse>(response, HttpStatus.OK); } else {
	 * response.setResponsecode(401); response.setError(true);
	 * response.setDtos(null); return new ResponseEntity<ProductResponse>(response,
	 * HttpStatus.NOT_FOUND); } }
	 * 
	 * }
	 */
}
