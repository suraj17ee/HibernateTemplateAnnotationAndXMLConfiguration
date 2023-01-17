package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class ServiceUserImpl implements IUserService {
	@Autowired
	private IUserDao dao;

	@Transactional
	public int save(User user) {
		return dao.save(user);
	}

	@Transactional
	public void update(User user) {
		dao.update(user);
	}

	@Transactional
	public void delete(int userId) {
		dao.delete(userId);
	}

	@Transactional(readOnly = true)
	public User getUserById(int userId) {
		return dao.getUserById(userId);
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
}
