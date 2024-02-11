package com.crio.jukebox.repositories;

public interface CRUDRepository<T,ID> {
    boolean existById(ID id);
    
    
}
