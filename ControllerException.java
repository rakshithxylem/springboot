package com.employee.customexception;

public class ControllerException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorcode;
	private String errorMessage;
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ControllerException(String errorcode, String errorMessage) {
		super();
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}
	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ControllerException [errorcode=" + errorcode + ", errorMessage=" + errorMessage + "]";
	}
	
	
}
