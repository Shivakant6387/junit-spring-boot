package com.example.microservicestask.repository;

import com.example.microservicestask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  Optional<User> findById(Integer id);

  User save(User userModel);
  //User update (User userModel);
}
