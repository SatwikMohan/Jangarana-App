package com.woc.jangarana.models;

public class FClusterAuthentication {
    String token;
    String email;
    String id;
    String head_name;

    public FClusterAuthentication(String token, String id, String email, String head_name) {
        this.token = token;
        this.email = email;
        this.id = id;
        this.head_name = head_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead_name() {
        return head_name;
    }

    public void setHead_name(String head_name) {
        this.head_name = head_name;
    }
}
