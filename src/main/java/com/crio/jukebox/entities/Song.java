package com.crio.jukebox.entities;

import java.util.*;

public class Song extends BaseEntity {
    private final String title;
    private final String genre;
    private final String album;
    private final String artist;
    private final List<String> featuringArtists;

    public Song(Song song){
        this(song.title,song.genre,song.album,song.artist,song.featuringArtists);
    }

    public Song(String title, String genre, String album, String artist, List<String> featuringArtists) {
        this.title = title;
        this.genre = genre;
        this.album= album;
        this.artist= artist;
        this.featuringArtists=featuringArtists;
    }
    public Song(String id, String title, String genre, String album, String artist, List<String> featuringArtists) {
        this.title = title;
        this.genre = genre;
        this.album= album;
        this.artist= artist;
        this.featuringArtists=featuringArtists;
        this.id=id;
    }

    public String gettitle() {
        return title;
    }

    public String getgenre() {
        return genre;
    }

    public String getalbum() {
        return album;
    }

    public String getartist() {
        return artist;
    }

    public List<String> getFeaturingArtists() {
        return featuringArtists;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", featuringArtists=" + featuringArtists +
                '}';
    }
    
}
