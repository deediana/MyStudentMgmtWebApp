package edu.miu.cs.cs425.mystudentmgmtwebapp.controller;


import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Student;
import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmtwebapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.Flow;

@Controller
@RequestMapping(value = {"/student", "/e-registrar/student"})
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listStudents() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("studentsCount", ((List)students).size());
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student(null, null, null,null,new Transcript()));
        return "secured/student/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Flow.Student student,
                                       BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/e-registrar/student/list";
    }

    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/e-registrar/student/list";
    }

    @PostMapping(value = {"/update"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        StudentService.saveStudent(student);
        return "redirect:/e-registrar/student/list";
    }

    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/e-registrar/student/list";
    }
}