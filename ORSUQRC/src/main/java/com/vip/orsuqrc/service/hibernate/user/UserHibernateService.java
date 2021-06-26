package com.vip.orsuqrc.service.hibernate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vip.orsuqrc.model.dbmodel.user.User;
import com.vip.orsuqrc.model.projection.user.UserProjection;
import com.vip.orsuqrc.repository.user.UserRepository;

@Service
@Transactional
public class UserHibernateService {

	private final UserRepository repository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public UserHibernateService(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	
	public UserProjection getUserById(Long userId) {
		return repository.findUserById(userId);
	}
	
	public UserProjection getUserForAuth(String username,String email) {
		return repository.findUserForAuth(username, email);
	}
	
	public void saveUser(UserProjection projection) {
		User user = projection.convertToUser();
		user.setPassword(bcrypt.encode(user.getPassword()));
		repository.save(user);
	}
	
	public boolean isUsernameExists(String username) {
		return repository.existsByUsername(username);
	}
	public boolean isEmailExists(String email) {
		return repository.existsByEmail(email);
	}
	public boolean isMobileExists(String mobile) {
		return repository.existsByMobile(mobile);
	}

}
