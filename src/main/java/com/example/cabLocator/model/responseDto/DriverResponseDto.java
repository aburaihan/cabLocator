package com.example.cabLocator.model.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DriverResponseDto {
    private Long id;
    @JsonProperty("name")
    private  String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone_number")
    private Long phoneNumber;
    @JsonProperty("license_number")
    private String licenseNumber;
    @JsonProperty("car_number")
    private String carNumber;
}


