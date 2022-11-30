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

import com.example.datajpa.model.LoanDataDTO;
import com.example.datajpa.response.LoanResponse;
import com.example.datajpa.service.loanService;


@RestController
@RequestMapping("api/Loan")
public class LoanController {
	
	@Autowired
	public loanService service;
	
	@Autowired
	public LoanResponse response;
	
	@PostMapping("/savedtoLoan")
	public ResponseEntity<LoanResponse> saveDtoLoan(@RequestBody LoanDataDTO dtos) {
		LoanDataDTO saveDtoLoan = service.saveDtoLoan(dtos);
		if (saveDtoLoan != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDataDTOs(Arrays.asList()); // by using Arrays.asList we can save the products by using commas ,or we
												// can save the list
			return new ResponseEntity<LoanResponse>(response, HttpStatus.OK);
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDataDTOs(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * @GetMapping("/GetLoanbyId/{id}") public ResponseEntity<LoanResponse>
	 * getLoanbyId(@PathVariable("id") int id){ LoanDataDTO loanDataDTO =
	 * service.getLoanbyId(id); if (loanDataDTO!=null) {
	 * response.setResponsecode(200); response.setError(false);
	 * response.setDataDTOs(Arrays.asList(loanDataDTO));
	 * 
	 * return new ResponseEntity<LoanResponse>(response, HttpStatus.OK); } else {
	 * response.setResponsecode(401); response.setError(true);
	 * response.setDataDTOs(null); return new ResponseEntity<>(response,
	 * HttpStatus.NOT_FOUND); } }
	 */
	
	// the above meth can also be written as below
	@GetMapping ("GetLoanbyId/{id}")
	public LoanDataDTO GetLoanbyId (@PathVariable("id") int id){
		return service.getLoanbyId(id);
	}

}
