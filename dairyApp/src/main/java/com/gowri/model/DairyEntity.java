package com.gowri.model;
import jakarta.persistence.*;
import java.util.Objects;

/*
 * @author NaveenWodeyar
 * @date 13-10-2024
 */

@Entity
@Table(name = "Dairy_Table")
public class DairyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dairyId;

    private String dairyName;

    private String dairyLocation;

    private String dairyType;

    private String dairyCapacity;

    private String dairyManager;

    public DairyEntity(){}

    public DairyEntity(Long dairyId, String dairyName, String dairyLocation, String dairyType, String dairyCapacity, String dairyManager) {
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
        DairyEntity dairyEntity = (DairyEntity) o;
        return Objects.equals(dairyId, dairyEntity.dairyId) && Objects.equals(dairyName, dairyEntity.dairyName) && Objects.equals(dairyLocation, dairyEntity.dairyLocation) && Objects.equals(dairyType, dairyEntity.dairyType) && Objects.equals(dairyCapacity, dairyEntity.dairyCapacity) && Objects.equals(dairyManager, dairyEntity.dairyManager);
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
