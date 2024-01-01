package org.example.domain.models;

import java.util.List;

public class Hits {
    List<Hit> hits;

    public Hits(List<Hit> hits) {
        this.hits = hits;
    }

    public Hits() {
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Hits{" +
                "hits=" + hits +
                '}';
    }
}
