package com.viettel.wifi.management.client;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseObjectRequest<T> {
    public static final String OBJECT_NAME_WIFI_GENERAL = "wifi";
    public static final String OBJECT_NAME_AP = "ap";
    public static final String OBJECT_NAME_WIFI_24 = "wifi24";
    public static final String OBJECT_NAME_WIFI_5 = "wifi5";
    private String name;
    private Integer instance;
    private T param;
}
