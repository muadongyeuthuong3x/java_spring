package com.cwm.studentMagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cwm.studentMagement.model.Courses;

public interface CourseRepository extends  JpaRepository<Courses ,Long> {
    
}
