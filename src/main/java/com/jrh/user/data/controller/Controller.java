package com.jrh.user.data.controller;

import java.net.URI;
import java.util.List;

import com.jrh.user.data.model.Post;
import com.jrh.user.data.model.User;
import com.jrh.user.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.POST;


@RestController
public class Controller {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }


    @PostMapping("/users")
    public ResponseEntity<Void> createUser(
            @RequestBody String username) {

        User user = service.addUser(username);

        if (user == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return service.getPosts();
    }

    @GetMapping("/users/{username}/posts")
    public List<Post> retrievePostsByUsername(@PathVariable String username) {
        return service.retrievePosts(username);
    }

    @PostMapping("/users/{username}/posts")
    public ResponseEntity<Void> registerStudentForPost(
            @PathVariable String username, @RequestBody Post newPost) {

        Post post = service.addPost(username, newPost);

        if (post == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}

