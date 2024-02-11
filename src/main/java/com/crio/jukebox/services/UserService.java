package com.crio.jukebox.services;

// import java.util.*;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.IUserRepository;

public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository,IPlayListRepository playListRepository){
        this.userRepository=userRepository;
    }
    
    public UserService(IUserRepository userRepository) {
        this.userRepository=userRepository;
    }
    int count=1;
    public String createUser(String name){
        User usr=new User(count+"",name);
        userRepository.saveUser(usr,count+"");
        count++;

        return usr.getId()+" "+usr.getUserName();
    }

    // public User readUser(String name){
    //     User usr=new User(name);
    //     return usr;
    // }
    
}
