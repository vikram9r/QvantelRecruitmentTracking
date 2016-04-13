package com.qvantel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qvantel.dao.UserDAO;
import com.qvantel.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/newUser")
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("user");
		model.addObject("user", new User());
		return model;
	}
	
	@RequestMapping(value="/createUser")
	public ModelAndView createUser(@ModelAttribute("user")User user) {
		ModelAndView model = new ModelAndView("home");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.create(user);
		return model;
	}
}
