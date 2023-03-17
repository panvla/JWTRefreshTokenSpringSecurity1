package com.vladimirpandurov.jwtspringsercurityB.service.implementation;

import com.vladimirpandurov.jwtspringsercurityB.domain.Role;
import com.vladimirpandurov.jwtspringsercurityB.domain.User;
import com.vladimirpandurov.jwtspringsercurityB.repository.RoleRepo;
import com.vladimirpandurov.jwtspringsercurityB.repository.UserRepo;
import com.vladimirpandurov.jwtspringsercurityB.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to rhe database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role to rhe database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role to user");
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user from database");
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all users from the database");
        return userRepo.findAll();
    }
}
