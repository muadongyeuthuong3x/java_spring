package com.cwm.studentMagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cwm.studentMagement.dto.CourseDTO;
import com.cwm.studentMagement.service.CourseService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/new")

    public String showCreateCourse(Model model) {
        model.addAttribute("courseDto", new CourseDTO());
        return "add-course";
    }

    @GetMapping("/list")
    public String listCourses() {
        return "courses";
    }

    @PostMapping
    public String createCourse(@Valid @ModelAttribute("courseDto") CourseDTO courseDTO,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add-course";
        }

        if (courseService.exitsByCode(courseDTO.getCourseCode())) {
            bindingResult.rejectValue("courseCode", "Code must be unique");
            return "add-course";
        };
        
        courseService.creaCourseDTO(courseDTO);
        redirectAttributes.addAttribute("message", "Course is created suceess");

        return "redirect:/course/list";
    }

}
