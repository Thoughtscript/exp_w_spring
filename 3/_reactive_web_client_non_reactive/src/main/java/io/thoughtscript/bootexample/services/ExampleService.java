package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExampleService {

    private WebClient webClient =  WebClient.create();
    public  ToDo getToDo() {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(ToDo.class)
                .block();
    }
}
