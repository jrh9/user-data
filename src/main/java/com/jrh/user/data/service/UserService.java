package com.jrh.user.data.service;

import com.jrh.user.data.model.Post;
import com.jrh.user.data.model.User;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private static List<User> users = new ArrayList<>();

    static {
        //Initialize Data
        Post course1 = new Post("Post1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Post course2 = new Post("Post2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Post course3 = new Post("Post3", "Spring Boot", "6K Users",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Post course4 = new Post("Post4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        User s1 = new User("s1", "Ranga Karanam",
                1, new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        User s2 = new User("s2", "Satish T",
                2, new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        User s3 = new User("jh", "Satish T",
                3,  new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        User s4 = new User("jh2", "Satish T",
                4, new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        users.add(s1);
        users.add(s2);
        users.add(s3);
        users.add(s4);
    }

    public List<User> retrieveAllUsers() {
        return users;
    }

    public User retrieveUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public List<Post> retrievePosts(String userId) {
        User user = retrieveUser(userId);

        if(userId.equalsIgnoreCase("User1")){
            throw new RuntimeException("Something went wrong");
        }

        if (user == null) {
            return null;
        }

        return user.getPosts();
    }

    public Post retrievePost(String userId, String courseId) {
        User user = retrieveUser(userId);

        if (user == null) {
            return null;
        }

        for (Post course : user.getPosts()) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    private SecureRandom random = new SecureRandom();

    public Post addPost(String userId, Post course) {
        User user = retrieveUser(userId);

        if (user == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);

        user.getPosts().add(course);

        return course;
    }

    public List<User> getUsers() {
        return users;
    }
}