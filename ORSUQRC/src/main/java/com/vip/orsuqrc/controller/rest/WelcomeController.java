package com.vip.orsuqrc.controller.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


	@RequestMapping(value = "/")
	public String getWelcome(Principal principal) {
		System.out.println(principal.getName());
		return "hello";
	}

}
