package com.example.springBootLab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springBootLab.model.ResumeModel;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeModel, Integer> {
    List<ResumeModel> findByRole(String role);
}

