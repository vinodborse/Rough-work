package com.vinu.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinu.idao.IUserDao;
import com.vinu.model.User;

/**
 * @author Vinod Borse
 * 04-Sep-2019
 */
@Repository
public class UserDao implements IUserDao {
	@PersistenceContext
	  private EntityManager entityManager;
	
	@Transactional
	@Override
	public User findByUsername(String username) {
		TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User AS u WHERE u.username = :username",User.class);
		q.setParameter("username", username);
		try{
			User user = q.getSingleResult();
			return user;
		}catch(NoResultException nre){
		return null;	
		}
	}

	@Transactional
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}
}
