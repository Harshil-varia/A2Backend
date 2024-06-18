package com.example.springBootLab.model;

public class Qualification {
    private String firstName;
    private String lastName;
    private String qualifications;

    public Qualification(String firstName, String lastName, String qualifications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualifications = qualifications;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
