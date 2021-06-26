package com.vip.orsuqrc.service.security;

public interface SecurityLogin {
	String findLoggedInUsername();
	void autoLogin(String username,String Password);
}
