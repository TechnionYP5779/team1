package course.info;

import java.util.*;

import fluent.ly.*;

public class CourseObject {
   public static class ExamDate{
    Integer d;
    Integer m;
    Integer y;
    
    public ExamDate(Integer d,Integer m, Integer y) {
      this.d=d;
      this.m=m;
      this.y = y;
    }

    public Integer getMonth() {
      return m;
    }

    public Integer getYear() {
      return y;
    }

    public Integer getDay() {
      return d;
    }
  }

  private String faculty;
  private String name;
  private Integer id;
  private Integer academicPoints;
  private String lecturerInCharge;
  private Optional<Integer> lectureHours;
  private Optional<Integer> tutorialHours;
  private Optional<Integer> labHours;
  private Optional<Integer> projectHours;
  private Optional<ExamDate> examA;
  private Optional<ExamDate> examB;
  private String semester;
    
  public CourseObject(String f, Integer id, String n, Integer ap, String lecturerIC,
      Optional<Integer> lHours ,Optional<Integer> tHours, Optional<Integer> ph, Optional<Integer> labh, Optional<ExamDate> A, Optional<ExamDate> B, String semester) {
    this.faculty = f;
    this.id = id;
    this.name = n;
    this.academicPoints = ap;
    this.lecturerInCharge = lecturerIC;
    this.lectureHours = lHours;
    this.tutorialHours = tHours;
    this.labHours = labh;
    this.projectHours = ph;
    this.examA = A;
    this.examB = B;
    this.semester = semester;
  }
  

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAcademicPoints() {
    return academicPoints;
  }

  public void setAcademicPoints(Integer academicPoints) {
    this.academicPoints = academicPoints;
  }

  public String getLecturerInCharge() {
    return lecturerInCharge;
  }

  public void setLecturerInCharge(String lecturerInCharge) {
    this.lecturerInCharge = lecturerInCharge;
  }

  public Integer getLectureHours() {
    return handleHoursOptional(lectureHours);
  }

  private static Integer handleHoursOptional(Optional<Integer> h) {
    return !h.isEmpty() ? h.get() : box.it(0);
  }


  public void setLectureHours(Optional<Integer> lectureHours) {
    this.lectureHours = lectureHours;
  }

  public Integer getTutorialHours() {
    return handleHoursOptional(tutorialHours);
  }

  public void setTutorialHours(Optional<Integer> tutorialHours) {
    this.tutorialHours = tutorialHours;
  }

  public Integer getLabHours() {
    return handleHoursOptional(labHours);
  }

  public void setLabHours(Optional<Integer> labHours) {
    this.labHours = labHours;
  }

  public Integer getProjectHours() {
    return handleHoursOptional(projectHours);
  }

  public void setProjectHours(Optional<Integer> projectHours) {
    this.projectHours = projectHours;
  }

  public String getExamA() {
    return OptionalDateToString(examA);
  }

  public void setExamA(Optional<ExamDate> examA) {
    this.examA = examA;
  }
  
  private static String OptionalDateToString(Optional<ExamDate> ¢) {
    return ¢.isEmpty() ? "" : ¢.get().getDay() + "." + ¢.get().getMonth() + "." + ¢.get().getYear();
  }

  public String getExamB() {
    return OptionalDateToString(examB);
  }

  public void setExamB(Optional<ExamDate> examB) {
    this.examB = examB;
  }

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

}