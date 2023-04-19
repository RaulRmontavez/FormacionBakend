package com.raul.block6pathvariableheaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "";
    private final AtomicLong counter = new AtomicLong();


    @PostMapping("/greetingPost")
    public Greeting greetingPost(@RequestBody Greeting greeting) {
        return greeting;
    }
    @GetMapping("/greetingGet/{name}")
    public Greeting greetingGet(@PathVariable(value = "name")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(name, template));
    }
    @PutMapping("/greetingPut")
    public Map<String,String> handlePutRequest(@RequestParam Map<String, String> Parametros) {

        Map<String, String> map = new HashMap<>();

        for (String NombreParametro : Parametros.keySet()) {;
            map.put(NombreParametro, Parametros.get(NombreParametro));
        }

        return map;
    }
}
