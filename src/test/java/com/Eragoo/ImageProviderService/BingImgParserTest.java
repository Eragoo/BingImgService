package com.Eragoo.ImageProviderService;

import com.Eragoo.ImageProviderService.BingParsing.BingImageDataJsonMapper;
import com.Eragoo.ImageProviderService.BingParsing.BingImgParser;
import com.Eragoo.ImageProviderService.BingParsing.BingParseConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BingImgParserTest {
    private static BingImgParser imgParser;

    @BeforeAll
    public static void init() {
        BingImageDataJsonMapper mapper = new BingImageDataJsonMapper(new ObjectMapper());
        BingParseConstants parseConstants = initBingParseConstants();
        imgParser = new BingImgParser(mapper, parseConstants);
    }

    @Test
    public void returnsNotEmptyImgUrlsForDogParam() {
        List<String> imgUrls = imgParser.getImageUrlsByRequestParam("dog");
        Assertions.assertFalse(imgUrls.isEmpty());
    }

    @Test
    public void returnsNotEmptyImgUrlsForParamWithSpacing() {
        List<String> imgUrls = imgParser.getImageUrlsByRequestParam("cute    dog");
        Assertions.assertFalse(imgUrls.isEmpty());
    }

    @Test
    public void returnsImgUrlsInJpegFormat() {
        List<String> imgUrls = imgParser.getImageUrlsByRequestParam("cute    dog");
        imgUrls.forEach(url -> Assertions.assertTrue(url.contains(".jpg")));
    }

    private static BingParseConstants initBingParseConstants() {
        BingParseConstants parseConstants = new BingParseConstants();
        parseConstants.setRequestBaseUrl(ParserTestDataProvider.REQUEST_BASE_URL);
        parseConstants.setImgMetadataAttribute(ParserTestDataProvider.IMG_METADATA_ATTRIBUTE);
        parseConstants.setParseImgTag(ParserTestDataProvider.PARSE_IMG_TAG);
        return parseConstants;
    }
}
