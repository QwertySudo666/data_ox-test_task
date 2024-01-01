package org.example.domain.models;

import java.io.Serializable;
import java.util.List;

public class Hit implements Serializable {
    private String title;
    private String url;
    private String organizationTitle;
    private String organizationUrl;
    private String laborFunction;
    private List<String> location;
    private String date;
    private String description;
    private List<String> tagsNames;

    public Hit() {
    }

    public Hit(String title, String url, String organizationTitle, String organizationUrl, String laborFunction, List<String> location, String date, String description, List<String> tagsNames) {
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

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
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

    public List<String> getTagsNames() {
        return tagsNames;
    }

    public void setTagsNames(List<String> tagsNames) {
        this.tagsNames = tagsNames;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", organizationTitle='" + organizationTitle + '\'' +
                ", organizationUrl='" + organizationUrl + '\'' +
                ", laborFunction='" + laborFunction + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", tagsNames=" + tagsNames +
                '}';
    }
}
