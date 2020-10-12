package com.vangreat.service;

import com.vangreat.model.User;

import java.util.List;

public interface UserService {
    void createUser(String name, String surname, String activity, String email);
    List<User> getAllUsers();
    User getUser(Long id);
    void editUser(User user);
    void deleteUser(Long id);
}
