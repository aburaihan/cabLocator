package com.example.cabLocator.repository;

import com.example.cabLocator.model.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Double> {
    //List<Location> findNearest(Double longitude,Double latitude);

    @Query("SELECT l FROM Location l WHERE l.longitude BETWEEN :longitude1 AND :longitude2 and l.latitude BETWEEN :latitude1 AND :latitude2")
    List<Location> findNearest(
            @Param("longitude1") Double longitude1,
            @Param("longitude2") Double longitude2,
            @Param("latitude1") Double latitude1,
            @Param("latitude2") Double latitude2);
}
