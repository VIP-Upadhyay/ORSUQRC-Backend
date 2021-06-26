package com.vip.orsuqrc.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vip.orsuqrc.component.otp.OTPgenerator;
import com.vip.orsuqrc.model.projection.user.UserProjection;
import com.vip.orsuqrc.model.simple.otp.OTPmodel;
import com.vip.orsuqrc.service.hibernate.user.UserHibernateService;

@RestController
public class RegisterController {

	@Autowired
	UserHibernateService dbServiceUser;
	@Autowired
	OTPgenerator otpGenerator;
	
	@RequestMapping(value = "/register-user",method = RequestMethod.POST,consumes = "application/json")
	public String registerUser(@RequestBody UserProjection user,HttpSession session) {
		
		if (dbServiceUser.isUsernameExists(user.getUsername())) {
			return "username is exists";
		}else {
			if (dbServiceUser.isEmailExists(user.getEmail())||dbServiceUser.isMobileExists(user.getMobile())) {
				return "email or mobile is exists";
			}else {
				OTPmodel otPmodel = otpGenerator.generate();
				session.setAttribute("otp", otPmodel);
				session.setAttribute("user", user);
				System.out.println(otPmodel);
				return user.toString();
			}
		}
		
	}
	
	
	@RequestMapping(value = "/register",method = RequestMethod.GET,produces = "application/json")
	public UserProjection registerdUser() {
		return new UserProjection("fname-lname", "pass", "fname", "lname", "e@e.com", "hello");
	}

}
