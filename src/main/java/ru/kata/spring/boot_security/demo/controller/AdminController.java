package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;
import java.util.List;

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
    public String allUsers(Model model, Principal principal) {
        model.addAttribute("listRoles", roleService.getAllRoles());
        return "allUsers";
    }

    @GetMapping(value = "/addPage")
    public String getFormAddUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listRole", roleService.getAllRoles());
        return "addUser";
    }

    @PostMapping(value = "/addNewUser")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/allUsers";
    }

    @GetMapping(value = "/editPage/{id}")
    public String getFormEditUser(Model model, @PathVariable("id") Long id) {
        System.out.println("Идем на страницу редактирования пользователя: " + userService.getUserById(id));
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listRole", roleService.getAllRoles());
        return "editUser";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println("редактируем пользователя " + user);
        userService.updateUser(user);
        return "redirect:/admin/allUsers";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        System.out.println("удален пользователь: " + userService.getUserById(id));

        userService.removeUserById(id);
        return "redirect:/admin/allUsers";
    }
}