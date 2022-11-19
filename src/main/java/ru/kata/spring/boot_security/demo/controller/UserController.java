package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String getUserInfo(Principal principal, Model model) {
        //principal - сжатая информация о текущем пользователе
        model.addAttribute("user", userService.findUserByEmail(principal.getName()));
        return "user";
    }

//    @GetMapping("/user")
//    public String getUser() {
//        return "user";
//    }

    @GetMapping(value = "/admins")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping(value = "admins/new")
    public String addUser(Model model) {
        List<Role> role = roleService.getAllRoles();
        model.addAttribute("listRole", role);
        return "addUser";
    }
}