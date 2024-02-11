package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.User;

public interface IUserRepository {
    public void saveUser(User user,String id);
}
