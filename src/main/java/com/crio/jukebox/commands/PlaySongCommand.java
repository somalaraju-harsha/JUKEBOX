package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayListService;

public class PlaySongCommand implements ICommand {

    public PlaySongCommand(IPlayListService playListService) {}

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        
    }
    
}
