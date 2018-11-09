package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

@SuppressWarnings("static-method") public class IterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countDoesNotIncludeNull() {
    assertEquals(3, iterables.count(iterable.over(null, "One", null, "Two", null, "Three")));
  }

  @Test public void countEmpty() {
    assertEquals(0, iterables.count(iterables.<String> empty()));
  }

  @Test public void countSingleton() {
    assertEquals(1, iterables.count(iterable.singleton(new Object())));
  }

  @Test public void countThree() {
    assertEquals(3, iterables.count(iterable.over("One", "Two", "Three")));
  }
}
