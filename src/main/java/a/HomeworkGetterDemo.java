package a;

import java.util.*;

public class HomeworkGetterDemo {
  public static void main(String[] args) {
    try (Scanner reader = new Scanner(System.in)) {
      System.out.println("There will be many warning but dont worry about them!");
      System.out.println("Enter your username: ");
      String username = reader.next();
      System.out.println("Enter your password: ");
      new HomeworkGetter(new LoginCredentials(username, reader.next())).getUpcomingHomework().stream()
          .forEach(λ -> System.out.println(λ.getDueDate()));
    } catch (Exception ¢) {
      ¢.printStackTrace();
    }
  }
}