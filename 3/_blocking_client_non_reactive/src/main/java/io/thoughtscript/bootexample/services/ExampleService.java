package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExampleService {

    public  ToDo getToDo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/1", ToDo.class).getBody();
    }
}
