package com.Eragoo.ImageProviderService.BingParsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BingImageDataJsonMapper {
    ObjectMapper objectMapper;

    public List<BingImageData> map(List<String> jsonObjects) {
        return jsonObjects.stream()
                .map(this::getBingImageDataObject)
                .collect(Collectors.toList());
    }

    private BingImageData getBingImageDataObject(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, BingImageData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Json processing exception", e);
        }
    }
}
