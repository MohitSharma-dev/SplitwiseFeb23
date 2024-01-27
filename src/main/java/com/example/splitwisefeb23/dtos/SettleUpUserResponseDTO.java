package com.example.splitwisefeb23.dtos;

import com.example.splitwisefeb23.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private List<Expense> transactions;
}
