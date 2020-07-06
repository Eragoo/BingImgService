package com.Eragoo.ImageProviderService.BingParsing;

import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BingImgParser {
    private BingImageDataJsonMapper jsonMapper;
    private BingParseConstants bingParseConstants;

    public List<BingImageData> getImagesDataByRequestParam(String requestParam) {
        List<String> jsonData = getImagesStringData(requestParam);
        return parseImagesData(jsonData);
    }

    public List<String> getImageUrlsByRequestParam(String requestParam) {
        List<BingImageData> imageData = getImagesDataByRequestParam(requestParam);
        return imageData
                .stream()
                .map(BingImageData::getMurl)
                .collect(Collectors.toList());
    }

    private List<String> getImagesStringData(String requestParam) {
        Document document = getHtmlDocumentByRequestParam(requestParam);
        Elements select = document.select(bingParseConstants.getParseImgTag());
        return getImgElementsMetadata(select);
    }

    private List<String> getImgElementsMetadata(Elements select) {
        return select.eachAttr(bingParseConstants.getImgMetadataAttribute());
    }

    private List<BingImageData> parseImagesData(List<String> jsonDataList) {
        return jsonMapper.map(jsonDataList);
    }

    private Document getHtmlDocumentByRequestParam(String requestParam) {
        String encodedParam = getEncodedString(requestParam);
        try {
            return Jsoup.connect(bingParseConstants.getRequestBaseUrl() + "=" +  encodedParam)
                    .header("cookie", bingParseConstants.getAdultResumeTurnOffCookie())
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getEncodedString(String queryParam)  {
        try {
            return URLEncoder.encode(queryParam, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
