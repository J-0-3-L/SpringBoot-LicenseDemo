package com.joel.manejo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.joel.manejo.models.License;

public interface LicenseRepository extends BaseRepository<License> {
    
    @Query("SELECT DISTINCT l FROM License l JOIN FETCH l.person")
    List<License> findAllWithPerson();
}
