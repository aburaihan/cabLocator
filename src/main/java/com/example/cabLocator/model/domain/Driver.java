package com.example.cabLocator.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drivers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel {


    private String name;

    @Column(unique=true)
    private String email;


    @Column(unique=true)
    private String phoneNumber;

    @Column(unique=true)
    private String licenseNumber;

    @Column(unique=true)
    private String carNumber;

}
