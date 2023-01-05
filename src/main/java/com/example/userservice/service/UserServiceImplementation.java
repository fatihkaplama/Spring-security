package com.example.userservice.service;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.repo.RoleRepo;
import com.example.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}