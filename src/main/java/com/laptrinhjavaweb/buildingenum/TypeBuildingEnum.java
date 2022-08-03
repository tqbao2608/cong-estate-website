package com.laptrinhjavaweb.buildingenum;

public enum TypeBuildingEnum {
    TANG_TRET ("Tầng-trệt"),
    NGUYEN_CAN ("Nguyên-căn"),
    NOI_THAT ("Nội-thất");

    private final String value;

    public String getValue() {
        return value;
    }

    private TypeBuildingEnum(String value) {
        this.value = value;
    }
}
