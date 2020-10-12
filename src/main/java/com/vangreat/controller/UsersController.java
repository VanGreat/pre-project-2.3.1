package com.vangreat.controller;

import com.vangreat.model.User;
import com.vangreat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user_page";
    }

    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "user_page";
    }

    @PostMapping()
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("activity") String activity,
                             @RequestParam("email") String email) {
        userService.createUser(name, surname, activity, email);
        return "redirect:/users";
    }

    @GetMapping("/remove_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
