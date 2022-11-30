package com.example.datajpa.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.datajpa.model.LoanDataDTO;

@Component
public class LoanResponse {
	private int responsecode;
	private boolean error;
	private List<LoanDataDTO> dataDTOs;
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
	public List<LoanDataDTO> getDataDTOs() {
		return dataDTOs;
	}
	public void setDataDTOs(List<LoanDataDTO> dataDTOs) {
		this.dataDTOs = dataDTOs;
	}
	
}
