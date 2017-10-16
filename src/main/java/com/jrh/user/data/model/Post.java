package com.jrh.user.data.model;


import java.util.List;

public class Post {
    private String id;
    private String name;
    private String text;
    private List<String> children;

    public Post() {

    }

    public Post(String id, String name, String text, List<String> children) {
        super();
        this.id = id;
        this.name = name;
        this.text = text;
        this.children = children;
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

    public String getName() {
        return name;
    }

    public List<String> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.format(
                "Post [id=%s, name=%s, description=%s, steps=%s]", id, name,
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
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
