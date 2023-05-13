package com.codegym.service;

import com.codegym.model.ERole;
import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    void addUser(User user);
    boolean existById(long id);
    User findById(long id);
    void updateUser(User user);
    void removeById(long id);
    User login(String username, String password, ERole role);
    List<User> findByName (String name);
    boolean existByUsername(String username);
    boolean existByPhone(String phone);
    boolean existByIdCardNum(String idcardnum);
    boolean existByEmail(String email);



}
