package org.fastcampus.student_management.domain;

public class Course {
  // final 변수는 초기화 이후 값 변경이 불가능하다.
  // private final 변수는 외부에서 접근, 값 변경이 불가능하다.
  private final Student student;
  private final String courseName;
  private CourseFee courseFee;
  private final DayOfWeek dayOfWeek;
  private final Long courseTime;

  public Course(Student student, String courseName, int fee, DayOfWeek dayOfWeek, Long courseTime) {
    if (student == null) {
      throw new IllegalArgumentException("학생은 필수 입력값입니다.");
    }

    this.student = student;
    this.courseName = courseName;
    this.courseFee = new CourseFee(fee);
    this.dayOfWeek = dayOfWeek;
    this.courseTime = courseTime;
  }

  public String getCourseName() {
    return courseName;
  }

  public boolean isSameDay(DayOfWeek dayOfWeek) {
    return this.dayOfWeek.equals(dayOfWeek);
  }

  public boolean isActivateUser() {
    return student.isActivate();
  }

  public String getStudentName() {
    return student.getName();
  }

  public int getFee() {
    return courseFee.getFee();
  }

  public void changeFee(int fee) {
    courseFee.changeFee(fee);
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public Long getCourseTime() {
    return courseTime;
  }
}
