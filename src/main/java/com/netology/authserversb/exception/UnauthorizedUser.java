package com.netology.authserversb.exception;

public class UnauthorizedUser extends RuntimeException {
	public UnauthorizedUser(String msg) {
		super(msg);
	}
}
