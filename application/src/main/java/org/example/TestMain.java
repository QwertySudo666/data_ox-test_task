package org.example;

import org.example.domain.models.JobSearchResponse;
import org.example.dtos.JobSearchResponseDto;
import org.example.services.JobSearchService;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        JobSearchService jobSearchService = new JobSearchService(new RestTemplate());
        JobSearchResponse jobSearchResponse = jobSearchService.searchJobs(List.of(""));
        JobSearchResponseDto jobSearchResponseDto = jobSearchService.searchJobsDto();
        System.out.println("RESULT----RESULT----RESULT----RESULT----RESULT");
        System.out.println("JobSearchResponse------------------------------------------");
        System.out.println(jobSearchResponse);
        System.out.println("JobSearchResponseDto------------------------------------------");
        System.out.println(jobSearchResponseDto);
        System.out.println("String------------------------------------------");
        System.out.println(jobSearchService.searchJobsString());

    }

    public static void smain(String[] args) {
        var url = "https://api.getro.com/api/v1/jobs/31748273-senior-software-engineer-node-js?collection_id=89";

        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForEntity(URI.create(url), String.class));

    }

    public static void maina(String[] args) {
    }
}
