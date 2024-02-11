package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exceptions.PlayListIdNotExistException;

public class PlayListRepository implements IPlayListRepository{

    private final Map<String,Playlist> playListMap;

    public PlayListRepository(){
        playListMap=new HashMap<>();
    }
    public PlayListRepository(Map<String,Playlist> playListMap){
        this.playListMap=playListMap;
    }

    public void savePlayList(String id,Playlist plylst){
        playListMap.put(id,plylst);
    }

    public Playlist getPlaylist(String id){
        if(playListMap.containsKey(id)){
            return playListMap.get(id);
        }
        return null;
    }

    public String deletePlaylist(String id){
        playListMap.remove(id);
        return "Delete Successful";
    }

    public String getId(String playListName){
        // String s=playListMap.get(id);
        for(Map.Entry<String,Playlist> x:playListMap.entrySet()){
            if((x.getValue().getPlayListName()).equals(playListName)){
                return x.getKey();
            }
        }
        return "Playlist not Found";
    }
    public boolean findById(String id) throws PlayListIdNotExistException{
        if(playListMap.containsKey(id)){
           return true;
        }
        else{
            return false;
        }
    }
    
}
