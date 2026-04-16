package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student save(Student s) {
        return repo.save(s);   //  used for BOTH insert & update
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Student getById(Long id) {   //  ADD THIS
        return repo.findById(id).orElse(null);
    }
}