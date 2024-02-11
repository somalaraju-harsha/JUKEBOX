package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.ISongService;

public class LoadSongCommand implements ICommand{

    private final ISongService songService;
    public LoadSongCommand(ISongService songService){
        this.songService=songService;
    }
    @Override
    public void execute(List<String> tokens) {
        System.out.println(songService.loadSongs(tokens.get(1)));
       
    }
    
}
