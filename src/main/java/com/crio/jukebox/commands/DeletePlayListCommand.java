package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayListService;

public class DeletePlayListCommand implements ICommand {

    private final IPlayListService playListService;
    public DeletePlayListCommand(IPlayListService playListService) {
        this.playListService=playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println(playListService .deletePlaylist(tokens.get(2))); 
    }
    
}
