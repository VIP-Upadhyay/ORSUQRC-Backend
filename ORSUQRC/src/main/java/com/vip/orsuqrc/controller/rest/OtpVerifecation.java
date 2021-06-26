package com.vip.orsuqrc.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vip.orsuqrc.model.projection.user.UserProjection;
import com.vip.orsuqrc.model.simple.otp.OTPmodel;
import com.vip.orsuqrc.service.hibernate.user.UserHibernateService;
import com.vip.orsuqrc.service.security.SecurityLogin;


@RestController
public class OtpVerifecation {
	@Autowired
	SecurityLogin security;
	@Autowired
	UserHibernateService dbServiceUser;

	@RequestMapping(value = "/verify-otp",method = RequestMethod.POST,consumes = "application/json")
	public String verifyOTP(@RequestBody Integer otp,HttpSession session) {
		if (session!=null) {
			if (session.getAttribute("user")!=null&&session.getAttribute("otp")!=null) {
				String returnString = "";
				OTPmodel otPmodel = (OTPmodel) session.getAttribute("otp");
				System.out.println(otPmodel.getOTP()+" = "+otp);
				if (otPmodel.getOTP() == otp) {
					System.out.println("success");
					UserProjection projection =(UserProjection) session.getAttribute("user");
					dbServiceUser.saveUser(projection);
					security.autoLogin(projection.getUsername(), projection.getPassword());
					returnString = "success";
				}else {
					System.out.println("failure");
					returnString = "failure";
				}
				System.out.println("otp verified");
				return returnString;
			}else {
				return "user or otp is not set";
			}
		}else {
			return "session is null";
		}
	}

}
