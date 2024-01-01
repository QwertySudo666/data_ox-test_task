package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HitDto {
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty
    private String slug;
    @JsonProperty("_highlightResult")
    private HighlightResultDto highlightResult;
    @JsonProperty
    private List<String> locations;
    @JsonProperty("created_at")
    private String date;
    @JsonProperty("has_description")
    private Boolean hasDescription;
    @JsonProperty
    private OrganizationDto organization;
}
