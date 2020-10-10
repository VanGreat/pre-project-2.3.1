package com.vangreat.dao;

import com.vangreat.model.User;

import java.util.List;

public interface UserDao {
    void createUser(String name, String surname, String activity, String country);
    List<User> getAllUsers();
    User getUser(Long id);
    void editUser(User user);
    void deleteUser(Long id);
}
