package com.yashpatel.webflux.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface NumHandler {
    Mono<ServerResponse> num(ServerRequest serverRequest);
}
