package com.example.demo.entity;

public class TbResource {
    private String title;
    private String resourceUrl;
    private String resourceId;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
