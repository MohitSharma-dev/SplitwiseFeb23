package com.example.splitwisefeb23.strategies;

import com.example.splitwisefeb23.Utik.Transaction;
import com.example.splitwisefeb23.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
