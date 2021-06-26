package com.vip.orsuqrc.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vip.orsuqrc.model.projection.role.RoleProjection;
import com.vip.orsuqrc.model.projection.user.UserProjection;

public class UserPrincipal implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserProjection user;
	List<RoleProjection> roleList;
	public UserPrincipal(UserProjection user,List<RoleProjection> roleList) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.roleList = roleList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    for (RoleProjection role : roleList) {
	        authorities.add(new SimpleGrantedAuthority(role.getName()));
	    }
	    return authorities;
//		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
