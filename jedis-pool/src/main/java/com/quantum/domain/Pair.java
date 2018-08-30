package com.quantum.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zqq on 18-8-31.
 */
@Setter
@Getter
@Builder
public class Pair {
    private String key;
    private String value;
}
