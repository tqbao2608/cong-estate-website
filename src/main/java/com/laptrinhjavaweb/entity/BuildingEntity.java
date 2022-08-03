package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "building")

public class BuildingEntity extends  BaseEntity {
    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "street" )
    private String street;

    @Column(name = "ward" )
    private String ward;

    @Column(name = "district" )
    private String district;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column(name = "floorarea" )
    private Integer floorArea;

    @Column(name = "rentprice" )
    private Integer rentPrice;

    @Column(name = "rentpricedescription" )
    private String rentPriceDescription;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "building")
    private List<RentAreaEntity> rentAreaEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "buildingEntity")
    private List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();

    public List<RentAreaEntity> getRentAreaEntityList() {
        return rentAreaEntityList;
    }

    public void setRentAreaEntityList(List<RentAreaEntity> rentAreaEntityList) {
        this.rentAreaEntityList = rentAreaEntityList;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public List<AssignmentBuildingEntity> getAssignmentBuildingEntities() {
        return assignmentBuildingEntities;
    }

    public void setAssignmentBuildingEntities(List<AssignmentBuildingEntity> assignmentBuildingEntities) {
        this.assignmentBuildingEntities = assignmentBuildingEntities;
    }
}
