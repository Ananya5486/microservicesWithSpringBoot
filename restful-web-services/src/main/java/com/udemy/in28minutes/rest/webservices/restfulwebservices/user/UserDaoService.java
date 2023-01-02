package com.udemy.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> list = new ArrayList<User>();
	private static int count = 3;
	static {
		list.add(new User(1, "Anu", new Date()));
		list.add(new User(2, "Ahu", new Date()));
		list.add(new User(3, "Bhanu", new Date()));
		list.add(new User(4, "Akshu", new Date()));
	}

	public List<User> findAll() {
		return list;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++count);
		}
		list.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : list) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
