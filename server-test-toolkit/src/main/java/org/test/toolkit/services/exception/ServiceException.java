package org.test.toolkit.services.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -1;

	public ServiceException() {
 	}

	public ServiceException(String arg0) {
		super(arg0);
 	}

	public ServiceException(Throwable arg0) {
		super(arg0);
 	}

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
 	}

	public ServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
 	}

}
