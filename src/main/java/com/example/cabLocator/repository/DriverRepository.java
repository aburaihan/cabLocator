package com.example.cabLocator.repository;

import com.example.cabLocator.model.domain.Driver;
import com.example.cabLocator.model.responseDto.DriverResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findById(Long Id);
    List<Driver> findAllById(Iterable<Long> ids);
}
