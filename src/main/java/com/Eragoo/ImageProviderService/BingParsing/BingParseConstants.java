package com.Eragoo.ImageProviderService.BingParsing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("application")
@Getter
@Setter
@Component
@NoArgsConstructor
public class BingParseConstants {
    @Value("${bing-parse-base-url}")
    private String requestBaseUrl;
    @Value("${bing-parse-img-metadata-attribute}")
    private String imgMetadataAttribute;
    @Value("${bing-parse-img-tag}")
    private String parseImgTag;
    @Value("${adult-resume-turn-off-cookie}")
    private String adultResumeTurnOffCookie;
}
