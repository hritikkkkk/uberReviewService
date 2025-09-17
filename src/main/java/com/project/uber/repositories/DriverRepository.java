package com.project.uber.repositories;


import com.hritik.entity_service.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findAllByIdIn(List<Long> driverIds);
}
