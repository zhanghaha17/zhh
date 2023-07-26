package com.example.zhh.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource("classpath:test.properties")})
@ConfigurationProperties(prefix = "test")
@Data
public class CustumeValue {
    @Value("${test.k}")
    int a;
}
