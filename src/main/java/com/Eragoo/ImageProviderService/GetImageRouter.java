package com.Eragoo.ImageProviderService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GetImageRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GetImageHandler getImageHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/getImagesUrl"), getImageHandler::getImages);
    }
}
