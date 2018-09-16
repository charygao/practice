package com.quantum.boot.modules.fasttext.service;

import com.quantum.boot.modules.fasttext.config.FastTextProperties;
import fasttext.FastText;
import fasttext.FastTextPrediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zqq on 18-8-19.
 */
@Slf4j
@Service
public class FastTextClassifyService {

    private FastText model = null;

    @Autowired
    private FastTextProperties properties;

    @PostConstruct
    private void loadModel() {
        try {
            model = FastText.loadModel( properties.getModelPath() );
        } catch (IOException e) {
            log.error("load fast_text model error:{}", e);
        }
    }


    public Map<String,Object> predict(String sentence){
        FastTextPrediction prob = model.predict(sentence);
        Map<String,Object> r = new HashMap<>();
        r.put("label", prob.label());
        r.put("probability", prob.probability());
        return r;
    }

    @PreDestroy
    private void closeModel(){
        log.info("close model ...");
        // Closing is only mandatory for memory-mapped models
        if (model != null) {
            try {
                model.close();
            } catch (IOException e) {
                log.error("Error while closing fastText model");
            }
        }
    }
}
