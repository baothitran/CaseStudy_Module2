package com.codegym.service;

import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.utils.FileUtils;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{
    private final String filePath = "F:\\BaoThi\\CaseStudy_Module2\\src\\main\\java\\com\\codegym\\data\\user.csv";
    @Override
    public List<User> getAllUsers() {
        return FileUtils.readData(filePath, User.class);
    }

    @Override
    public void addUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        FileUtils.writeDataToFile(filePath, users);
    }

    @Override
    public User findById(long id) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserID() == id)
                return user;
        }
        return null;
    }
    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }

    @Override
    public void updateUser(User user) {
        List<User> users = getAllUsers();
        for (User user1 : users) {
            if (user1.getUserID() == user.getUserID()) {
                String username = user.getUsername();
                String password = user.getPassword();
                String fullname = user.getFullname();
                String address = user.getAddress();
                String phone = user.getPhone();
                String email = user.getEmail();
                ERole role = user.getRole();
                user1.setUsername(username);
                user1.setPassword(password);
                user1.setFullname(fullname);
                user1.setAddress(address);
                user1.setPhone(phone);
                user1.setEmail(email);
                user1.setRole(role);
                FileUtils.writeDataToFile(filePath,users);
                break;
            }
        }
    }

    @Override
    public void removeById(long id) {
        List<User> users = getAllUsers();
        for (int i = 0; i<users.size(); i++) {
            if ((users.get(i)).getUserID() == id) {
                users.remove(users.get(i));
            }
        }
        FileUtils.writeDataToFile(filePath, users);
    }

    @Override
    public User login(String username, String password, ERole role) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)
                && user.getPassword().equals(password) && user.getRole() == role) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users = getAllUsers();
        List<User> userList = new ArrayList<>();
        for (User user1 : users) {
            if ((user1.getFullname().toLowerCase()).contains(name.toLowerCase())) {
                userList.add(user1);
            }
        }
        if (userList.isEmpty()) {
            return null;
        }
        return userList;
    }

    @Override
    public boolean existByUsername(String username) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByPhone(String phone) {
        List<User> users = getAllUsers();
        for(User user : users) {
            if (user.getPhone().equals(phone))
                return  true;
        }
        return false;
    }

    @Override
    public boolean existByEmail(String email) {
        List<User> users = getAllUsers();
        for(User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

}
