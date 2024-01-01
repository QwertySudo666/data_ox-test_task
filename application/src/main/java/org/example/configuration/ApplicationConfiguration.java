package org.example.configuration;

import org.example.business.adapter.JobRepositoryAdapter;
import org.example.business.adapter.JobSearchServiceAdapter;
import org.example.business.facade.JobFacade;
import org.example.services.JobSearchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    JobSearchService jobSearchService(RestTemplate restTemplate) {
        return new JobSearchService(restTemplate);
    }

    @Bean
    JobFacade jobFacade(JobRepositoryAdapter jobRepositoryAdapter, JobSearchServiceAdapter jobSearchServiceAdapter) {
        return new JobFacade(jobRepositoryAdapter, jobSearchServiceAdapter);
    }
}
