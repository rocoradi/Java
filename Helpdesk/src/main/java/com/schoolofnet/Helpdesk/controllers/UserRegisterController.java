/**
 * @author Coradi
 *
 * 8 de jan de 2018
 */
package com.schoolofnet.Helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.Helpdesk.models.User;
import com.schoolofnet.Helpdesk.services.UserService;

@Controller
@RequestMapping("/users/register")
public class UserRegisterController {
	
	@Autowired
	private UserService userService;

	public UserRegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "auth/registration";
		}
		
		this.userService.create(user);
		
		return "redirect:/login";
	}

}
