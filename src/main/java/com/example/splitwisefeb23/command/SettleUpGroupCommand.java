package com.example.splitwisefeb23.command;

import com.example.splitwisefeb23.controllers.SettleUpController;
import com.example.splitwisefeb23.dtos.SettleUpGroupRequestDTO;
import com.example.splitwisefeb23.dtos.SettleUpGroupRespnseDTO;
import com.example.splitwisefeb23.dtos.SettleUpUserRequestDTO;
import com.example.splitwisefeb23.dtos.SettleUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUpGroupCommand implements Command{
    @Autowired
    private SettleUpController settleUpController;

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        System.out.println(words);
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId =  Long.valueOf(words.get(1));

        SettleUpGroupRequestDTO request = new SettleUpGroupRequestDTO();
        request.setGroupId(groupId);

        SettleUpGroupRespnseDTO response =  settleUpController.settleUpGroup(request);
        System.out.println(response.getTransactions());
    }
}
