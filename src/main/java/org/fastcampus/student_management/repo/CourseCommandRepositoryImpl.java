package org.fastcampus.student_management.repo;

import java.util.HashMap;
import java.util.Map;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.Interfaces.CourseCommandRepository;

public class CourseCommandRepositoryImpl implements CourseCommandRepository {
  private final Map<String, Course> courseMap = new HashMap<>();

  @Override
  public void save(Course course) {
    courseMap.put(course.getCourseName(), course);
  }
}