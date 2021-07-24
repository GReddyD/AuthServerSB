package com.netology.authserversb.service;

import com.netology.authserversb.Authorities;
import com.netology.authserversb.exception.InvalidCredentials;
import com.netology.authserversb.exception.UnauthorizedUser;
import com.netology.authserversb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

	final private UserRepository userRepository;

	public AuthorizationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Authorities> getAuthorities(String user, String password) {
		if (isEmpty(user) || isEmpty(password)) {
			throw new InvalidCredentials("User name or password is empty");
		}
		List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
		if (isEmpty(userAuthorities)) {
			throw new UnauthorizedUser("Unknown user " + user);
		}
		System.out.println("OK!");
		return userAuthorities;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private boolean isEmpty(List<?> str) {
		return str == null || str.isEmpty();
	}
}
