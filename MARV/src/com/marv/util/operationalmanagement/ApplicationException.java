package com.marv.util.operationalmanagement;


public class ApplicationException extends RuntimeException {

//	public ApplicationException() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public ApplicationException(String message) {
//		super(message);
//		// TODO Auto-generated constructor stub
//	}

	public ApplicationException(Throwable cause) {
		super(cause);
		// TODO: log exception or display an error page
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
