package com.codegym.model;

import com.codegym.service.IModel;

import java.util.Date;

public class User implements IModel<User> {
    private long userID;
    private String username;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private ERole role;
    private Date createdDate;

    public User(){};

    public User(long userID, String username, String password, String fullname, String address, String phone, String email, ERole role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public User parseData(String line) {
        User user = new User();
        String[] strings = line.split(",");
        int userID = Integer.parseInt(strings[0]);
        String username = strings[1];
        String password = strings[2];
        String fullname = strings[3];
        String address = strings[4];
        String phone = strings[5];
        String email = strings[6];
        ERole eRole = ERole.findRoleByString(strings[7]);
        user.setUserID(userID);
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(eRole);
        return user;
    }
}
