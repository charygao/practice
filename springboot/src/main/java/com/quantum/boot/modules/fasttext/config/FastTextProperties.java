package com.quantum.boot.modules.fasttext.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zqq on 18-8-19.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "fast-text", ignoreUnknownFields = false)
public class FastTextProperties {
    private String modelPath = "/opt/app/fasttext/geek-mmap-model-v2.bin";
}
