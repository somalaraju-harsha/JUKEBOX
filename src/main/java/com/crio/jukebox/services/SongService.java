package com.crio.jukebox.services;

import java.io.BufferedReader;
// import java.io.FileNotFoundException;
import java.io.FileReader;
// import java.io.IOException;
import java.util.*;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService implements ISongService {

    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository=songRepository;
    }

    @Override
    public String loadSongs(String s){
        List<Song> li=readFile(s);
        songRepository.saveSongs(li);
        return "Songs Loaded successfully";
    }

    

    public List<Song> readFile(String s){
        
        try(BufferedReader csv = new BufferedReader(new FileReader(s))){
            List<String[]> cdata= new ArrayList<>();
            String line;
            while ((line = csv.readLine()) != null) {
                String[] row = line.split(",");
                cdata.add(row);
            }
            
            List<Song> songs = convert(cdata);
            return songs;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private List<Song> convert(List<String[]> cdata) {
        List<Song> songs = new ArrayList<>();
        for (String[] row : cdata) {
            String title = row[0];
            String genre = row[1];
            String album = row[2];
            String artist = row[3];
            String[] featuringArtists = row[4].split("#");
            List<String> li=Arrays.asList(featuringArtists);
            Song song = new Song(title,genre,album,artist,li);
           
            songs.add(song);
        }
        return songs;
    }

    public boolean findById(String id){
        boolean x= songRepository.findById(id);
    return x;
    }

    
}
 