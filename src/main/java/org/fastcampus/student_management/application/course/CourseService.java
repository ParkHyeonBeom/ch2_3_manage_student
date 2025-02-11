package org.fastcampus.student_management.application.course;

import java.util.List;
import java.util.stream.Collectors;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    return courses.stream().map(CourseInfoDto::new).collect(Collectors.toList());
  }

  // 리스트에 담긴 코스들의 가격이 주말인 경우 1.5배를 처리할려면?
  // 서비스 로직에서의 부하를 줄여주고, 효율적으로 처리하기 위해 1급 컬렉션을 사용한다.
  // 1급 컬렉션 CourseList 를 통해, 전체 가격을 1.5배 해주는 서비스 로직을 기존에 존재하던 가격 변경 기능에 쉽게 붙일 수 있었다.
  // 객체지향 설계의 기본 원칙을 잘 지켜낼 수 있는 방법
  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
    List<Course> result = courseRepository.getCourseListByStudent(studentName);

    CourseList courseList = new CourseList(result);

    courseList.changeCoursesFee(fee);
  }
}
