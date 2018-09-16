package com.quantum.boot.modules.fasttext.web;

import com.quantum.boot.modules.fasttext.domain.FastTextRequestParam;
import com.quantum.boot.modules.fasttext.service.FastTextClassifyService;
import com.quantum.boot.util.JiebaSegmenterUtil;
import com.quantum.boot.util.R;
import com.quantum.boot.validator.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zqq on 18-8-19.
 * fastText 分类服务
 */
@Slf4j
@RestController
@RequestMapping(value="/fast_text/v1")
public class FastTextController {

    @Autowired
    private FastTextClassifyService classifyService;

    @RequestMapping(value="/cv/predict", method=RequestMethod.POST)
    public R predict(@RequestBody FastTextRequestParam params) {
        ValidatorUtils.validateRequestParams(params);

        if (!params.getIs_seg()){
            params.setSentence(JiebaSegmenterUtil.segment(params.getSentence()));
        }
        if (log.isDebugEnabled()){
            log.debug("predict sentence:{}", params.getSentence());
        }
        return R.ok(classifyService.predict(params.getSentence())) ;
    }
}
