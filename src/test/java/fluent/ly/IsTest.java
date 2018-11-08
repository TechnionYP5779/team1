package fluent.ly;

import java.util.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class IsTest {
  @Test public void testIsNotInAndOut() {
    azzert.assertFalse(is.in(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
    azzert.assertTrue(is.out(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }

  @Test public void testIsInNotOut() {
    azzert.assertTrue(is.in(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
    azzert.assertFalse(is.out(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }

  @Test public void testIsIntInNotIn() {
    azzert.assertFalse(is.intIsIn(1, 2, 3, 4, 5, 6, 7));
  }

  @Test public void testIsIntIn() {
    azzert.assertTrue(is.intIsIn(5, 5, 6, 7, 8, 9));
  }

  @Test public void testIsEmptyStringNull() {
    azzert.assertTrue(is.empty((String) null));
  }

  @Test public void testIsEmptyString() {
    azzert.assertTrue(is.empty(""));
  }

  @Test public void testIsEmptyArrayNull() {
    azzert.assertTrue(is.empty((Integer[]) null));
  }

  @Test public void testIsEmptyArray() {
    azzert.assertTrue(is.empty(new Integer[0]));
  }

  @Test public void testNullList() {
    azzert.assertTrue(is.empty((ArrayList<Integer>) null));
  }

  @Test public void testEmptyList() {
    azzert.assertTrue(is.empty(new ArrayList<Integer>()));
  }
}
