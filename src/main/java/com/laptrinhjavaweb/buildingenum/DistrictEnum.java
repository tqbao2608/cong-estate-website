package com.laptrinhjavaweb.buildingenum;

public enum DistrictEnum {
    QUAN_1 ("Quận 1"),
    QUAN_2 ("Quận 2"),
    QUAN_4 ("Quận 4");


    private final String value;

    public String getValue() {
        return value;
    }

    private DistrictEnum(String value) {
        this.value = value;
    }
}
