package com.crio.jukebox.repositories;

// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.util.List;
import com.crio.jukebox.entities.Song;

public interface ISongRepository {
    public List<Song> findAllSong();
    public void saveSongs(List<Song> songs);
    public boolean findById(String s);
    public Song getById(String string);
}
