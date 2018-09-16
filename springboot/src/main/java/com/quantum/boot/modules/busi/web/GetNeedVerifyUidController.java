package com.quantum.boot.modules.busi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zqq on 18-8-19.
 */
@RestController
@RequestMapping(value="/users")
public class GetNeedVerifyUidController {



    @RequestMapping("/need_verify")
    public String index() {
        return "Hello World";
    }
}
