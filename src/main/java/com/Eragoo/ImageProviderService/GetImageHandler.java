package com.Eragoo.ImageProviderService;

import com.Eragoo.ImageProviderService.BingParsing.BingImgParser;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetImageHandler {
    private BingImgParser imageParser;

    public Mono<ServerResponse> getImages(ServerRequest request) {
        String param = getQueryParam(request);
        List<String> imageUrls = imageParser.getImageUrlsByRequestParam(param);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(imageUrls));
    }

    private String getQueryParam(ServerRequest request) {
        Optional<String> query = request.queryParam("query");
        String param = "";
        if (query.isPresent()){
            param = query.get();
        }
        return param;
    }
}
