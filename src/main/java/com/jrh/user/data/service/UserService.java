package com.jrh.user.data.service;

import com.jrh.user.data.dto.CreateUserBean;
import com.jrh.user.data.model.User;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {

    User createUser(CreateUserBean bean);
    List<User> getUsers();
}
