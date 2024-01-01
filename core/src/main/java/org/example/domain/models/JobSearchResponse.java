package org.example.domain.models;

import java.util.List;

public class JobSearchResponse {
    List<Hits> results;

    public JobSearchResponse(List<Hits> results) {
        this.results = results;
    }

    public JobSearchResponse() {
    }

    public List<Hits> getResults() {
        return results;
    }

    public void setResults(List<Hits> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "JobSearchResponse{" +
                "results=" + results +
                '}';
    }
}
