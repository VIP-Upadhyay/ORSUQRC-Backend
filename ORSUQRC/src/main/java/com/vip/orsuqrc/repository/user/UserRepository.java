package com.vip.orsuqrc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vip.orsuqrc.model.dbmodel.user.User;
import com.vip.orsuqrc.model.projection.user.UserProjection;

public interface UserRepository extends JpaRepository<User, Long>  {
	
	@Query(value = "SELECT new com.vip.orsuqrc.model.projection.user.UserProjection(u.username,"
			+ "u.password,u.firstname,u.lastname,u.email,u.mobile)"
			+ "FROM User u WHERE u.userId = ?1")
	UserProjection findUserById(Long Id);
	
	@Query(value = "SELECT new com.vip.orsuqrc.model.projection.user.UserProjection(u.username,"
			+ "u.password,u.firstname,u.lastname,u.email,u.mobile)"
			+ "FROM User u WHERE u.username = ?1 OR u.email = ?2")
	UserProjection findUserForAuth(String username,String email);
	
	boolean existsByEmail(String email);
	boolean existsByMobile(String mobile);
	boolean existsByUsername(String username);
}
