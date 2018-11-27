package course.info;

import java.io.*;
import java.util.*;

import org.json.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

public class Extractor {
  public static List<CourseObject> toCourseObjectList() {
    List<CourseObject> $ = new ArrayList<>();
    JSONArray faculties = JsonReader.readJsonFromUrl("https://storage.googleapis.com/repy-176217.appspot.com/latest.json");
    for (int i = 0; i < faculties.length(); ++i)
      try {
        JSONObject faculty = faculties.getJSONObject(i);
        String semesterName = faculty.getString("semester"), facultyName = faculty.getString("name");
        JSONArray courses = faculty.getJSONArray("courses");
        for (int c = 0; c < courses.length(); ++c) {
          JSONObject course = courses.getJSONObject(c);
          Integer id = box.it(course.getInt("id"));
          String cName = course.getString("name");
          Integer ap = box.it(course.getInt("academicPoints"));
          String lecturerInCharge = course.getString("lecturerInCharge");
          JSONObject weeklyHours = course.getJSONObject("weeklyHours");
          Optional<Integer> lh = Optional.empty(), th = Optional.empty(), ph = Optional.empty(), labh = Optional.empty();
          for (Iterator<String> keys = weeklyHours.keys(); keys.hasNext();) {
            String key = keys.next();
            if ("lecturer".equals(key))
              lh = Optional.of(box.it(weeklyHours.getInt("lecturer")));
            else if ("tutorial".equals(key))
              th = Optional.of(box.it(weeklyHours.getInt("tutorial")));
            else if ("project".equals(key))
              ph = Optional.of(box.it(weeklyHours.getInt("project")));
            else if ("lab".equals(key))
              labh = Optional.of(box.it(weeklyHours.getInt("lab")));
          }
          Optional<CourseObject.ExamDate> A = Optional.empty(), B = Optional.empty();
          if (!course.isNull("testDates")) {
            JSONArray testDates = course.getJSONArray("testDates");
            JSONObject td = testDates.getJSONObject(0);
            A = Optional.of(new CourseObject.ExamDate(box.it(td.getInt("day")), box.it(td.getInt("month")), box.it(td.getInt("year"))));
            try {
              td = testDates.getJSONObject(1);
              B = Optional.of(new CourseObject.ExamDate(box.it(td.getInt("day")), box.it(td.getInt("month")), box.it(td.getInt("year"))));
            } catch (@SuppressWarnings("unused") JSONException e) {
              B = Optional.empty();
            }
          }
          $.add(new CourseObject(facultyName, id, cName, ap, lecturerInCharge, lh, th, ph, labh, A, B, semesterName));
        }
      } catch (JSONException ¢) {
        ¢.printStackTrace();
      }
    return $;
  }
  //Delimiter used in CSV file
  private static final String COMMA_DELIMITER = ",";
  private static final String NEW_LINE_SEPARATOR = "\n";
  
  //CSV file header
  // faculty, name, id ,academicPoints, lecturerInCharge, lectureHours, tutorialHours, labHours, projectHours, examA, examB, semester
  private static final String FILE_HEADER = "faculty, name, id ,academicPoints, lecturerInCharge, lectureHours, tutorialHours, labHours, projectHours, examA, examB, semester";
  
  public static void writeCsvFile(String fileName,List<CourseObject> cl ) {
    @SuppressWarnings("resource") FileWriter fileWriter = null;
    
    try {
      fileWriter = new FileWriter(fileName);

      //Write the CSV file header
      fileWriter.append(FILE_HEADER);
      
      //Add a new line separator after the header
      fileWriter.append(NEW_LINE_SEPARATOR);
      
      //Write a new student object list to the CSV file
      for (CourseObject ¢ : cl) {
        fileWriter.append(¢.getFaculty());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(¢.getName());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getId()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getAcademicPoints()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(¢.getLecturerInCharge());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getLectureHours()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getTutorialHours()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getLabHours()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf(¢.getProjectHours()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(¢.getExamA());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(¢.getExamB());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(¢.getSemester());
        
        fileWriter.append(NEW_LINE_SEPARATOR);
      }

      
      
      System.out.println("CSV file was created successfully !!!");
      
    } catch (Exception ¢) {
      System.out.println("Error in CsvFileWriter !!!");
      ¢.printStackTrace();
    } finally {
      
      try {
        assert fileWriter != null;
        fileWriter.flush();
        fileWriter.close();
      } catch (IOException ¢) {
        System.out.println("Error while flushing/closing fileWriter !!!");
                ¢.printStackTrace();
      }
      
    }
  }
}
