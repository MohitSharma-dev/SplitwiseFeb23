package com.example.splitwisefeb23.command;

public interface Command {
    public boolean matches(String input);
    public void execute(String input);
}
