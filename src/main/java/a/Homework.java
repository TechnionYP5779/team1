package a;

import java.util.*;

public class Homework {
  private final String courseNum;
  private final Date dueDate;

  public Homework(String courseNum, Date dueDate) {
    this.courseNum = courseNum;
    this.dueDate = dueDate;
  }

  public String getCourseNum() {
    return courseNum;
  }

  public Date getDueDate() {
    return dueDate;
  }
}
