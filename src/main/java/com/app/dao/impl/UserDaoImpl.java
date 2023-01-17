package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int save(User user) {
		return (int)ht.save(user);
	}

	@Override
	public void update(User user) {
		ht.update(user);
	}

	@Override
	public void delete(int userId) {
		User user = new User();
		user.setUserId(userId);
		ht.delete(user);
	}

	@Override
	public User getUserById(int userId) {
		User user = ht.get(User.class, userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user = ht.loadAll(User.class);
		return user;
	}
}
