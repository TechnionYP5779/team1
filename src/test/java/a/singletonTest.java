package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "static-access" }) public class singletonTest {
  @Test public void testToList() {
    azzert.assertEquals(Arrays.asList("hello"), singleton.list("hello"));
  }

  @Test public void testToArray() {
    final Object[] a = singleton.array("hello");
    azzert.assertEquals("hello", a[0]);
    azzert.assertEquals(1, a.length);
  }
}