package com.example.cabLocator.controller;

import com.example.cabLocator.model.domain.Driver;
import com.example.cabLocator.model.requestDto.CabLocationRequestDto;
import com.example.cabLocator.model.requestDto.DriverRequestDto;
import com.example.cabLocator.model.responseDto.AvailiableCab;
import com.example.cabLocator.model.responseDto.AvailiableCabsResponse;
import com.example.cabLocator.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    @Autowired
    LocationService locationService;

    @PostMapping(value = "/available_cabs",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity registerDriver(@RequestBody @Valid CabLocationRequestDto cabLocationRequestDto,Error error) {

        List<AvailiableCab> availiableCabList = locationService.getNearestCabs(cabLocationRequestDto);
        if(availiableCabList.size() == 0) {
            HashMap<String,String> response = new HashMap<>();
            response.put("message", "No cabs available!");
            return ResponseEntity.status(200).body(response);
        }
        return ResponseEntity.status(200).body(new AvailiableCabsResponse(availiableCabList));
    }

}
