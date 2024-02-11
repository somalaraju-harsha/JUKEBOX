package com.crio.jukebox.exceptions;

public class PlayListIdNotExistException extends RuntimeException{
    public PlayListIdNotExistException(){
        super();
    }
    public PlayListIdNotExistException(String msg){
        super(msg);
    }
    
}
