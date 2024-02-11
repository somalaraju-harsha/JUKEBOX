package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
    //     try{
    //     if(tokens.get(2).contains(" ")){
    //         String[] ss=tokens.get(2).split(" ");
    //         int q=Integer.parseInt(tokens.get(3));
    //         List<Contest> li= new ArrayList<>();
    //         li.add(contestService.create(tokens.get(1), Level.valueOf(ss[0]), ss[1],q ));
            
    //         for(Contest xx:li){
    //             System.out.println(xx);
    //         }
    //     }
    //     else{
    //         List<Contest> li= new ArrayList<>();
    //         li.add(contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)), tokens.get(3),null ));
    //         // System.out.println(li);
    //         for(Contest xx:li){
    //             System.out.println(xx);
    //          }
    //     }
    // }
    // catch(Exception e){
    //     System.out.println(e.getMessage());
    // }
    // }
    try {
        Contest contest;
        if (tokens.size() == 5) {
            contest = contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)), tokens.get(3),
                    Integer.parseInt(tokens.get(4)));
        } else {
            contest = contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)),
                    tokens.get(3), null);
        }
        System.out.println(contest.toString());
    } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
    }

    }
    
}
