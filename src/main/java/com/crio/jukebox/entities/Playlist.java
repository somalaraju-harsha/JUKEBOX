package com.crio.jukebox.entities;

import java.util.List;

public class Playlist extends BaseEntity {
    private final String userId;
    private final String playListName;
    private final List<String> liSongs;

    public Playlist(Playlist playList){
        this(playList.id,playList.userId,playList.playListName,playList.liSongs);
    }
    public Playlist(String id, String userId, String playListName, List<String> liSongs) {
        this.id=id;
        this.userId=userId;
        this.playListName=playListName;
        this.liSongs=liSongs;
    }
    public String getUserId() {
        return userId;
    }
    public String getPlayListName() {
        return playListName;
    }
    public List<String> getLiSongs() {
        return liSongs;
    }

}
