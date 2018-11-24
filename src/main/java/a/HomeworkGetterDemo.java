package a;

import java.util.*;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class HomeworkGetterDemo {
  public static void main(String[] args) {
    try (Scanner reader = new Scanner(System.in)) {
      System.out.println("There will be many warning but dont worry about them!");
      System.out.println("Enter your username: ");
      String username = reader.next();
      System.out.println("Enter your password: ");
      GetHomework(username, reader.next());
    } catch (Exception ¢) {
      ¢.printStackTrace();
    }
  }

  private static void GetHomework(String username, String password) throws Exception {
    try (WebClient webClient = new WebClient()) {
      // Access Grades login page
      HtmlPage page = webClient.getPage("https://grades.cs.technion.ac.il/grades.cgi");
      // Get the form that we are dealing with and within that form,
      final HtmlForm form = page.getFormByName("grform");
      // find the submit button, the username field and the password field.
      final HtmlSubmitInput button = form.getInputByName("submit");
      final HtmlTextInput usernameField = form.getInputByName("ID");
      final HtmlPasswordInput passwordField = form.getInputByName("Password");
      // Change the value of the text field
      usernameField.type(username);
      passwordField.type(password);
      // Now submit the form by clicking the button and get back the second
      // page.
      final HtmlPage page2 = button.click();
      // System.out.println(page2.asText());
      // Find the anchor for the homeworks section
      HtmlAnchor homeworkAnchor = page2.getAnchorByText("Homeworks");
      // Click it
      HtmlPage page3 = homeworkAnchor.click();
      // System.out.println(page3.asText());
      // Extract the homework table
      final HtmlTable homeworkTable = (HtmlTable) page3.getByXPath("//table[@class='stud-hw-table']").get(0);
      // Get rid of spartanizer tip to keep readability
      homeworkTable.asText();
      ExtractHomeworkFromTable(homeworkTable);
    }
  }

  private static List<Homework> ExtractHomeworkFromTable(HtmlTable homeworkTable) {
    // List<Homework> homework = new ArrayList<>();
    List<HtmlTableRow> homeworkTableRows = homeworkTable.getRows();
    for (int ¢ = 1; ¢ < homeworkTableRows.size(); ++¢)
      System.out.println(homeworkTableRows.get(¢).asText());
    // return homework;
    return new ArrayList<>();
  }
}