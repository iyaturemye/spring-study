package com.springstudy.service;

import org.springframework.data.domain.PageRequest;

import com.springstudy.domain.Users;

public interface IUserService {

	Users createUser(Users user);

	Users findByEmail(final String email);

	Users findByUsername(final String username);

	Iterable<Users> findAll(PageRequest pageRequest);
}
