package com.quantum.boot.modules.fasttext.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FastTextConfig {

    @Bean
    public FastTextProperties fastTextProperties() {
        return new FastTextProperties();
    }
}
