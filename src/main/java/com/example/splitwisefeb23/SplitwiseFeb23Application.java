package com.example.splitwisefeb23;

import com.example.splitwisefeb23.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseFeb23Application implements CommandLineRunner {
    @Autowired
    private CommandExecutor commandExecutor;
    private Scanner sc = new Scanner(System.in);


    SplitwiseFeb23Application(){
    }
    @Override
    public void run(String... args) throws Exception {
        while (true){
            String input = sc.nextLine();
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseFeb23Application.class, args);
    }

}


// 1. Settle-up User : User
// 2. Settle-up group : Group
// SettleUpController

// Settle Up Algo
// connect controller to Service