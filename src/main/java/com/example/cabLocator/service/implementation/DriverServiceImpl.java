package com.example.cabLocator.service.implementation;

import com.example.cabLocator.model.domain.Driver;
import com.example.cabLocator.model.requestDto.DriverRequestDto;
import com.example.cabLocator.model.responseDto.AvailiableCab;
import com.example.cabLocator.repository.DriverRepository;
import com.example.cabLocator.service.DriverService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Builder
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Override
    public Driver registerDriver(DriverRequestDto driverRequestDto) {
        Driver driver  = Driver.builder()
                .name(driverRequestDto.getName())
                .email(driverRequestDto.getEmail())
                .licenseNumber(driverRequestDto.getLicenseNumber())
                .phoneNumber(driverRequestDto.getPhoneNumber())
                .carNumber(driverRequestDto.getCarNumber())
                .build();
    return driverRepository.save(driver);
    }

    @Override
    public List<AvailiableCab> getDrivers(List<Long> ids) {
        List<Driver> drivers = driverRepository.findAllById(ids);
        List<AvailiableCab> availableCabs = new ArrayList<>();
        for(Driver driver : drivers){
            AvailiableCab availiableCab = AvailiableCab.builder()
                    .name(driver.getName())
                    .phoneNumber(driver.getPhoneNumber())
                    .carNumber(driver.getCarNumber())
                    .build();
            availableCabs.add(availiableCab);
        }
        log.info("available cabs {}",availableCabs);
        return availableCabs;
    }
}
