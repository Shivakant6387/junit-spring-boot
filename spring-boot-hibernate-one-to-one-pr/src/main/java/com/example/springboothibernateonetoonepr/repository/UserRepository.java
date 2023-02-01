package com.example.springboothibernateonetoonepr.repository;

import com.example.springboothibernateonetoonepr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
