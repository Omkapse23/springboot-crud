package com.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Student;
import com.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Home page
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> students = service.getAll();
        model.addAttribute("students", students);
        return "index";
    }

    // Save
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students/";   // FIXED
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students/";   // FIXED
    }

    // Edit
   @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    // Update
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students/";
    }
}