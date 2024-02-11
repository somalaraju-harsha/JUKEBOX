package com.crio.jukebox.repositories;

import java.util.*;
import com.crio.jukebox.entities.User;

public class UserRepository implements IUserRepository {
    private final Map<String,User> userMap;
    private Integer countId=0;

    public UserRepository(){
        userMap=new HashMap<>();
    }
    public UserRepository(Map<String,User> userMap){
        this.userMap=userMap;
        this.countId=userMap.size();
    }

    public void saveUser(User user,String id){
        userMap.put(id,user);
    }

    // public void getUser()
    
}
