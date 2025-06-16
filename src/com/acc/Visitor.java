package com.acc;

public class Visitor {
     int visitorId;
     String name;
     String email;
     String phone;
    public Visitor(int visitorId, String name, String email, String phone) {
        this.visitorId = visitorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public int getVisitorId() {
        return visitorId;
    }
    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Visitor [visitorId=" + visitorId + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }
}
