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


@RestController
public class Controller {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getPosts() {
        return service.getUsers();
    }

    @GetMapping("/users/{studentId}/Posts")
    public List<Post> retrievePostsForStudent(@PathVariable String userId) {
        return service.retrievePosts(userId);
    }

    @PostMapping("/users/{userId}/Posts")
    public ResponseEntity<Void> registerStudentForPost(
            @PathVariable String studentId, @RequestBody Post newPost) {

        Post Post = service.addPost(studentId, newPost);

        if (Post == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(Post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{userId}/Posts/{PostId}")
    public Post retrieveDetailsForPost(@PathVariable String userId,
                                           @PathVariable String PostId) {
        return service.retrievePost(userId, PostId);
    }

}

