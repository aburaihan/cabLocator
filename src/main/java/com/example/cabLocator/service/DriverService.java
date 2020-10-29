package com.example.cabLocator.service;

import com.example.cabLocator.model.domain.Driver;
import com.example.cabLocator.model.requestDto.DriverRequestDto;
import com.example.cabLocator.model.responseDto.AvailiableCab;

import java.util.List;

public interface DriverService {
    Driver registerDriver(DriverRequestDto driverRequestDto);
    List<AvailiableCab> getDrivers(List<Long> ids);
}
