package com.crio.jukebox.exceptions;

public class PlaylistIsEmptyException extends RuntimeException {
    public PlaylistIsEmptyException(){
        super();
    }
    public PlaylistIsEmptyException(String msg){
        super(msg);
    }
}
