package io.thoughtscript.yamldotnotation.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "test.example")
// Values supplied in prefix must be written like so:
// Given: 'fieldName.specificName'
// Write: 'field-name.specific-name'
public class TestConfig {

    private String stringOne;

    private String string2;

    @Value("#{'${test.example.stringList}'.split(',')}")
    private List<String> stringList;

    private int number;

    private Map<String, String> map;

    /*
    Expect these to fail

    @Value("${another.stringA}")
    private String stringA;

    @Value("${another}")
    private String stringD;
    */
}
