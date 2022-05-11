package com.viettel.wifi.management.client.wifisetting;

import com.viettel.wifi.management.client.BaseGetResponse;
import com.viettel.wifi.management.client.BaseObjectRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetGeneralSettingResponse extends BaseGetResponse<GetGeneralSettingResponse.ResponseDto> {

    @Data
    public static class ResponseDto {
        private Integer ssidIndex;
        private String ssid;
        private String securityMode;
        private String encryptMode;
        private String presharedKey;
    }

}
