package com.epam.services.impl;

import com.epam.dao.impl.UserDao;
import com.epam.domain.Ticket;
import com.epam.domain.User;
import com.epam.exception.MovieException;
import com.epam.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User getById(Integer id) {
		return userDao.getById(id);
	}

	public User getUserByEmail(String email) throws MovieException {
		if (StringUtils.isEmpty(email)) {
			throw new MovieException("User email didn't defined!");
		}
		return userDao.getUserByEmail(email);
	}

	public User getUserByName(String name) throws MovieException {
		if (StringUtils.isEmpty(name)) {
			throw new MovieException("User email didn't defined!");
		}
		return userDao.getByName(name);
	}

	public List<Ticket> getBookedTickets(User user) {
		return userDao.getBookedTickets(user);
	}

	public void register(User user) throws MovieException {
		if (user == null) {
			throw new MovieException("User didn't defined");
		}
		if (getUserByName(user.getName()) != null) {
			throw new MovieException("User with name " + user.getName() + " already defined");
		}
		userDao.create(user);
	}

	public void update(User user) throws MovieException {
		if (user == null) {
			throw new MovieException("User didn't defined");
		}
		userDao.update(user);
	}

	public void remove(User user) throws MovieException {
		if (user == null) {
			throw new MovieException("User didn't defined");
		}
		userDao.remove(user);
	}
}