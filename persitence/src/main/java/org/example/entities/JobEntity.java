package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
//@Table(catalog = "jobs")
public class JobEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String url;
    private String organizationTitle;
    private String organizationUrl;
    private String laborFunction;
    private String location;
    private String date;
    private String description;
    private String tagsNames;

    public JobEntity() {

    }

    public JobEntity(String title, String url, String organizationTitle, String organizationUrl, String laborFunction, String location, String date, String description, String tagsNames) {
        this.title = title;
        this.url = url;
        this.organizationTitle = organizationTitle;
        this.organizationUrl = organizationUrl;
        this.laborFunction = laborFunction;
        this.location = location;
        this.date = date;
        this.description = description;
        this.tagsNames = tagsNames;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrganizationTitle() {
        return organizationTitle;
    }

    public void setOrganizationTitle(String organizationTitle) {
        this.organizationTitle = organizationTitle;
    }

    public String getOrganizationUrl() {
        return organizationUrl;
    }

    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    public String getLaborFunction() {
        return laborFunction;
    }

    public void setLaborFunction(String laborFunction) {
        this.laborFunction = laborFunction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagsNames() {
        return tagsNames;
    }

    public void setTagsNames(String tagsNames) {
        this.tagsNames = tagsNames;
    }
}
