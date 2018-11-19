package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static il.org.spartan.Utils.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class FileUtilsTest {
  @Test public void testFindAllJavaFilesWithNoArgsReturnsEmptyList() {
    azzert.that(FileUtils.findAllJavaFiles().size(), is(0));
  }

  @Test public void testFindAllJavaFilesCountIsCorrect() {
    azzert.that(FileUtils.findAllJavaFiles("src/main/java/fluent").size(), is(34));
  }

  @Test public void testFindAllJavaFilesCanDealWithNull() {
    azzert.that(FileUtils.findAllJavaFiles(null, "src/main/java/an").size(), is(2));
  }

  @Test public void testReadFromFile() throws IOException {
    azzert.that(FileUtils.readFromFile(".gitignore"), cantBeNull(containsString("/target/")));
  }

  @Test(expected = IOException.class) public void testReadFromNonExistantFile() throws IOException {
    FileUtils.readFromFile("IDontExist");
  }

  @Test(expected = FileNotFoundException.class) public void testWriteToNonExistantFile() throws FileNotFoundException {
    FileUtils.writeToFile("IDontExist", "Some Random String");
  }
}
