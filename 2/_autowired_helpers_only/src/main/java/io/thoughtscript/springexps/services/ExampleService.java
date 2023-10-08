package io.thoughtscript.springexps.services;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.helpers.ExampleComponentHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleService {

    @Autowired
    ExampleComponentHelper exampleComponentHelper;

    public Example getAllExamples() throws InterruptedException {
        return exampleComponentHelper.testComponentHelper();
    }


}
