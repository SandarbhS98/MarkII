package com.example.datajpa.response;

import org.springframework.stereotype.Component;

import com.example.datajpa.model.UserDTO;
import com.example.datajpa.pojo.loanDTO;

@Component
public class ResponseValueObject {
	
	private loanDTO loanDTO;
	private UserDTO userDataDTO;
	
	public loanDTO getLoanDTO() {
		return loanDTO;
	}
	public void setLoanDTO(loanDTO loanDTO) {
		this.loanDTO = loanDTO;
	}
	public UserDTO getUserDataDTO() {
		return userDataDTO;
	}
	public void setUserDataDTO(UserDTO userDataDTO) {
		this.userDataDTO = userDataDTO;
	}
	


}
