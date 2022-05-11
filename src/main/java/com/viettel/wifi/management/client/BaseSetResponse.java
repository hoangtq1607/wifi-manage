package com.viettel.wifi.management.client;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseSetResponse<T> extends BaseData<T> {
    {
        super.setType(BaseData.BASE_DATA_TYPE_SET_RESPONSE);
    }

    private List<ErrorResponse> errors = new ArrayList<>();
}
