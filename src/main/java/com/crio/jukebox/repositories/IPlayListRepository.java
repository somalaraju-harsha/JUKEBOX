package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.Playlist;

public interface IPlayListRepository {

    void savePlayList(String string, Playlist ply);

    public Playlist getPlaylist(String id);

    String getId(String playListName);

    boolean findById(String id);

    String deletePlaylist(String id);
    
}
