package io.thoughtscript.bootexample.controllers;

import io.thoughtscript.bootexample.services.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ExampleRestController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/get/one")
    public ResponseEntity test() {
        return ResponseEntity.ok(exampleService.getToDo());
    }
}
