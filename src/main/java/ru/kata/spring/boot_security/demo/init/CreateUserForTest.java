package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CreateUserForTest implements ApplicationRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public CreateUserForTest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            Set<Role> userRole = new HashSet<>();
            Set<Role> adminRole = new HashSet<>();


            Role role1 = new Role("ROLE_ADMIN");
            Role role2 = new Role("ROLE_USER");

            roleService.addRole(role1);
            roleService.addRole(role2);

            userRole.add(role1);
            adminRole.add(role1);
            adminRole.add(role2);

            userService.saveUser(new User("Ivan", "Ivanov", (byte) 20, "admin@admin", "1", adminRole));
            userService.saveUser(new User("Oleg", "Petrov", (byte) 20, "user@user", "1", userRole));
        }
    }
}