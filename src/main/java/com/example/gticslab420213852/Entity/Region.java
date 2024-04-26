package com.example.gticslab420213852.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @Column(name = "region_id", nullable = false, precision = 22)
    private BigDecimal id;

    @Column(name = "region_name", length = 25)
    private String regionName;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}