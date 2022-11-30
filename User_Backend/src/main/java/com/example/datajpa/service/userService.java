package com.example.datajpa.service;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.datajpa.model.UserDTO;
import com.example.datajpa.pojo.loanDTO;
import com.example.datajpa.repository.UserRepository;
import com.example.datajpa.response.ResponseValueObject;

@Service
public class userService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	@Autowired
	private ResponseValueObject responseValObj;
	
	public UserDTO saveLoan(UserDTO dto) {
		return repository.save(dto);
	}
//	public loanDTO saveDtoLoan(loanDTO dtos) {
//		return repository.save(dtos);
//	}
	
	public UserDTO getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
//	public ResponseValueObject fetchUserLoanById(int id) {
//		return repository.findById(id).orElse(null);
//	}

	public ResponseValueObject fetchUserLoanById(int id) {
		UserDTO userdatadto = repository.findById(id).orElse(null);
		loanDTO loanDTO = restTemplate.getForObject("http://localhost:8081/api/Loan/GetLoanbyId/" +userdatadto.getLoanid() , loanDTO.class);
		responseValObj.setLoanDTO(loanDTO);
		responseValObj.setUserDataDTO(userdatadto);
		return responseValObj ;
	}
	
	/*
	 * public ResponseValueObject fetchUserLoanById(int id) { loanDataDTO
	 * userdataDto = repository.findById(id).orElse(null); loanDTO loanDTO =
	 * restTemplate.getForObject(
	 * "http://localhost:8081/api/loan/fetchUserLoanById/"+ userdataDto.getLoanid(),
	 * loanDTO.class) ; responseValueObject.setLoanDataDTO(userdataDto);
	 * responseValueObject.setLoanDTO(loanDTO); return responseValueObject; }
	 */

	
//	public loanDataDTO fetchUserLoanById(int id) {
//		loanDataDTO userdataDto = repository.findById(id).orElse(null);
//		loanDTO loanDTO = restTemplate.getForObject("http://localhost:8081/api/product/getProduct/"+ userdataDto.getLoanid(), loanDTO.class) ;
//		responseValueObject.setLoanDataDTO(userdataDto);
//		responseValueObject.setLoanDTO(loanDTO);
//		 return loanDataDTO;
//	}
	
	
}
