package com.jrh.user.data.model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private int karma;
    private List<Post> posts;

    public User(String id, String name, int karma,
                   List<Post> posts) {
        super();
        this.id = id;
        this.name = name;
        this.karma = karma;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getKarma() { return karma; }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }


    @Override
    public String toString() {
        return String.format(
                "Student [id=%s, name=%s, description=%s, Posts=%s]", id,
                name, karma, posts);
    }
}