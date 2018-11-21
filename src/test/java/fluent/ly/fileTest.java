package fluent.ly;

import java.io.*;

import org.junit.*;

import static il.org.spartan.Utils.*;
import il.org.spartan.utils.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class fileTest {
  @Test public void testRenameToCSV() throws IOException {
    File file1 = File.createTempFile("test", "");
    file1.deleteOnExit();
    file.renameToCSV(cantBeNull(file1.getAbsolutePath()));
    file1 = new File(file1.getAbsolutePath() + ".csv");
    file1.deleteOnExit();
    assert file1.isFile();
  }

  @Test public void testRenameToCSVOverwritesExistantFile() throws IOException {
    File file1 = File.createTempFile("test", "");
    file1.deleteOnExit();
    String path1 = String.valueOf(file1.getAbsolutePath());
    FileUtils.writeToFile(cantBeNull(path1), "test");
    file.renameToCSV(cantBeNull(path1));
    file1.createNewFile();
    file1.deleteOnExit();
    file.renameToCSV(cantBeNull(path1));
    file1 = new File(path1 + ".csv");
    file1.deleteOnExit();
    azzert.that(file1.length(), is(0L));
  }

  @Test public void testRenameNonExistantFile() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outContent));
    file.renameToCSV(cantBeNull("Doesnt Exist!"));
    assert (outContent + "").contains("NoSuchFileException");
  }

  @Test public void testRead() throws IOException {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setErr(new PrintStream(outContent));
    azzert.that(FileUtils.readFromFile(".gitignore"), is(file.read(new File(".gitignore"))));
  }
}
