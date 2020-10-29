package com.example.cabLocator.model.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailiableCabsResponse {
    @JsonProperty("available_cabs")
    private  List<AvailiableCab> availableCabs;
}
