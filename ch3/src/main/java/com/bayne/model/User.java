package com.bayne.model;

public class User {

    private String id;

    private String name;

    private String password;

    public User(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
