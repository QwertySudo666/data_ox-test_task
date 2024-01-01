package org.example.web;

import org.example.business.facade.JobFacade;
import org.example.domain.models.JobSearchResponse;
import org.example.dtos.JobSearchRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/jobs")
public class JobResource {
    private final JobFacade jobFacade;

    public JobResource(JobFacade jobFacade) {
        this.jobFacade = jobFacade;
    }

    @PostMapping
    JobSearchResponse searchJobs(@RequestBody JobSearchRequest jobSearchRequest){
        return jobFacade.searchJobs(jobSearchRequest.getJobFunction());
    }
}
