//package com.example.redis.v1.repository;
//
//
//import com.example.redis.entity.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UsersRepository extends JpaRepository<Users, Long> {
//    Optional<Users> findByEmail(String email);
//    boolean existsByEmail(String email);
//
//    Optional<Users> findByPassword(String password);
//
//}
