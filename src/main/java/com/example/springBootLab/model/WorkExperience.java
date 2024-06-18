package com.example.springBootLab.model;

public class WorkExperience {
    private String firstName;
    private String lastName;
    private String workExperience;

    public WorkExperience(String firstName, String lastName, String workExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
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

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }
}
