package com.vapasi.justcinemas.repository;

import com.vapasi.justcinemas.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
