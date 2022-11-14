package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/allUsers")
    public String allUsers( Model model, Principal principal) {
        System.out.println("Зашел пользователь:"+userService.findByUserName(principal.getName()));
        model.addAttribute("userAdmin", userService.findByUserName(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("user", userService.getAllUser());
        model.addAttribute("listRoles", roleService.getAllRoles());

        return "allUsers";
    }

    @PostMapping(value = "/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        System.out.println("Добавляю: "+ user);
        userService.addUser(user);
        return "redirect:/admin/allUsers";
    }

    @PostMapping(value = "/edit/{id}")
    public String userUpdate(@ModelAttribute("user") User user) {

        System.out.println("редактирую: "+user);

        userService.updateUser(user);
        return "redirect:/admin/allUsers";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        System.out.println("удален пользователь: "+userService.getUserById(id));

        userService.removeUserById(id);
        return "redirect:/admin/allUsers";
    }
}