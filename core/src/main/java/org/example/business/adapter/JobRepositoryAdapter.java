package org.example.business.adapter;

import org.example.domain.models.JobSearchResponse;

public interface JobRepositoryAdapter {
    String searchJobs();

    void save(JobSearchResponse jobSearchResponse);
}
