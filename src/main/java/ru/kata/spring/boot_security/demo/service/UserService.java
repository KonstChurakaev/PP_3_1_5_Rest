package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    void removeUserById(Long id);

    List<User> getAllUser();

    User getUserById(Long id);

    void updateUser(User user);

    User findByUserName(String name);
}
