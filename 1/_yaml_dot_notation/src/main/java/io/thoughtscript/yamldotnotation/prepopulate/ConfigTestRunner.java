package io.thoughtscript.yamldotnotation.prepopulate;

import io.thoughtscript.yamldotnotation.config.TestConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ConfigTestRunner {

    @Value("${test.example.another.stringB}")
    private String stringB;

    /*
    @Value("${test.example.another}")
    private String stringC;
     */

    @Autowired
    TestConfig testConfig;

    @PostConstruct
    private void checkConfig() {
        log.info(testConfig.getStringOne());
        log.info(testConfig.getString2());
        log.info(testConfig.getStringList().toString());
        log.info(String.valueOf(testConfig.getNumber()));
        log.info(testConfig.getMap().toString());
        log.info(stringB);
        log.info(testConfig.getYamlString());

        /*
        log.info(stringC);
        log.info(testConfig.getStringA());
        log.info(testConfig.getStringD());
         */
    }
}
