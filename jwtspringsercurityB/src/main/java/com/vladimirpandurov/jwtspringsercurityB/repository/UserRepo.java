package com.vladimirpandurov.jwtspringsercurityB.repository;

import com.vladimirpandurov.jwtspringsercurityB.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
