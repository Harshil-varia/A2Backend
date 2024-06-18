package com.example.springBootLab.service;
import java.util.List;

import com.example.springBootLab.model.Qualification;
import com.example.springBootLab.model.ResumeModel;
import com.example.springBootLab.model.WorkExperience;

public interface ResumeService {


    public String createResume(ResumeModel resume);

    List<ResumeModel> getResumeModels(String role);

    List<Qualification> getQualificationsByRole(String role);

    List<WorkExperience> getWorkExperienceByRole(String role);


}
