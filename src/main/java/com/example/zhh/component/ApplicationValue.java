package com.example.zhh.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "custume.application")
@Data
public class ApplicationValue {

    String value;
    String text;
    @Value("${custume.application.name}")
    String name;

}
