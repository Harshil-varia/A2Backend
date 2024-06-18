package com.example.springBootLab.service.Implementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springBootLab.model.Qualification;
import com.example.springBootLab.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootLab.model.ResumeModel;
import com.example.springBootLab.repository.ResumeRepository;
import com.example.springBootLab.service.ResumeService;


@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    ResumeRepository resumeRepository;


    @Override
    public String createResume(ResumeModel resume) {
        if (resume == null ) {
            return "Resume creation failed: Input resume is null";
        }
        try {
            int yearsOfExperience = Integer.parseInt(resume.getYearsOfExperience());
            if (yearsOfExperience <= -1) {
                return "Resume creation failed: Invalid years of experience";
            }
        } catch (NumberFormatException e) {
            return "Resume creation failed: Invalid years of experience format";
        }

        if (resume.getId() != 0 && resumeRepository.existsById(resume.getId())) {
            return "Resume creation failed: Resume already exists";
        }
        resumeRepository.save(resume);
        return "Resume created";
    }

    @Override
    public List<ResumeModel> getResumeModels(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        List<ResumeModel> resumes = resumeRepository.findByRole(role);

        // Return empty list if no resumes found
        if (resumes == null || resumes.isEmpty()) {
            return Collections.emptyList();
        }
        return resumes;
    }


    public List<Qualification> getQualificationsByRole(String role) {
        List<ResumeModel> resumes = resumeRepository.findByRole(role);
        return resumes.stream()
                .map(resume -> new Qualification(
                        resume.getFirstName(),
                        resume.getLastName(),
                        resume.getQualifications()))
                .collect(Collectors.toList());
    }


    public List<WorkExperience> getWorkExperienceByRole(String role) {
        List<ResumeModel> resumes = resumeRepository.findByRole(role);
        return resumes.stream()
                .map(resume -> new WorkExperience(
                        resume.getFirstName(),
                        resume.getLastName(),
                        resume.getWorkExperience()))
                .collect(Collectors.toList());
    }


    
}
