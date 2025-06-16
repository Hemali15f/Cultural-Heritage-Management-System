package com.acc;
public class Donation {
     int donationId;
     int visitorId;
     int siteId;
     double amount;

    public Donation(int donationId, int visitorId, int siteId, double amount) {
        this.donationId = donationId;
        this.visitorId = visitorId;
        this.siteId = siteId;
        this.amount = amount;
    }
    public int getDonationId() {
        return donationId;
    }
    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }
    public int getVisitorId() {
        return visitorId;
    }
    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }
    public int getSiteId() {
        return siteId;
    }
    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Donation [donationId=" + donationId + ", visitorId=" + visitorId + ", siteId=" + siteId + ", amount=" + amount + "]";
    }
}
