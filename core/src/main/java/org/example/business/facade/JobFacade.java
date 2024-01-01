package org.example.business.facade;

import org.example.business.adapter.JobRepositoryAdapter;
import org.example.business.adapter.JobSearchServiceAdapter;
import org.example.domain.models.JobSearchResponse;

import java.util.List;

public class JobFacade {
    private final JobRepositoryAdapter jobRepositoryAdapter;
    private final JobSearchServiceAdapter jobSearchServiceAdapter;

    public JobFacade(JobRepositoryAdapter jobRepositoryAdapter, JobSearchServiceAdapter jobSearchServiceAdapter) {
        this.jobRepositoryAdapter = jobRepositoryAdapter;
        this.jobSearchServiceAdapter = jobSearchServiceAdapter;
    }

    public JobSearchResponse searchJobs(List<String> jobFunctions) {
        var jobSearchResponse = jobSearchServiceAdapter.searchJobs(jobFunctions);
        jobRepositoryAdapter.save(jobSearchResponse);
        return jobSearchResponse;
    }
}
