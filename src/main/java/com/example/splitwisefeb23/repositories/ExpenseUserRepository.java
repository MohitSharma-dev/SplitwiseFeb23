package com.example.splitwisefeb23.repositories;

import com.example.splitwisefeb23.models.ExpenseUser;
import com.example.splitwisefeb23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
