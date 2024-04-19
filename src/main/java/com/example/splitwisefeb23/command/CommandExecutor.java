package com.example.splitwisefeb23.command;

import com.example.splitwisefeb23.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    List<Command> commands;
    SettleUpGroupCommand settleUpGroupCommand;

    @Autowired
    public CommandExecutor(SettleUpGroupCommand settleUpGroupCommand){
        this.settleUpGroupCommand = settleUpGroupCommand;
        commands = new ArrayList<>();
        commands.add(this.settleUpGroupCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                return;
            }
        }
        throw new RuntimeException("Command not found!");
    }
}
