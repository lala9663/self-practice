package com.example.selfpractice.repository;

import com.example.selfpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);

    Optional<User> findByPw(String pw);

    Optional<User> findByIdAndPw(String id, String pw);


}
