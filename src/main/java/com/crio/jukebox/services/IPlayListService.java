package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exceptions.SongNotAvailableException;

public interface IPlayListService {

    public String createPlayList(String userId,String playListName,List<String> songId) throws SongNotAvailableException;
    public String deletePlaylist(String id);
    public String modAddSong(String uId, String pId, List<String> li);
    public String modDltSong(String uId, String pId, List<String> li);
    public String plyPlylist(String string);
}
