package com.yashpatel.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.yashpatel.webflux.handlers.NumHandler;
import com.yashpatel.webflux.handlers.SearchHandler;

@Component
public class RouterConfig {

    private final NumHandler numHandler;
    private final SearchHandler searchHandler;

    public RouterConfig(NumHandler numHandler, SearchHandler searchHandler) {
        this.numHandler = numHandler;
        this.searchHandler = searchHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/num"), numHandler::num)
                .andRoute(RequestPredicates.GET("/search"), searchHandler::search);
    }
}
