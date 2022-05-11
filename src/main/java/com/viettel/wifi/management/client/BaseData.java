package com.viettel.wifi.management.client;

import lombok.Data;

import java.util.List;

@Data
public class BaseData<T> {
    protected static final String BASE_DATA_TYPE_SET = "set";
    protected static final String BASE_DATA_TYPE_SET_RESPONSE = "set_response";
    protected static final String BASE_DATA_TYPE_GET = "get";
    protected static final String BASE_DATA_TYPE_GET_RESPONSE = "get_response";
    private Integer id;
    private String from;
    private String to;
    private String type;
    private List<T> objects;

    protected void setType(String type) {
        this.type = type;
    }
}
