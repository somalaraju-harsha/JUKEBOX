package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.services.IPlayListService;

public class ModifyPlayListCommand implements ICommand{
    private final IPlayListService playListService;
    public ModifyPlayListCommand(IPlayListService playListService) {
        this.playListService=playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        List<String> li=new ArrayList<>();
        for(int i=4;i<tokens.size();i++){
            li.add(tokens.get(i));
        }
        String uId=tokens.get(2);
        String pId=tokens.get(3);
        if(tokens.get(1).equals("ADD-SONG")){
            try{
            System.out.println( playListService.modAddSong(uId,pId,li));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(tokens.get(1).equals("DELETE-SONG")){
            try{
                System.out.println(playListService.modDltSong(uId,pId,li));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
}
