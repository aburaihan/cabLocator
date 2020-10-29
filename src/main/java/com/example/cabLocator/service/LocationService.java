package com.example.cabLocator.service;

import com.example.cabLocator.model.domain.Location;
import com.example.cabLocator.model.requestDto.CabLocationRequestDto;
import com.example.cabLocator.model.requestDto.LocationSetRequestDto;
import com.example.cabLocator.model.responseDto.AvailiableCab;

import java.util.List;

public interface LocationService {
    List<AvailiableCab> getNearestCabs(CabLocationRequestDto cabLocationRequestDto);
    Location setCabLocation(LocationSetRequestDto locationSetRequestDto);
}
