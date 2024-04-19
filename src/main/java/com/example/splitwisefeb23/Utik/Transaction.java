package com.example.splitwisefeb23.Utik;

import com.example.splitwisefeb23.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User userFrom;
    private User userTo;
    private Integer amount;

    public String toString(){
        return "Transaction : " + userFrom.getName() + " to " + userTo.getName() + " amount : " + amount;
    }
}
