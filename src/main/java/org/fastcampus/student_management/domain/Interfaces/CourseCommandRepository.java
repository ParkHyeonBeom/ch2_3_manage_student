package org.fastcampus.student_management.domain.Interfaces;

import org.fastcampus.student_management.domain.Course;

public interface CourseCommandRepository {
    void save(Course course);
}
