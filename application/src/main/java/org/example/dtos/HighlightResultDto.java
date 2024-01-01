package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HighlightResultDto {
    @JsonProperty("job_functions")
    List<JobFunctionDto> jobFunctionDto;
}

