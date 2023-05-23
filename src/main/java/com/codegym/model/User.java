package com.codegym.model;

import com.codegym.service.IModel;

import java.util.Date;

public class User implements IModel<User> {
    private long userID;
    private String username;
    private String password;
    private String fullname;
    private String idcardnum;
    private String address;
    private String phone;
    private String email;
    private ERole role;
    public User(){};

    public User(long userID, String username, String password, String fullname, String idcardnum,String address, String phone, String email, ERole role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.idcardnum = idcardnum;
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

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum;
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
        return  userID +
                "," + username +
                "," + password +
                "," + fullname +
                "," + idcardnum +
                "," + address +
                "," + phone +
                "," + email +
                "," + role;
    }

    @Override
    public User parseData(String line) {
        User user = new User();
        String[] strings = line.split(",");
        int userID = Integer.parseInt(strings[0]);
        String username = strings[1];
        String password = strings[2];
        String fullname = strings[3];
        String idcardnum = strings[4];
        String address = strings[5];
        String phone = strings[6];
        String email = strings[7];
        ERole eRole = ERole.findRoleByString(strings[8]);
        user.setUserID(userID);
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setIdcardnum(idcardnum);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(eRole);
        return user;
    }
    public String toData() {
        return String.format("║%15s║ %19s║ %15s║ %12s║ %15s║ %20s║ %15s║\n",userID,fullname,idcardnum,phone,address,email,role);
    }

}
