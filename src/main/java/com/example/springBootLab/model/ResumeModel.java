package com.example.springBootLab.model;


import jakarta.persistence.*;

@Entity
public class ResumeModel {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String qualifications;
    private String techSkills;
    private String businessImpact;
    private String coursesTaught;
    private String yearsOfExperience;
    private String workExperience;

    private String photoName;

    public ResumeModel(String firstName, String lastName, String email, String role, String qualifications, String techSkills, String businessImpact, String coursesTaught, String yearsOfExperience, String workExperience, String photoName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.qualifications = qualifications;
        this.techSkills = techSkills;
        this.businessImpact = businessImpact;
        this.coursesTaught = coursesTaught;
        this.yearsOfExperience = yearsOfExperience;
        this.workExperience = workExperience;
        this.photoName = photoName;
    }

    public ResumeModel(int id, String firstName, String lastName, String email, String role, String qualifications, String techSkills, String businessImpact, String coursesTaught, String yearsOfExperience, String workExperience, String photoName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.qualifications = qualifications;
        this.techSkills = techSkills;
        this.businessImpact = businessImpact;
        this.coursesTaught = coursesTaught;
        this.yearsOfExperience = yearsOfExperience;
        this.workExperience = workExperience;
        this.photoName = photoName;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getTechSkills() {
        return techSkills;
    }

    public void setTechSkills(String techSkills) {
        this.techSkills = techSkills;
    }

    public String getBusinessImpact() {
        return businessImpact;
    }

    public void setBusinessImpact(String businessImpact) {
        this.businessImpact = businessImpact;
    }

    public String getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(String coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public ResumeModel() {
    }



}
