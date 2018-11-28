package a;

import java.util.*;

public class HomeworkGetterDemo {
  public static void main(String[] args) {
    try (Scanner reader = new Scanner(System.in)) {
      System.out.println("There will be many warning but dont worry about them!");
      System.out.println("Enter your username: ");
      String username = reader.next();
      System.out.println("Enter your password: ");
      System.out.println(new HomeworkGetter(new LoginCredentials(username, reader.next())).getUpcomingHomeworkAsString());
    } catch (Exception ¢) {
      ¢.printStackTrace();
    }
  }
}