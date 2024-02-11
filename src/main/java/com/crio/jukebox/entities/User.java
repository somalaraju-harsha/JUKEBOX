package com.crio.jukebox.entities;

// import java.util.Map;

public class User extends BaseEntity {

    private final String userName;

    public User(User user){
        this(user.id,user.userName);
    }

    public User(String name){
        this.userName=name;
    }
    public User(String id,String name){
        this.id=id;
        this.userName=name;
    }

    public String getUserName() {
        return userName;
    }
    
}
