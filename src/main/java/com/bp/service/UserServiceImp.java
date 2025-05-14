package com.bp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bp.dao.UserDao;
import com.bp.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

	private UserDao userDao;

	public UserServiceImp(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional
	public void update(User user) {
		userDao.update(user);
	}

	@Transactional
	public void delete(Long id) {
		userDao.delete(id);
	}
}