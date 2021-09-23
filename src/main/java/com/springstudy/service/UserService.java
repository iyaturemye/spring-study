package com.springstudy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springstudy.domain.Users;
import com.springstudy.repo.IUserRepo;

@Service
@Transactional
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepo userRepo;

	@Override
	public Users createUser(Users user) {
		return userRepo.save(user);
	}

	@Override
	public Users findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Users user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

	@Override
	public Iterable<Users> findAll(final PageRequest pageRequest) {
		return userRepo.findAll(pageRequest);
	}

	@Override
	public Users findByUsername(final String username) {
		return userRepo.findByUsername(username);
	}

}
