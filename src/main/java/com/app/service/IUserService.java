package com.app.service;

import java.util.List;
import com.app.model.User;

public interface IUserService {
	public abstract int save(User user);

	public abstract void update(User user);

	public abstract void delete(int userId);

	public abstract User getUserById(int userId);

	public abstract List<User> getAllUsers();
}