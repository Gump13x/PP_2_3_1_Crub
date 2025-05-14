package com.bp.dao;

import org.springframework.stereotype.Repository;
import com.bp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getAllUsers() {
		System.out.println("getAllUsers method called");
		return entityManager.createQuery("select u from User u", User.class)
				.getResultList();
	}

	public User getUserById(Long id) {
		return entityManager.find(User.class, id);
	}

	public void save(User user) {
		if (user.getId() == null) {
			entityManager.persist(user);
		} else {
			entityManager.merge(user);
		}

	}

	public void update(User user) {
		entityManager.merge(user);
	}

	public void delete(Long id) {
		entityManager.remove(entityManager.find(User.class, id));
	}
}