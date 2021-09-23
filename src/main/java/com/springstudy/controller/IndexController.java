package com.springstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springstudy.domain.Users;
import com.springstudy.service.IUserService;

@RestController
public class IndexController {

	@Autowired
	private IUserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping(value = "/findAll")
	public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
		PageRequest pageRequest = PageRequest.of(page, size, sort);
		return new ResponseEntity<>(userService.findAll(pageRequest), HttpStatus.OK);
	}

	@PostMapping(value = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}

}
