package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private String name;
    @JsonProperty("logo_url")
    private String logoUrl;
    private String slug;
    @JsonProperty("industry_tags")
    private List<String> industryTags;
}
