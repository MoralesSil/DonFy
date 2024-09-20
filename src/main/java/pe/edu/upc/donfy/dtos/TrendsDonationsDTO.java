package pe.edu.upc.donfy.dtos;

import java.time.LocalDate;

public class TrendsDonationsDTO {
    private String donationType;
    private LocalDate date;
    private int totalDonations;

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalDonations() {
        return totalDonations;
    }

    public void setTotalDonations(int totalDonations) {
        this.totalDonations = totalDonations;
    }
}
