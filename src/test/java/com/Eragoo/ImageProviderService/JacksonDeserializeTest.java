package com.Eragoo.ImageProviderService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JacksonDeserializeTest {
    private static ObjectMapper objectMapper;

    @BeforeAll
    static void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void deserializeTestObjectFromJson() {
        JsonTestClass JsonTestClass = initJsonTestClass();
        Assertions.assertEquals("lol", JsonTestClass.getTestField1());
        Assertions.assertEquals("kek", JsonTestClass.getTestField2());
    }

    private JsonTestClass initJsonTestClass() {
        JsonTestClass JsonTestClass = new JsonTestClass();
        try {
            JsonTestClass = objectMapper.readValue(JsonTestDataProvider.JSON_SERIALIZED_TEST_OBJECT, JsonTestClass.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JsonTestClass;
    }
}
