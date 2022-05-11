package com.viettel.wifi.management.controller;

import com.viettel.wifi.management.client.BaseObjectRequest;
import com.viettel.wifi.management.client.ErrorResponse;
import com.viettel.wifi.management.client.wifisetting.GetGeneralSettingResponse;
import com.viettel.wifi.management.domain.GeneralSettingConfigEntity;
import com.viettel.wifi.management.domain.enums.GeneralSettingType;
import com.viettel.wifi.management.repository.GeneralSettingConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wifi-setting")
public class WifiSettingController {

    @Autowired
    private GeneralSettingConfigRepository generalSettingConfigRepository;

    @GetMapping
    public Mono<GetGeneralSettingResponse> test() {
        GetGeneralSettingResponse res = new GetGeneralSettingResponse();
        res.setErrors(List.of(new ErrorResponse()));
        BaseObjectRequest<GetGeneralSettingResponse.ResponseDto> objectBaseObjectRequest = new BaseObjectRequest<>();
        objectBaseObjectRequest.setParam(new GetGeneralSettingResponse.ResponseDto());
        res.setObjects(List.of(objectBaseObjectRequest));
        return Mono.just(res);
    }

    @GetMapping("/common-config")
    public Mono<Object> getCommonConfig() {
        Map<GeneralSettingType, List<String>> commonConfig = generalSettingConfigRepository.findAll()
                .stream().collect(
                        Collectors.groupingBy(GeneralSettingConfigEntity::getSettingType,
                                Collectors.mapping(GeneralSettingConfigEntity::getName, Collectors.toList())));

        return Mono.just(commonConfig);
    }
}
