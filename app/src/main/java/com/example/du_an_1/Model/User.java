package com.example.du_an_1.Model;

public class User {
    private String email;
    private String username;
    private String phone;
    private String password;
    private String startAt;
    private String isStaff;
    private String Avatar;

    public User() {
    }

    public User(String email, String username, String phone, String password, String startAt, String isStaff, String avatar) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.startAt = startAt;
        this.isStaff = "false";
        Avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }
}
