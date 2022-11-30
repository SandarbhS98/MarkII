package com.example.datajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datajpa.model.LoanDataDTO;
import com.example.datajpa.repository.LoanRepository;

@Service
public class loanService {
	
	@Autowired
	public LoanRepository repository;
	

	public LoanDataDTO saveDtoLoan(LoanDataDTO dtos) {
		return repository.save(dtos);
	}


	public LoanDataDTO getLoanbyId(int id) {	
		return repository.findById(id).orElse(null);
	}

}
