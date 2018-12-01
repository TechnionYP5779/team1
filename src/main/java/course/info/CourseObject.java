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
  private String id;
  private Integer academicPoints;
  private Optional<Integer> lectureHours = Optional.empty();
  private Optional<Integer> tutorialHours = Optional.empty();
  private Optional<Integer> labHours = Optional.empty();
  private Optional<Integer> projectHours = Optional.empty();
  private Optional<ExamDate> examA= Optional.empty();
  private Optional<ExamDate> examB = Optional.empty();
  private Optional<String> preqisute = Optional.empty();
  private Optional<String> linked = Optional.empty();
  
  public CourseObject() {
    name  = id ="N\\A";
    academicPoints = box.it(0);
  }
  
  public CourseObject(String f, String id, String n, Integer ap,
      Optional<Integer> lHours ,Optional<Integer> tHours, Optional<Integer> ph, Optional<Integer> labh, Optional<ExamDate> A, Optional<ExamDate> B) {
    this.faculty = f;
    this.id = id;
    this.name = n;
    idToFaculty();
    this.academicPoints = ap;
    this.lectureHours = lHours;
    this.tutorialHours = tHours;
    this.labHours = labh;
    this.projectHours = ph;
    this.examA = A;
    this.examB = B;
  }
  
  private void idToFaculty() {
    switch(this.id.substring(0, 2)) {
      case "01":
        this.faculty="Civil and Environmental Engineering";
        break;
      case "03":
        this.faculty="Mechanical Engineering";
        break;
      case "04":
        this.faculty="Electrical Engineering";
        break;
      case "05":
        this.faculty="Chemical Engineering";
        break;
      case "06":
        this.faculty="Biotechnology and Food Engineering";
        break;
      case "08":
        this.faculty="Aerospace Engineering";
        break;
      case "09":
        this.faculty = "Industrial Engineering";
        break;
      case "10":
        this.faculty = "Mathematics";
        break;
      case "11":
        this.faculty = "Physics";
        break;
      case "12":
        this.faculty = "Chemestry";
        break;
      case "13":
        this.faculty = "Biology";
        break;
      case "20":
        this.faculty = "Arcihetechture";
        break;
      case "21":
        this.faculty = "Education in Science and Technology";
        break;
      case "23":
        this.faculty = "Computer Science";
        break;
      case "27":
        this.faculty = "Medicine";
        break;
      case "31":
        this.faculty = "Materials Science and Engineering";
        break;
      case "32":
        this.faculty = "Humanities and Arts";
        break;
      case "33":
        this.faculty = "Bio-Medicine";
        break;
      case "19":
        this.faculty = "Applicable Math";
        break;
      case "82":
        this.faculty = "Bio-Technology";
        break;
      case "64":
        this.faculty = "Nano-Science";
        break;
      default:
        this.faculty="N\\A";
        break;
    }
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
    this.idToFaculty();
  }

  public Integer getAcademicPoints() {
    return academicPoints;
  }

  public void setAcademicPoints(Integer academicPoints) {
    this.academicPoints = academicPoints;
  }

  public Integer getLectureHours() {
    return handleHoursOptional(lectureHours);
  }

  private static Integer handleHoursOptional(Optional<Integer> h) {
    return h.isPresent() ? h.get() : box.it(0);
  }
  

  public void setPreqisute(Optional<String> preqisute) {
    this.preqisute = preqisute;
  }

  public String getPreqisute() {
    return handleStringOptional(preqisute);
  }


  private static String handleStringOptional(Optional<String> preqisute2) {
    return !preqisute2.isPresent() ? "" : preqisute2.get();
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
    return !¢.isPresent()? "" : ¢.get().getDay() + "." + ¢.get().getMonth() + "." + ¢.get().getYear();
  }

  public String getExamB() {
    return OptionalDateToString(examB);
  }

  public void setExamB(Optional<ExamDate> examB) {
    this.examB = examB;
  }

  public String getLinked() {
    return handleStringOptional(linked);
  }

  public void setLinked(Optional<String> linked) {
    this.linked = linked;
  }

}