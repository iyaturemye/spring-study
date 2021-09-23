package com.springstudy.repo;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springstudy.domain.Users;

@Repository
public interface IUserRepo extends PagingAndSortingRepository<Users, UUID> {

	Users findByEmail(final String email);

	Users findByUsername(final String username);
}
