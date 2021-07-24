package com.netology.authserversb.repository;

import com.netology.authserversb.Authorities;
import com.netology.authserversb.user.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

	final Map<List<String>, List<Authorities>> userAuthList = new ConcurrentHashMap<>();

	public List<Authorities> getUserAuthorities(String user, String password) {

		List<String> user1 = Arrays.asList("Lily", "11111");
		List<String> user2 = Arrays.asList("Joli", "22222");
		List<String> user3 = Arrays.asList("Jon", "33333");
		List<Authorities> authUser1 = new ArrayList<>();
		List<Authorities> authUser2 = new ArrayList<>();
		List<Authorities> authUser3 = new ArrayList<>();

		authUser1.add(Authorities.DELETE);
		authUser2.add(Authorities.READ);
		authUser3.add(Authorities.WRITE);


		userAuthList.put(user1, authUser1);
		userAuthList.put(user2, authUser2);
		userAuthList.put(user3, authUser3);

		for (Map.Entry<List<String>, List<Authorities>> userAuthoritiesEntry : userAuthList.entrySet()) {

			if ((userAuthoritiesEntry.getKey().contains(user)) && (userAuthoritiesEntry.getKey().contains(password))) {

				return userAuthoritiesEntry.getValue();
			}
		}

		return Collections.emptyList();
	}
}
