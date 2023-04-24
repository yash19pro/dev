package com.yashpatel.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NumberController {

    @GetMapping("/number")
    public Integer number() {
        return 10;
    }

    @GetMapping("/reactiveNumber")
    public Mono<Integer> reactiveNumber() {
        return Mono.just(108);
    }

    @GetMapping("/numbers")
    public Integer[] numbers() throws InterruptedException {
        Integer[] numbers = new Integer[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = i + 1;
            Thread.sleep(1000);
        }

        return numbers;
    }

    @GetMapping(value = "/reactiveNumbers", produces = { "text/event-stream" })
    public Flux<Integer> reactiveNumbers() {
        return Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fluxSink.complete();
        });
    }
}
