package com.yashpatel.webflux.handlers;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class SearchHandlerImpl implements SearchHandler {

    private static final Random random = new Random();

    @Override
    public Mono<ServerResponse> search(ServerRequest serverRequest) {
        Flux<String> results = Flux.merge(
                searchSupplier("Supplier 1"),
                searchSupplier("Supplier 2"),
                searchSupplier("Supplier 3"),
                searchSupplier("Supplier 4"));

        return ServerResponse.ok().header("Access-Control-Allow-Origin", "*").contentType(MediaType.TEXT_EVENT_STREAM)
                .body(results, String.class);
    }

    private Flux<String> searchSupplier(String supplierName) {
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double rand = 10 + (99 - 10) * random.nextDouble();
            BigDecimal value = BigDecimal.valueOf(rand).setScale(3, BigDecimal.ROUND_HALF_UP);
            results.add(value + " - " + supplierName);
        }
        return Flux.interval(Duration.ofMillis(random.nextInt(3000)))
                .zipWithIterable(results)
                .map(Tuple2::getT2); // we also write it as `res -> res.getT2()`
    }

}
