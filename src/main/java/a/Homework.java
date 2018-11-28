package a;

import java.util.*;

public class Homework {
  private final String courseNum;
  private final String courseName;
  private final Date dueDate;

  public Homework(String courseNum, String courseName, Date dueDate) {
    this.courseNum = courseNum;
    this.courseName = courseName;
    this.dueDate = dueDate;
  }

  public String getCourseNum() {
    return courseNum;
  }

  public String getCourseName() {
    return courseName;
  }

  public Date getDueDate() {
    return dueDate;
  }

  @Override public String toString() {
    StringBuilder $ = new StringBuilder();
    $.append(courseName);
    $.append(" - ");
    $.append(courseNum);
    $.append(" - ");
    $.append("Due To: ");
    $.append(dueDate);
    return $ + "";
  }
}
