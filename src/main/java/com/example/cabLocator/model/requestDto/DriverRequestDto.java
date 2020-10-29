package com.example.cabLocator.model.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverRequestDto {
    @NotBlank(message = "name is mandatory")
    @JsonProperty("name")
    private  String name;

    @NotBlank(message = "email is mandatory")
    @JsonProperty("email")
    private String email;

    @Size(max = 10,min =10,message = "enter 10 digit number")
    @NotBlank(message = "phone number is mandatory")
    @Pattern(regexp="^[0-9]*$")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "license_number  is mandatory")
    @JsonProperty("license_number")
    private String licenseNumber;

    @NotBlank(message = "car number  is mandatory")
    @JsonProperty("car_number")
    private String carNumber;
}


