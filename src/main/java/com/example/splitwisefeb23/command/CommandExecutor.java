package com.example.splitwisefeb23.command;

import com.example.splitwisefeb23.controllers.SettleUpController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class CommandExecutor {
    List<Command> commands;

    public CommandExecutor(){
        commands = new ArrayList<>();
        commands.add(new SettleUpUserCommand(new SettleUpController()));
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
