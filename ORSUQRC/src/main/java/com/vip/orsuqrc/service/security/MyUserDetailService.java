package com.vip.orsuqrc.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vip.orsuqrc.model.projection.user.UserProjection;
import com.vip.orsuqrc.service.hibernate.role.RoleHibernateService;
import com.vip.orsuqrc.service.hibernate.user.UserHibernateService;


@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserHibernateService dbServiceUser;
	@Autowired 
	RoleHibernateService dbServiceRole;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProjection projection;
		projection = dbServiceUser.getUserForAuth(username, username);
		if (projection==null) {		
			throw new UsernameNotFoundException("not found");		
		}
		return new UserPrincipal(projection,dbServiceRole.getRoleList());
	}
}
