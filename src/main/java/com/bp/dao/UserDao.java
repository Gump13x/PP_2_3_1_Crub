package com.bp.dao;

import com.bp.model.User;

import java.util.List;

public interface UserDao {
	public List<User> getAllUsers();

	public User getUserById(int id);

	public void save(User user);

	public void update(User user);

	public void delete(int id);
}
