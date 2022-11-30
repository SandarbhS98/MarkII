package com.example.datajpa.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.datajpa.model.UserDTO;

@Component
public class UserResponse {
	
	private int responsecode;
	private boolean error;
	private List<UserDTO> dtos;
	public int getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(int responsecode) {
		this.responsecode = responsecode;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public List<UserDTO> getDtos() {
		return dtos;
	}
	public void setDtos(List<UserDTO> dtos) {
		this.dtos = dtos;
	}
	
	
}
