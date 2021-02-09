package com.aleksandar.location.repositories;

import com.aleksandar.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    @Query("select type,count(type) from Location group by type")
    public List<Object[]> findTypeAndTypeCount();
}
