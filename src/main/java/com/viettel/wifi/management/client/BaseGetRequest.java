package com.viettel.wifi.management.client;

public class BaseGetRequest<T> extends BaseData<BaseObjectRequest<T>> {
    {
        super.setType(BaseData.BASE_DATA_TYPE_GET_RESPONSE);
    }
}
