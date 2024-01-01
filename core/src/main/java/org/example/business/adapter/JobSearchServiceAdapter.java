package org.example.business.adapter;

import org.example.domain.models.JobSearchResponse;

import java.util.List;

public interface JobSearchServiceAdapter {
    JobSearchResponse searchJobs(List<String> jobFunctions);
}
