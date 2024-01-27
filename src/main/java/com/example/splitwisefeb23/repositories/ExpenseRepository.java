package com.example.splitwisefeb23.repositories;

import com.example.splitwisefeb23.models.Expense;
import com.example.splitwisefeb23.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(Group group);
}
