package com.jrh.user.data.service.impl;

import com.jrh.user.data.dto.CreateUserBean;
import com.jrh.user.data.model.User;
import com.jrh.user.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private static List<User> users;

    private static int count = users.size();

    static {
        users = populateDummyUsers();
    }


    public User createUser(CreateUserBean bean) {
        User newUser = new User(bean);

        users.add(newUser);

        return newUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }

        return null; // To-do: Return 401 USER_NOT_FOUND
    }

    private static int getId() {
        return count++;
    }
    private static List<User> populateDummyUsers() {
        users = new ArrayList<>();
        users.add(new User(getId(), "user1", "pw1", "user1@abc.com"));
        users.add(new User(getId(), "user2", "pw2", "user2@xyz.com"));
        users.add(new User(getId(), "user3", "pw3", "user3@xyz.com"));
        users.add(new User(getId(), "user4", "pw4", "user4@xyz.com"));

        return users;
    }

}
