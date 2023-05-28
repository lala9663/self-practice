package com.example.jwt.auth.repository;

import com.example.jwt.auth.domain.APIUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIUserRepository extends JpaRepository<APIUser, String> {
}
