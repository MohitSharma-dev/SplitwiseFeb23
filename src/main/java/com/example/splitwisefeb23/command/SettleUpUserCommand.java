package com.example.splitwisefeb23.command;

import com.example.splitwisefeb23.controllers.SettleUpController;
import com.example.splitwisefeb23.dtos.SettleUpUserRequestDTO;
import com.example.splitwisefeb23.dtos.SettleUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUpUserCommand implements Command{
    private SettleUpController settleUpController;

    SettleUpUserCommand(SettleUpController settleUpController){
      this.settleUpController = settleUpController;
    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        System.out.println(words);
        if(words.size() == 2 && words.get(0).equals("SettleUpUser")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId =  Long.valueOf(words.get(1));

        SettleUpUserRequestDTO request = new SettleUpUserRequestDTO();
        request.setUserId(userId);

        SettleUpUserResponseDTO settleUpUserResponseDTO =  settleUpController.settleUpUser(request);
    }
}
