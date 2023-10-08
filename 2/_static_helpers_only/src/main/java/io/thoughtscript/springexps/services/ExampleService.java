package io.thoughtscript.springexps.services;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.helpers.ExampleStaticHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleService {

    public Example getAllExamples() throws InterruptedException {
        return ExampleStaticHelper.testStaticHelper();
    }

}
