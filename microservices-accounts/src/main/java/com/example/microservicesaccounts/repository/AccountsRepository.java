package com.example.microservicesaccounts.repository;

import com.example.microservicesaccounts.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts ,Integer> {
    Optional<Accounts> findById(Integer id);
    Accounts save(Accounts accounts);
    void delete(Accounts accounts);
}
