package com.example.cabLocator.model.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationSetRequestDto {
    private Long driverId;


    @NotNull(message = "longitude  is mandatory")
    private Double longitude;

    @NotNull(message = "latitude  is mandatory")
    private Double latitude;
}
