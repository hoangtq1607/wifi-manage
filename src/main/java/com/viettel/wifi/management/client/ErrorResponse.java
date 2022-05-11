package com.viettel.wifi.management.client;

import lombok.Data;

@Data
public class ErrorResponse {
    private String objectName;
    private String param;
    private String cause;
    private String hint;
}
