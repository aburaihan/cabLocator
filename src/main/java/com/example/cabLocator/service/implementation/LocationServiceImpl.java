package com.example.cabLocator.service.implementation;

import com.example.cabLocator.util.GeoDistance;
import com.example.cabLocator.model.domain.Location;
import com.example.cabLocator.model.requestDto.CabLocationRequestDto;
import com.example.cabLocator.model.requestDto.LocationSetRequestDto;
import com.example.cabLocator.model.responseDto.AvailiableCab;
import com.example.cabLocator.repository.LocationRepository;
import com.example.cabLocator.service.DriverService;
import com.example.cabLocator.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Autowired
    DriverService driverService;

    @Autowired
    LocationRepository locationRepository;

   // @Value("${cabLocator-config.threshold_distance}") Double thresholdDistance;


    @Override
    public  List<AvailiableCab> getNearestCabs(CabLocationRequestDto cabLocationRequestDto) {
        Double latitude = cabLocationRequestDto.getLatitude();
        Double longitude = cabLocationRequestDto.getLongitude();
        List<Location> cabLocations = locationRepository.findNearest(longitude-1, longitude+1, latitude-1,latitude+1);
        List<Long> availiableCabDrivers = new ArrayList<>();
        for(Location location: cabLocations ){
            Double dist = GeoDistance.distance(latitude, location.getLatitude(), longitude, location.getLongitude());
            if(dist < 4.00000){
                availiableCabDrivers.add(location.getDriverId());
            }
        }
        if(availiableCabDrivers.size() == 0){
            return new ArrayList<>();
        }
        return driverService.getDrivers(availiableCabDrivers);
    }

    @Override
    public Location setCabLocation(LocationSetRequestDto locationSetRequestDto) {
        Location location = Location.builder()
                .driverId(locationSetRequestDto.getDriverId())
                .latitude(locationSetRequestDto.getLatitude())
                .longitude(locationSetRequestDto.getLongitude())
                .build();
        return locationRepository.save(location);
    }
}
