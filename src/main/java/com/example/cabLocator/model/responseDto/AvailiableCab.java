package com.example.cabLocator.model.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailiableCab {
    @JsonProperty("name")
    private  String name;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("car_number")
    private String carNumber;
}
