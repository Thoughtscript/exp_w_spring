package io.thoughtscript.example.services;

import io.thoughtscript.example.domain.ToDo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ReactiveWebService {

    private WebClient webClient =  WebClient.create();

    public Mono<ToDo> getTodo() {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(ToDo.class);
    }
}
