package com.cwm.studentMagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cwm.studentMagement.dto.CourseDTO;
import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;


@Controller 
@RequestMapping ("/course")
public class CourseController {
    
    @GetMapping("/new")
 
    public String showCreateCourse() {
        return "add-course";
    }

    @GetMapping("/list")
    public String listCourses() {
        return "courses";
    }

    @PostMapping
    public  String createCourse(@Valid @ModelAttribute("courseDto") CourseDTO courseDTO,
    BindingResult bindingResult,
    Model model,
    RedirectAttributes redirectAttributes
  ) {
      if(bindingResult.hasErrors()){
        return  "add-course";
      }
  
    }
    
}
