package com.example.springBootLab.controller;

import com.example.springBootLab.model.Qualification;
import com.example.springBootLab.model.ResumeModel;
import com.example.springBootLab.model.WorkExperience;
import com.example.springBootLab.service.ResumeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    ResumeService resumeService;


    @PostMapping("/create")
    public String createResume(@RequestBody ResumeModel resume) {
        return resumeService.createResume(resume);
    }

    @GetMapping("/get/{role}")
    public List<ResumeModel> getResume(@PathVariable String role) {
        return resumeService.getResumeModels(role);
    }

    @GetMapping("/qualification/{role}")
    public List<Qualification> getQualifications(@PathVariable String role) {
        return resumeService.getQualificationsByRole(role);
    }

    @GetMapping("/workExperience/{role}")
    public ResponseEntity<List<WorkExperience>> getWorkExperienceByRole(@PathVariable String role) {
        List<WorkExperience> workExperiences = resumeService.getWorkExperienceByRole(role);
        return ResponseEntity.ok(workExperiences);
    }
    
}
