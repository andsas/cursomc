package com.br.andsas.resources.exceptions;

import java.io.Serializable;

public class ExtandardError implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private Integer status;
	private String error;
	private Long timeStamp;
	
	public ExtandardError(Integer status, String error, long timeStamp) {
		this.status = status;
		this.error = error;
		this.timeStamp = timeStamp;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
