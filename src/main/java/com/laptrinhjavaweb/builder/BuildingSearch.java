package com.laptrinhjavaweb.builder;


import java.util.ArrayList;
import java.util.List;

public class BuildingSearch {
    private String name;
    private String district;
    private Integer floorArea;
    private String ward;
    private String street;
    private Integer numberOfBasement;
    private String direction;
    private String level;
    private Integer areaFrom;
    private Integer areaTo;
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private String managerName;
    private String managerPhone;
    private Long staffId;
    private List<String> typesList = new ArrayList<>();

    private  BuildingSearch(BuildingSearchBuilder buildingSearchBuilder){
        this.name = buildingSearchBuilder.name;
        this.district = buildingSearchBuilder.district;
        this.floorArea = buildingSearchBuilder.floorArea;
        this.ward = buildingSearchBuilder.ward;
        this.street = buildingSearchBuilder.street;
        this.numberOfBasement = buildingSearchBuilder.numberOfBasement;
        this.direction = buildingSearchBuilder.direction;
        this.level = buildingSearchBuilder.level;
        this.areaFrom = buildingSearchBuilder.areaFrom;
        this.areaTo = buildingSearchBuilder.areaTo;
        this.rentPriceFrom = buildingSearchBuilder.rentPriceFrom;
        this.rentPriceTo = buildingSearchBuilder.rentPriceTo;
        this.managerName = buildingSearchBuilder.managerName;
        this.managerPhone = buildingSearchBuilder.managerPhone;
        this.staffId = buildingSearchBuilder.staffId;
        this.typesList = buildingSearchBuilder.typesList;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public Long getStaffId() {
        return staffId;
    }

    public List<String> getTypesList() {
        return typesList;
    }

    public static class BuildingSearchBuilder{
        private String name;
        private String district;
        private Integer floorArea;
        private String ward;
        private String street;
        private Integer numberOfBasement;
        private String direction;
        private String level;
        private Integer areaFrom;
        private Integer areaTo;
        private Integer rentPriceFrom;
        private Integer rentPriceTo;
        private String managerName;
        private String managerPhone;
        private Long staffId;
        private List<String> typesList = new ArrayList<>();

        public BuildingSearchBuilder name(String name){
            this.name = name;
            return this;
        }
        public BuildingSearchBuilder district(String district){
            this.district = district;
            return this;
        }
        public BuildingSearchBuilder floorArea(Integer floorArea){
            this.floorArea = floorArea;
            return this;
        }
        public BuildingSearchBuilder ward(String ward){
            this.ward = ward;
            return this;
        }
        public BuildingSearchBuilder street(String street){
            this.street = street;
            return this;
        }
        public BuildingSearchBuilder numberOfBasement(Integer numberOfBasement){
            this.numberOfBasement = numberOfBasement;
            return this;
        }
        public BuildingSearchBuilder direction(String direction){
            this.direction = direction;
            return this;
        }
        public BuildingSearchBuilder level(String level){
            this.level = level;
            return this;
        }
        public BuildingSearchBuilder areaFrom(Integer areaFrom){
            this.areaFrom = areaFrom;
            return this;
        }
        public BuildingSearchBuilder areaTo(Integer areaTo){
            this.areaTo = areaTo;
            return this;
        }
        public BuildingSearchBuilder rentPriceFrom(Integer rentPriceFrom){
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }
        public BuildingSearchBuilder rentPriceTo(Integer rentPriceTo){
            this.rentPriceTo = rentPriceTo;
            return this;
        }
        public BuildingSearchBuilder managerName(String managerName){
            this.managerName = managerName;
            return this;
        }
        public BuildingSearchBuilder managerPhone(String managerPhone){
            this.managerPhone = managerPhone;
            return this;
        }
        public BuildingSearchBuilder staffId(Long staffId){
            this.staffId = staffId;
            return this;
        }
        public BuildingSearchBuilder typesList(List<String> typesList){
            this.typesList = typesList;
            return this;
        }


        public BuildingSearch build(){
            BuildingSearch buildingSearch =  new BuildingSearch(this);
            validateBuildingSearchObject(buildingSearch);
            return buildingSearch;
        }

        private void validateBuildingSearchObject(BuildingSearch buildingSearch) {
        }

    }

}
