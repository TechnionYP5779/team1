package a;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test public void testToList() {
    azzert.that(Arrays.asList("hello"), is(singleton.list("hello")));
  }

  @Test public void testToArray() {
    final Object[] a = singleton.array("hello");
    azzert.that("hello", is(a[0]));
    azzert.that(1, is(a.length));
  }
}