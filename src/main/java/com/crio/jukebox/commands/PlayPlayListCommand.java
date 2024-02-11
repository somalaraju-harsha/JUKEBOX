package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayListService;

public class PlayPlayListCommand implements ICommand{

    private final IPlayListService playListService;

    public PlayPlayListCommand(IPlayListService playListService) {
        this.playListService=playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println(playListService.plyPlylist(tokens.get(2)));
    }
    
}
