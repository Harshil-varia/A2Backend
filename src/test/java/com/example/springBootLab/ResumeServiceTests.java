package com.example.springBootLab;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.springBootLab.model.Qualification;
import com.example.springBootLab.model.ResumeModel;
import com.example.springBootLab.model.WorkExperience;
import com.example.springBootLab.repository.ResumeRepository;
import com.example.springBootLab.service.Implementation.ResumeServiceImpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeServiceTests {

    @Mock
    private ResumeRepository mockResumeRepository;

    @InjectMocks
    private ResumeServiceImpl resumeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockResumeRepository);
    }

    @Test
    public void testCreateResume() {
        ResumeModel resume = new ResumeModel("John", "Doe", "john.doe@example.com",
                "Software Engineer", "Bachelor's in Computer Science", "Java, Spring Boot",
                "Increased efficiency by 20%", "Java Programming", "5", "Senior Developer", "john_doe.jpg");
        when(mockResumeRepository.save(any(ResumeModel.class))).thenReturn(resume);
        String result = resumeService.createResume(resume);
        verify(mockResumeRepository, times(1)).save(any(ResumeModel.class));
        assertEquals("Resume created", result);
    }


    @Test
    public void testCreateResumeWithNullInput() {
        String result = resumeService.createResume(null);
        verify(mockResumeRepository, never()).save(any(ResumeModel.class));

        assertEquals("Resume creation failed: Input resume is null", result);
    }

    @Test
    public void testCreateResumeWithNegativeYearsOfExperience() {
        ResumeModel resume = new ResumeModel("John", "Doe", "john.doe@example.com",
                "Software Engineer", "Bachelor's in Computer Science", "Java, Spring Boot",
                "Increased efficiency by 20%", "Java Programming", "-1", "Senior Developer", "john_doe.jpg");

        String result = resumeService.createResume(resume);
        verify(mockResumeRepository, never()).save(any(ResumeModel.class));

        assertEquals("Resume creation failed: Invalid years of experience", result);
    }




    @Test
    public void testGetResume() {
        String role = "Engineer";
        ResumeModel resume1 = new ResumeModel("John", "Doe", "john.doe@example.com",
                role, "Bachelor's in Engineering", "Java, Spring Boot",
                "Improved system performance by 30%", "Engineering Design", "8", "Lead Engineer", "john_doe.jpg");
        ResumeModel resume2 = new ResumeModel("Jane", "Smith", "jane.smith@example.com",
                role, "Master's in Engineering", "Python, Django",
                "Implemented scalable solutions", "Advanced Engineering Principles", "10", "Senior Engineer", "jane_smith.jpg");
        List<ResumeModel> resumes = Arrays.asList(resume1, resume2);

        when(mockResumeRepository.findByRole(role)).thenReturn(resumes);

        List<ResumeModel> result = resumeService.getResumeModels(role);

        verify(mockResumeRepository, times(1)).findByRole(role);

        assertEquals(2, result.size()); // Assuming there are 2 resumes returned
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals("Master's in Engineering", result.get(1).getQualifications());
    }


    @Test
    public void testGetResumeModelsNullRole() {
        // Call service method with null role
        assertThrows(IllegalArgumentException.class, () -> {
            resumeService.getResumeModels(null);
        });
    }

    @Test
    public void testGetResumeModelsEmptyRole() {
        // Prepare test data
        String role = "";

        // Mock repository behavior (if applicable)
        // (No mock behavior setup needed for this test since it's testing edge case)

        // Call service method with empty role
        assertThrows(IllegalArgumentException.class, () -> {
            resumeService.getResumeModels(role);
        });
    }


    @Test
    public void testGetQualificationsByRole() {
        String role = "Engineer";
        ResumeModel resume1 = new ResumeModel("John", "Doe", "john.doe@example.com",
                role, "Bachelor's in Engineering", "Java, Spring Boot",
                "Improved system performance by 30%", "Engineering Design", "8", "Lead Engineer", "john_doe.jpg");
        ResumeModel resume2 = new ResumeModel("Jane", "Smith", "jane.smith@example.com",
                role, "Master's in Engineering", "Python, Django",
                "Implemented scalable solutions", "Advanced Engineering Principles", "10", "Senior Engineer", "jane_smith.jpg");
        List<ResumeModel> resumes = Arrays.asList(resume1, resume2);

        when(mockResumeRepository.findByRole(role)).thenReturn(resumes);

        List<Qualification> qualifications = resumeService.getQualificationsByRole(role);

        verify(mockResumeRepository, times(1)).findByRole(role);

        assertEquals(2, qualifications.size());

        assertEquals("John", qualifications.get(0).getFirstName());
        assertEquals("Doe", qualifications.get(0).getLastName());
        assertEquals("Bachelor's in Engineering", qualifications.get(0).getQualifications());

        assertEquals("Jane", qualifications.get(1).getFirstName());
        assertEquals("Smith", qualifications.get(1).getLastName());
        assertEquals("Master's in Engineering", qualifications.get(1).getQualifications());
    }

    @Test
    public void testGetQualificationsByRoleNoResumesFound() {
        String role = "Doctor";

        when(mockResumeRepository.findByRole(role)).thenReturn(new ArrayList<>());
        List<Qualification> qualifications = resumeService.getQualificationsByRole(role);
        verify(mockResumeRepository, times(1)).findByRole(role);

        assertEquals(0, qualifications.size());
    }


    @Test
    public void testGetWorkExperienceByRole() {
        String role = "Manager";
        ResumeModel resume1 = new ResumeModel("John", "Doe", "john.doe@example.com",
                role, "MBA", "Leadership, Strategy",
                "Led successful product launches", "Business Management", "15", "Senior Manager", "john_doe.jpg");
        ResumeModel resume2 = new ResumeModel("Jane", "Smith", "jane.smith@example.com",
                role, "Business Administration", "Team Management",
                "Developed effective sales strategies", "Operations Management", "12", "Manager", "jane_smith.jpg");
        List<ResumeModel> resumes = Arrays.asList(resume1, resume2);
        when(mockResumeRepository.findByRole(role)).thenReturn(resumes);
        List<WorkExperience> workExperiences = resumeService.getWorkExperienceByRole(role);

        verify(mockResumeRepository, times(1)).findByRole(role);
        assertEquals(2, workExperiences.size());

        assertEquals("John", workExperiences.get(0).getFirstName());
        assertEquals("Doe", workExperiences.get(0).getLastName());
        assertEquals("Senior Manager", workExperiences.get(0).getWorkExperience());

        assertEquals("Jane", workExperiences.get(1).getFirstName());
        assertEquals("Smith", workExperiences.get(1).getLastName());
        assertEquals("Manager", workExperiences.get(1).getWorkExperience());
    }
    






}

