package com.example.splitwisefeb23.services;

import com.example.splitwisefeb23.Utik.Transaction;
import com.example.splitwisefeb23.models.Expense;
import com.example.splitwisefeb23.models.ExpenseUser;
import com.example.splitwisefeb23.models.Group;
import com.example.splitwisefeb23.models.User;
import com.example.splitwisefeb23.repositories.ExpenseRepository;
import com.example.splitwisefeb23.repositories.ExpenseUserRepository;
import com.example.splitwisefeb23.repositories.GroupRepository;
import com.example.splitwisefeb23.repositories.UserRepository;
import com.example.splitwisefeb23.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    SettleUpService(
            GroupRepository groupRepository,
            ExpenseRepository expenseRepository,
            SettleUpStrategy settleUpStrategy,
            UserRepository userRepository,
            ExpenseUserRepository expenseUserRepository
    ){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }
    public List<Expense> settleUpUser(
            Long userId
    ){
        // 1. Validate the user
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found!");
        }
        User user = userOptional.get();
        // 2. getting all the expenses related to the User
        List<ExpenseUser> expenseUsers =  expenseUserRepository.findAllByUser(user);
        Set<Expense> expenseSet = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenseSet.add(expenseUser.getExpense());
        }
        // 3. Iterate through all the expenses to find out who owes what
        // 4. Find the transactions to be done
//        List<Expense> transactions =  settleUpStrategy.settleUp(expenseSet.stream().toList());
        // 5. return transactions
        return null;
    }

    public List<Transaction> settleUpGroup(
            Long groupId
    ){
        // 1. validate the Group
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group Doesn't exist");
        }
        Group group = groupOptional.get();
        // 2. Extract out all the expenses
        List<Expense> expenses = expenseRepository.findAllByGroup(group);
        System.out.println(expenses);
        // 3. Iterate through all the expenses to find out who owes what
        // 4. Find the transactions to be done
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        // 5. return transactions
        return transactions;

    }
}

// Expense1 A : had to pay : 1000 : same expense
// Expense1 A : paid : 500

// Expense 1
// Paid : A : 1000 , B : 500
// Had to pay : A : 750 , B : 750

// ExpenseUser 1
// Expense 1 : A : paid : 1000
// ExpenseUser 2
// Expense 1 : B : paid : 500
// ExpenseUser 3
// Expense 1 : A : Had to pay : 750
// ExpenseUser 4

// Expense 1
// whoPaid :
    // A : 1000 , B : 500
// whoHadtoPay :
    // A : 250 , B : 1000 , C : 250

// ExpenseUser1
// Expense : Expense1 , User : A , amt : 1000

// ExpenseUser2
// Expense : Expense1 , User : A , amt : 250
