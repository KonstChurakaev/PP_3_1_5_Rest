package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);

    void addRole(Role role);

    void updateUser(Role role);

    void delRoleById(Long id);

    List<Role> getAllRoles();
}
