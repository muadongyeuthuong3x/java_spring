package com.cwm.studentMagement.service;

import com.cwm.studentMagement.dto.CourseDTO;

public interface CourseService {

    CourseDTO creaCourseDTO(CourseDTO courseDTO);

    boolean exitsByCode(String code);
} 