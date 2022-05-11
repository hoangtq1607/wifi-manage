package com.viettel.wifi.management.domain;

import com.viettel.wifi.management.domain.enums.GeneralSettingType;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "general_setting_config")
public class GeneralSettingConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private GeneralSettingType settingType;
}
