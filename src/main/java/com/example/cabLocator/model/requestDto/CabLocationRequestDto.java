package com.example.cabLocator.model.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CabLocationRequestDto {
    @NotNull(message = "longitude  is mandatory")
    private double longitude;

    @NotNull(message = "latitude  is mandatory")
    private double latitude;
}
