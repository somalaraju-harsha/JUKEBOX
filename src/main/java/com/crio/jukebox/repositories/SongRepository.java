package com.crio.jukebox.repositories;
// import java.*;
import java.util.*;
// import java.io.*;
import com.crio.jukebox.entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<String,Song> songMap;
    private Integer countId=0;

    public SongRepository(){
        songMap=new HashMap<>();
    }
    public SongRepository(Map<String,Song> songMap){
        this.songMap=songMap;
        this.countId=songMap.size();
    }
    @Override
    public List<Song> findAllSong() {
        // TODO Auto-generated method stub
        List<Song> ans=new ArrayList<>();
        List<String> res=new ArrayList<>();
        for(Map.Entry<String,Song> x: songMap.entrySet()){
            res.add(x.getKey());
        }
        Collections.sort(res,(a,b)->{
            if(Integer.parseInt(a)>Integer.parseInt(b)){
                return 1;
            }
            else if(Integer.parseInt(a)<Integer.parseInt(b)){
                return -1;
            }
            else{
                return 0;
            }
        });

        for(String x:res){
            ans.add(songMap.get(x));
        }

        return ans;
    }
    @Override
    public void saveSongs(List<Song> songs) {
        // TODO Auto-generated method stub
            for(Song s:songs){
                countId++;
                songMap.put(""+countId,s);
            }
    }

    public boolean findById(String id){
        if(songMap.containsKey(id)){
            return true;
        }else
        return false;
    }

    public Song getById(String id){
        Song s=songMap.get(id);
        return s;
    }
    
    
}
