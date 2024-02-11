package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exceptions.PlayListIdNotExistException;
import com.crio.jukebox.exceptions.PlaylistIsEmptyException;
import com.crio.jukebox.exceptions.SongNotAvailableException;
// import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.ISongRepository;

public class PlayListService implements IPlayListService{

    private final IPlayListRepository playListRepository;
    private final ISongRepository songRepository;

    public PlayListService(IPlayListRepository playListRepository,ISongRepository songRepository){
        this.playListRepository=playListRepository;
        this.songRepository=songRepository;
    }
    
    int count=1;
    public String createPlayList(String userId,String playListName,List<String> songId) throws SongNotAvailableException{
        for(String s:songId){
            if(!songRepository.findById(s)){
                throw new SongNotAvailableException("Some Requested Songs Not Available. Please try again.");
            }
        }
        Playlist ply=new Playlist(count+"", userId, playListName, songId);

        playListRepository.savePlayList(count+"",ply);
        count++;
        // return "Playlist ID - "+ply.getId();
        return "Playlist ID - "+ply.getId();
    }
    
    public String deletePlaylist(String id) throws PlayListIdNotExistException{
        
        if(!playListRepository.findById(id)){
            throw new PlayListIdNotExistException("Playlist Not Found");
        }
        return playListRepository.deletePlaylist(id);
    }

    // public void moidfyPlaylist(String uId,String pId,List<String> li){
    //     // Playlist ply=new Playlist()
    // }

    @Override
    public String modAddSong(String uId, String pId, List<String> li) throws PlayListIdNotExistException,SongNotAvailableException{
        // TODO Auto-generated method stub
        
        if(playListRepository.findById(pId)==false){
            throw new PlayListIdNotExistException("Playlist Not Found");
        }else{
            Playlist res;
            for(String x:li){
                if(songRepository.findById(x)==false){
                    throw new SongNotAvailableException("Some Requested Songs Not Available. Please try again.");
                }
            }
            Playlist ply= playListRepository.getPlaylist(pId);
            List<String> liSng= ply.getLiSongs();
            for(String z:li){
                if(!liSng.contains(z)){
                    liSng.add(z);
                }
            }
            String sngs="";
            for(String x:liSng){
                sngs+=" "+x;
            }
            res=new Playlist(ply.getId(), uId, ply.getPlayListName(), liSng); 

            return "Playlist ID - "+res.getId()+"\n"+"Playlist Name - "+res.getPlayListName()+"\n"+"Song IDs -"+sngs;

        }
    }

    @Override
    public String modDltSong(String uId, String pId, List<String> li) throws PlayListIdNotExistException,SongNotAvailableException{

        if(playListRepository.findById(pId)==false){
            throw new PlayListIdNotExistException("Playlist Not Found");
        }else{
            Playlist res;
            Playlist ply= playListRepository.getPlaylist(pId);
            List<String> liSng= ply.getLiSongs();
            for(String z:li){
                if(!liSng.contains(z)){
                    throw new SongNotAvailableException("Some Requested Songs for Deletion are not present in the playlist. Please try again.");
                }else{
                    liSng.remove(z);
                }
            }
            String sngs="";
            for(String x:liSng){
                sngs+=" "+x;
            }
            res=new Playlist(ply.getId(), uId, ply.getPlayListName(), liSng); 

            return "Playlist ID - "+res.getId()+"\n"+"Playlist Name - "+res.getPlayListName()+"\n"+"Song IDs -"+sngs;


        }
    }

    @Override
    public String plyPlylist(String id) throws PlayListIdNotExistException {
        if(playListRepository.findById(id)){
            throw new PlayListIdNotExistException("Playlist Not Found");
        }
        Playlist ply=playListRepository.getPlaylist(id);
        if(ply.getLiSongs().size()==0){
            throw new PlaylistIsEmptyException("Playlist is empty.");
        }
        Song s=songRepository.getById( ply.getLiSongs().get(0));
        String artLst="";
        // for(String x)
        return "Current Song Playing\n"+"Song  - "+s.gettitle() +"\n"+"Album - "+s.getalbum()+"Artists - ";
    }

}
