package a;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test public void testToList() {
    assertEquals(Arrays.asList("hello"), singleton.list("hello"));
  }

  @Test public void testToArray() {
    Object[] a = singleton.array("hello");
    assertEquals("hello", a[0]);
    assertEquals(1, a.length);
  }
}