package com.viettel.wifi.management.client;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseGetResponse<T> extends BaseData<BaseObjectRequest<T>> {
    {
        super.setType(BaseData.BASE_DATA_TYPE_GET_RESPONSE);
    }

    private List<ErrorResponse> errors = new ArrayList<>();
}
