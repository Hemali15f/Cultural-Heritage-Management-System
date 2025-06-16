package com.acc;
public class HeritageSite {
     int siteId;
     String name;
     String location;
     String description;
    public HeritageSite(int siteId, String name, String location, String description) {
        this.siteId = siteId;
        this.name = name;
        this.location = location;
        this.description = description;
    }
    public int getSiteId() {
        return siteId;
    }
    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "HeritageSite [siteId=" + siteId + ", name=" + name + ", location=" + location + ", description=" + description + "]";
    }
}

