package org.example.adapter;

import org.example.business.adapter.JobRepositoryAdapter;
import org.example.domain.models.JobSearchResponse;
import org.example.entities.JobEntity;
import org.example.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JobRepositoryAdapterImpl implements JobRepositoryAdapter {
    private final JobRepository jobRepository;

    public JobRepositoryAdapterImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public String searchJobs() {
        return jobRepository.findAll().toString();
    }

    @Override
    public void save(JobSearchResponse jobSearchResponse) {
        var jobEntities = jobSearchResponse.getResults().stream().flatMap(hits ->
                hits.getHits().stream().map(hit -> new JobEntity(
                                hit.getTitle(),
                                hit.getUrl(),
                                hit.getOrganizationTitle(),
                                hit.getOrganizationUrl(),
                                hit.getLaborFunction(),
                                hit.getLocation().toString(),
                                hit.getDate(),
                                hit.getDescription(),
                                hit.getTagsNames().toString()
                        )
                )
        ).collect(Collectors.toList());
        jobRepository.saveAll(jobEntities);
    }
}
