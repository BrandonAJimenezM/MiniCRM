package com.crm.test.enums;

public enum Structure {
    ORG("ORG"),
    CORP("CORP"),
    SAS("SAS"),
    INC("INC"),
    CO("CO"),
    LLC("LLC"),
    LTD("LTD");

    private String value;

    Structure(String value) {
        this.value = value;
    }
}
