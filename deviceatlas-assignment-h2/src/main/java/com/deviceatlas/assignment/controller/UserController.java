package com.deviceatlas.assignment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deviceatlas.assignment.model.User;
import com.deviceatlas.assignment.service.UserRepository;

import io.EazyDev.DABackEnd.services.FriendsService;
import io.EazyDev.DABackEnd.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserService userService;
	    
	@Autowired
	FriendsService friendsService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showUsers(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("users", repository.findByUser(name));
		//model.put("todos", service.retrieveTodos(name));
		return "user";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

	
}
