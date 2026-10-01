package com.cwm.studentMagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cwm.studentMagement.dto.CourseDTO;
import com.cwm.studentMagement.model.Courses;
import com.cwm.studentMagement.repository.CourseRepository;
import com.cwm.studentMagement.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    
    CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper ) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDTO creaCourseDTO(CourseDTO courseDTO) {
        Courses courses = modelMapper.map(courseDTO, Courses.class);
        courseRepository.save(courses);
        return modelMapper.map(courses, CourseDTO.class);
    }

    @Override 
    public boolean exitsByCode(String code) {
        return courseRepository.
    }

}
