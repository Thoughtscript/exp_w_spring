package io.thoughtscript.example.controllers;


import io.thoughtscript.example.services.ReactiveWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class LanguageReactiveRestController {

    @Autowired
    ReactiveWebService reactiveWebService;


    @GetMapping("/api/get/one")
    public Mono<ResponseEntity> testGetOne() {
        return reactiveWebService.getTodo()
                .flatMap(x -> Mono.just(new ResponseEntity(x, HttpStatus.OK)));

    }
}
