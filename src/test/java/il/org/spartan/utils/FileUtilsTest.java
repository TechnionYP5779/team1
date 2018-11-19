package il.org.spartan.utils;

import java.io.*;
import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class FileUtilsTest {
  @Test public void testFindAllJavaFilesWithNoArgsReturnsEmptyList() {
    azzert.that(FileUtils.findAllJavaFiles().size(), is(0));
  }

  @Test public void testFindAllJavaFilesCountIsCorrect() {
    azzert.that(FileUtils.findAllJavaFiles("src/main/java/fluent").size(), is(32));
  }

  @Test public void testFindAllJavaFilesCanDealWithNull() {
    azzert.that(FileUtils.findAllJavaFiles(null, "src/main/java/an").size(), is(2));
  }

  @Test public void testReadFromFile() throws IOException {
    azzert.that(FileUtils.readFromFile(".gitignore"), Utils.cantBeNull(containsString("/target/")));
  }

  @Test(expected = IOException.class) public void testReadFromNonExistantFile() throws IOException {
    FileUtils.readFromFile("IDontExist");
  }

  @Test(expected = FileNotFoundException.class) public void testWriteToNonExistantFile() throws FileNotFoundException {
    FileUtils.writeToFile("IDontExist", "Some Random String");
  }
}
