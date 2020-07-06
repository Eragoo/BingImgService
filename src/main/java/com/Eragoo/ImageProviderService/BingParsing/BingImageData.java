package com.Eragoo.ImageProviderService.BingParsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BingImageData {
    @JsonProperty("cid")
    private String cid;
    @JsonProperty("purl")
    private String purl;
    @JsonProperty("murl")
    private String murl;
    @JsonProperty("turl")
    private String turl;
    @JsonProperty("md5")
    private String md5;
    @JsonProperty("shkey")
    private String shkey;
    @JsonProperty("t")
    private String t;
    @JsonProperty("mid")
    private String mid;
    @JsonProperty("desc")
    private String desc;
}
