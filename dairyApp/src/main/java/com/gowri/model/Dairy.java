package com.gowri.model;
/*
 * @author NaveenWodeyar
 * @date 13-10-2024
 */

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class Dairy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dairyId;

    private String dairyName;

    private String dairyLocation;

    private String dairyType;

    private String dairyCapacity;

    private String dairyManager;

    public Dairy(){}

    public Dairy(Long dairyId, String dairyName, String dairyLocation, String dairyType, String dairyCapacity, String dairyManager) {
        this.dairyId = dairyId;
        this.dairyName = dairyName;
        this.dairyLocation = dairyLocation;
        this.dairyType = dairyType;
        this.dairyCapacity = dairyCapacity;
        this.dairyManager = dairyManager;
    }

    public Long getDairyId() {
        return dairyId;
    }

    public void setDairyId(Long dairyId) {
        this.dairyId = dairyId;
    }

    public String getDairyName() {
        return dairyName;
    }

    public void setDairyName(String dairyName) {
        this.dairyName = dairyName;
    }

    public String getDairyLocation() {
        return dairyLocation;
    }

    public void setDairyLocation(String dairyLocation) {
        this.dairyLocation = dairyLocation;
    }

    public String getDairyType() {
        return dairyType;
    }

    public void setDairyType(String dairyType) {
        this.dairyType = dairyType;
    }

    public String getDairyCapacity() {
        return dairyCapacity;
    }

    public void setDairyCapacity(String dairyCapacity) {
        this.dairyCapacity = dairyCapacity;
    }

    public String getDairyManager() {
        return dairyManager;
    }

    public void setDairyManager(String dairyManager) {
        this.dairyManager = dairyManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dairy dairy = (Dairy) o;
        return Objects.equals(dairyId, dairy.dairyId) && Objects.equals(dairyName, dairy.dairyName) && Objects.equals(dairyLocation, dairy.dairyLocation) && Objects.equals(dairyType, dairy.dairyType) && Objects.equals(dairyCapacity, dairy.dairyCapacity) && Objects.equals(dairyManager, dairy.dairyManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dairyId, dairyName, dairyLocation, dairyType, dairyCapacity, dairyManager);
    }

    @Override
    public String toString() {
        return "Dairy{" +
                "dairyId=" + dairyId +
                ", dairyName='" + dairyName + '\'' +
                ", dairyLocation='" + dairyLocation + '\'' +
                ", dairyType='" + dairyType + '\'' +
                ", dairyCapacity='" + dairyCapacity + '\'' +
                ", dairyManager='" + dairyManager + '\'' +
                '}';
    }
}
