package il.org.spartan.etc;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-access", "static-method" }) public class outTest {
  @Test public void testOutString() {
    String tested = "I am a Test String";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested);
    azzert.assertEquals(tested, outContent + "");
  }

  @Test public void testOutBoolean() {
    String tested = "I am a Test String";
    boolean pred = true;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, pred);
    azzert.assertEquals(tested + " = " + pred + "\n", outContent + "");
  }

  @Test public void testOutNullCollection() {
    String tested = "I am a Test String";
    List<Integer> lst = null;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutEmptyCollectionOfObjects() {
    String tested = "I am a Test String";
    List<Object> lst = new ArrayList<>();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutCollectionOfOneObject() {
    String tested = "I am a Test String";
    List<Object> lst = new ArrayList<>();
    Integer num = box.box(3);
    lst.add(num);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("Only 1 " + tested + ": " + num + "\n", outContent + "");
  }

  @Test public void testOutCollectionOfMultipleObjects() {
    String tested = "I am a Test String";
    List<Object> lst = new ArrayList<>();
    Integer num = box.box(3);
    lst.add(num);
    lst.add(num);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("Total of " + lst.size() + " " + tested + ":\n\t 1) " + num + "\n\t 2) " + num + "\n", outContent + "");
  }

  @Test public void testOutInt() {
    String tested = "I am a Test String";
    int num = 0;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, num);
    azzert.assertEquals(tested + " = " + num + "\n", outContent + "");
  }

  @Test public void testOutNullObject() {
    String tested = "I am a Test String";
    Object str = null;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, str);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutObject() {
    String tested = "I am a Test String";
    Object str = "I am also a Test String";
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, str);
    azzert.assertEquals(tested + " = " + str + "\n", outContent + "");
  }

  @Test public void testOutNullObjectArray() {
    String tested = "I am a Test String";
    Object[] arr = null;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutEmptyObjectArrayOfObjects() {
    String tested = "I am a Test String";
    Object[] arr = new Object[0];
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutObjectArrayOfOneObject() {
    String tested = "I am a Test String";
    Object[] arr = new Object[1];
    Integer num = box.box(3);
    arr[0] = num;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("Only one " + tested + ": " + num + "\n", outContent + "");
  }

  @Test public void testOutObjectArrayOfMultipleObjects() {
    String tested = "I am a Test String";
    Object[] arr = new Object[2];
    Integer num = box.box(3);
    arr[1] = arr[0] = num;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("Total of " + arr.length + " " + tested + ":\n\t" + num + "\n\t" + num + "\n", outContent + "");
  }
}
