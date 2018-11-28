package a;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import java.util.stream.*;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class HomeworkGetter {
  private List<Homework> homework = new ArrayList<>();

  public HomeworkGetter(LoginCredentials creds) {
    try {
      java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
      this.homework = GetHomework(creds);
    } catch (IOException ¢) {
      ¢.printStackTrace();
    }
  }

  private static List<Homework> GetHomework(LoginCredentials c) throws IOException {
    try (WebClient webClient = new WebClient()) {
      HtmlPage page = webClient.getPage("https://grades.cs.technion.ac.il/grades.cgi");
      final HtmlForm form = page.getFormByName("grform");
      final HtmlSubmitInput button = form.getInputByName("submit");
      final HtmlTextInput usernameField = form.getInputByName("ID");
      final HtmlPasswordInput passwordField = form.getInputByName("Password");
      usernameField.type(c.getUsername());
      passwordField.type(c.getPassword());
      final HtmlPage page2 = button.click();
      if (page2.getUrl() == page.getUrl())
        throw new WrongCredentialsException();
      HtmlAnchor homeworkAnchor = page2.getAnchorByText("Homeworks");
      HtmlPage page3 = homeworkAnchor.click();
      final HtmlTable $ = (HtmlTable) page3.getByXPath("//table[@class='stud-hw-table']").get(0);
      $.asText();
      return ExtractHomeworkFromTable($);
    }
  }

  private static List<Homework> ExtractHomeworkFromTable(HtmlTable homeworkTable) {
    List<Homework> $ = new ArrayList<>();
    List<HtmlTableRow> homeworkTableRows = homeworkTable.getRows();
    for (int ¢ = 1; ¢ < homeworkTableRows.size(); ++¢) {
      Homework h1;
      HtmlTableRow r1 = homeworkTableRows.get(¢);
      h1 = parseHomeworkRow(r1);
      if (h1 != null)
        $.add(h1);
    }
    return $;
  }

  private static Homework parseHomeworkRow(HtmlTableRow $) {
    try {
      String[] courseInfo = $.getCell(0).asText().split("-");
      return $.getCell(1).asText().contains("No deadline given") ? null
          : new Homework(courseInfo[0].trim(), courseInfo[1].trim(), (new SimpleDateFormat("dd/MM/yyyy - hh:mm")).parse($.getCell(1).asText()));
    } catch (IndexOutOfBoundsException | ParseException ¢) {
      ¢.printStackTrace();
    }
    return null;
  }

  public List<Homework> getAllHomework() {
    return homework;
  }

  public List<Homework> getUpcomingHomework() {
    Date $ = new Date();
    return homework.stream().filter(hw -> $.before(hw.getDueDate())).collect(Collectors.toList());
  }

  public String getUpcomingHomeworkAsString() {
    StringBuilder $ = new StringBuilder();
    $.append("The upcoming homework are:\n");
    getUpcomingHomework().forEach(λ -> $.append(λ + "\n"));
    return $ + "";
  }
}