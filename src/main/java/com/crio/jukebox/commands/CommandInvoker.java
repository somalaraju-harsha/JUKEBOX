package com.crio.jukebox.commands;

import java.util.*;
import com.crio.jukebox.exceptions.NoSuchCommandException;

public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command){
        commandMap.put(commandName,command);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public String executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if(command == null){
            // Handle Exception
            throw new NoSuchCommandException();
        }
        command.execute(tokens);
        return "";
    }
}
