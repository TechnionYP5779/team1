package a;

public class Homework {
  private final int courseNum;
  private final String dueDate;

  public Homework(int courseNum, String dueDate) {
    this.courseNum = courseNum;
    this.dueDate = dueDate;
  }

  public int getCourseNum() {
    return courseNum;
  }

  public String getDueDate() {
    return dueDate;
  }
}
