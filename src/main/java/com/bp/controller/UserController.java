package com.bp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.bp.model.User;
import com.bp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/new")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("formAction", "/users");
		return "addUser";
	}

	@GetMapping("/edit")
	public String updateUser(@RequestParam("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("formAction", "/users/edit");
		return "addUser";
	}

	@PostMapping
	public String create(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("formAction", "/users");
			return "addUser";
		}
		userService.save(user);
		return "redirect:/users";
	}

	@PostMapping("/edit")
	public String update(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("formAction", "/users/edit");
			return "addUser";
		}
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		userService.delete(id);
		return "redirect:/users";
	}
}