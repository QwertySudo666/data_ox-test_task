package org.example.dtos;

import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobSearchResponseDto {
    List<HitsDto> results;
//
//    public JobSearchResponseDto(List<HitsDto> results) {
//        this.results = results;
//    }
//
//    public JobSearchResponseDto() {
//    }
//
//    public List<HitsDto> getResults() {
//        return results;
//    }
//
//    public void setResults(List<HitsDto> results) {
//        this.results = results;
//    }
//
//
}
