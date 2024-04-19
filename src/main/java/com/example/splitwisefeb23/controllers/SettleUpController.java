package com.example.splitwisefeb23.controllers;

import com.example.splitwisefeb23.Utik.Transaction;
import com.example.splitwisefeb23.dtos.SettleUpGroupRequestDTO;
import com.example.splitwisefeb23.dtos.SettleUpGroupRespnseDTO;
import com.example.splitwisefeb23.dtos.SettleUpUserRequestDTO;
import com.example.splitwisefeb23.dtos.SettleUpUserResponseDTO;
import com.example.splitwisefeb23.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    SettleUpService settleUpService;

    @Autowired
    SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO settleUpUserRequestDTO){
        return null;
    }

    public SettleUpGroupRespnseDTO settleUpGroup(SettleUpGroupRequestDTO settleUpGroupRequestDTO){
        SettleUpGroupRespnseDTO responseDTO = new SettleUpGroupRespnseDTO();
        try {
            List<Transaction> transactions = settleUpService.settleUpGroup(settleUpGroupRequestDTO.getGroupId());
            responseDTO.setTransactions(transactions);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }

}
