package com.example.cabLocator.controller;

import com.example.cabLocator.model.domain.Driver;
import com.example.cabLocator.model.domain.Location;
import com.example.cabLocator.model.requestDto.DriverRequestDto;
import com.example.cabLocator.model.requestDto.LocationSetRequestDto;
import com.example.cabLocator.model.responseDto.CommonSuccessResponse;
import com.example.cabLocator.service.DriverService;
import com.example.cabLocator.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    LocationService locationService;

    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registerDriver(@RequestBody @Valid DriverRequestDto driverRequestDto) {
        Driver driver = driverService.registerDriver(driverRequestDto);
        return ResponseEntity.status(201).body(driver);
    }

    @PostMapping(value = "/{id}/sendLocation",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity sendLocation(@RequestBody @Valid  LocationSetRequestDto locationSetRequestDto,@PathVariable("id") Long driverId) {
       locationSetRequestDto.setDriverId(driverId);;
        Location location = locationService.setCabLocation(locationSetRequestDto);
        return ResponseEntity.status(202).body(new CommonSuccessResponse("success"));
    }
}
