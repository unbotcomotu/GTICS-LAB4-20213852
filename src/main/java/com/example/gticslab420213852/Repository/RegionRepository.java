package com.example.gticslab420213852.Repository;

import com.example.gticslab420213852.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RegionRepository extends JpaRepository<Region, BigDecimal> {
}