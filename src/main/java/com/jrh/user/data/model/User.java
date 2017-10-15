package com.jrh.user.data.model;

import com.jrh.user.data.dto.CreateUserBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Id;

public class User {

    @Id
    private int id;

    private String username;

    private String password;

    private String email;

    public User(int id, String username, String password, String email) {

        this.id = id;
        this.password = password;
        this.username = password;
        this.email = email;
    }

    public User(CreateUserBean bean) {
        this.id = bean.getId();
        this.password = bean.getPassword();
        this.username = bean.getUsername();
        this.email = bean.getPassword();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + username +
                ", email=" + email + "]";
    }

}
