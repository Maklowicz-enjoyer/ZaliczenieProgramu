package org.example;


import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private String patentNumber;
    private List<ShootingResult> results = new ArrayList<>();

    public Participant(String firstName, String lastName, String licenseNumber, String patentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.patentNumber = patentNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }

    public void setResults(List<ShootingResult> results) {
        this.results = results;
    }

    public void addResult(ShootingResult result) {
        results.add(result);
    }

    public List<ShootingResult> getResults() {
        return results;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName)
                .append(", licencja: ").append(licenseNumber)
                .append(", patent: ").append(patentNumber).append("\n");
        for (DisciplineType d : DisciplineType.values()) {
            ShootingResult r = results.stream()
                    .filter(res -> res.getType() == d)
                    .findFirst()
                    .orElse(null);
            if (r != null) {
                sb.append(" - ").append(r.getSummary()).append("\n");
            } else {
                sb.append(" - ").append(d).append(": niezapisany\n");
            }
        }
        return sb.toString();
    }
}
