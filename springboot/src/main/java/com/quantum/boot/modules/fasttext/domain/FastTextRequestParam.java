package com.quantum.boot.modules.fasttext.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by zqq on 18-8-19.
 */
@Setter
@Getter
public class FastTextRequestParam {
    @NotNull(message = "sentence must not be null")
    private String sentence;
    @NotNull(message = "is_seg must not be null")
    private Boolean is_seg; // 是否已经分词
}
