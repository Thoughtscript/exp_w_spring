package io.thoughtscript.springexps.controllers;

import io.thoughtscript.springexps.dtos.Example;
import io.thoughtscript.springexps.services.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/getOne")
    public ResponseEntity getOneExample() throws InterruptedException {
        Example result = exampleService.getAllExamples();
        return ResponseEntity.ok(result);
    }
}
