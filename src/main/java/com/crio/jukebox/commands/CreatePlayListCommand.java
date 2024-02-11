package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
// import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exceptions.SongNotAvailableException;
import com.crio.jukebox.services.IPlayListService;
import com.crio.jukebox.services.ISongService;

public class CreatePlayListCommand implements ICommand {

    private final IPlayListService playListService;

    public CreatePlayListCommand(IPlayListService playListService,ISongService songService){
        this.playListService=playListService;
    }
    @Override
    public void execute(List<String> tokens) throws SongNotAvailableException {
        // String pid="";
        List<String> li=new ArrayList<>();
        for(int i=3;i<tokens.size();i++){
            li.add(tokens.get(i));
        }
        try{
        System.out.println(playListService.createPlayList(tokens.get(1),tokens.get(2),li));
        }catch(SongNotAvailableException e){
            e.printStackTrace();
        }
        // System.out.println("Playlist ID - "+pid);
    }
    
}
