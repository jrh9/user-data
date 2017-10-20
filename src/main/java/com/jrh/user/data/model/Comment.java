package com.jrh.user.data.model;


import java.util.ArrayList;
import java.util.List;

public class Comment extends Post {
    private String id;
    private String submittedBy;
    private String text;
    private List<Comment> children;

    public Comment() {

    }

    public Comment(String id, String submittedBy, String text, List<Comment> children) {
        this.id = id;
        this.submittedBy = submittedBy;
        this.text = text;
        this.children = children;
    }

    public Comment(String id) {
        this.id = id;
        this.submittedBy = submittedBy;
        this.text = text;
        this.children = new ArrayList<Comment>();
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

    public String getsubmittedBy() {
        return submittedBy;
    }

    public List<Comment> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.format(
                "Comment [id=%s, submittedBy=%s, description=%s, steps=%s]", id, submittedBy,
                text, children);
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
        Comment other = (Comment) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

}
