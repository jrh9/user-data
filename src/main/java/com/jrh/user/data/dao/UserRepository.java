package com.jrh.user.data.dao;

import java.util.List;

import com.jrh.user.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByRole(String role);
}
