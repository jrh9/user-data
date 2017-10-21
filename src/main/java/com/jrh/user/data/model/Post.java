package com.jrh.user.data.model;


import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String title;
    private String text;
    private String submittedBy;
    private List<Comment> comments;

    public Post() {

    }

    public Post(String id, String title, String text, String submittedBy, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.submittedBy = submittedBy;
        this.comments = comments;
    }

    public Post(String id) {
        this.id = id;
        this.title = "";
        this.text = "";
        this.submittedBy = "";
        this.comments = new ArrayList<Comment>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public  void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return String.format(
                "Post [id=%s, title=%s, description=%s, steps=%s]", id, title,
                text, comments);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
