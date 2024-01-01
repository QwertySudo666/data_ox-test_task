package org.example.services;

import org.example.business.adapter.JobSearchServiceAdapter;
import org.example.domain.models.Hit;
import org.example.domain.models.Hits;
import org.example.domain.models.JobSearchResponse;
import org.example.dtos.HitDto;
import org.example.dtos.JobFunctionDto;
import org.example.dtos.JobSearchResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

public class JobSearchService implements JobSearchServiceAdapter {

    private String basicJobSearchUrl = "https://jobs.techstars.com/api/search/jobs?networkId=89&hitsPerPage=20&page=0&filters=&query=";
    private final RestTemplate restTemplate;

    public JobSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JobSearchResponse searchJobs(List<String> jobFunctions) {
        JobSearchResponseDto response = restTemplate.getForEntity(URI.create(prepareJobSearchUrl(jobFunctions)), JobSearchResponseDto.class).getBody();
        System.out.println(response);
        List<Hits> hits = response.getResults().stream().map(hitsDto -> new Hits(hitsDto.getHits().stream().map(hitDto -> {
            var jobPageUrl = generateJobPageUrl(hitDto);
            Document jobPageDocument = fetchJobHtmlPage(jobPageUrl);

            var desc = "NOT_FOUND";
//            var laborFunctions = (hitDto.getHighlightResult().getJobFunctionDto() != null) ? String.join(",", hitDto.getHighlightResult().getJobFunctionDto()) : "NOT_FOUND";//extractLaborFunctionFromJobPage(jobPageDocument);
            var laborFunctions = (hitDto.getHighlightResult().getJobFunctionDto() != null) ?
                    hitDto.getHighlightResult().getJobFunctionDto().stream()
                            .map(JobFunctionDto::getValue)
                            .collect(Collectors.joining(",")) :
                    "NOT_FOUND";

            if (hitDto.getHasDescription()) {
                desc = extractJobDescriptionFromJobPage(jobPageDocument);
            }
            return new Hit(
                    hitDto.getTitle(),
                    jobPageUrl,
                    hitDto.getOrganization().getName(),
                    hitDto.getOrganization().getLogoUrl(),
                    laborFunctions,
                    hitDto.getLocations(),
                    hitDto.getDate(),
                    desc,
                    hitDto.getOrganization().getIndustryTags());
        }).toList())).toList();
        return new JobSearchResponse(hits);
    }

    private String prepareJobSearchUrl(List<String> jobFunctions) {
        if (jobFunctions != null) {
            List<String> encodedJobFunctions = jobFunctions.stream()
                    .map(jobFunction -> {
                        try {
                            return URLEncoder.encode(jobFunction, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

            String filters = String.format("(%s)", String.join("%20OR%20", encodedJobFunctions));
            return String.format(
                    "https://jobs.techstars.com/api/search/jobs?networkId=89&hitsPerPage=20&page=0&filters=%s&query=qwer",
                    filters
            );
        }
        return basicJobSearchUrl;
    }

    private String generateJobPageUrl(HitDto hitDto) {
        var url = "https://jobs.techstars.com/companies/" + hitDto.getOrganization().getSlug() + "/jobs/" + hitDto.getSlug() + "#content";
        System.out.println(url);
        return url;
    }

    private Document fetchJobHtmlPage(String jobPageUrl) {
        Document document = null;
        try {
            document = Jsoup.connect(jobPageUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }

    private String extractJobDescriptionFromJobPage(Document jobPageDocument) {
        var description = "NOT_FOUND";

        Element careerPageDiv = jobPageDocument.select("div[data-testid=careerPage]").first();

        if (careerPageDiv != null) {
            String content = careerPageDiv.html();
            System.out.println("CONTENT: " + content);
            description = content;
        } else {
            System.out.println("Element with data-testid='careerPage' not found on the page.");
        }
        return description;
    }


    public JobSearchResponseDto searchJobsDto() {
        return restTemplate.getForEntity(URI.create(basicJobSearchUrl), JobSearchResponseDto.class).getBody();
    }

    public String searchJobsString() {
        return restTemplate.getForEntity(URI.create(basicJobSearchUrl), String.class).getBody();
    }
}
