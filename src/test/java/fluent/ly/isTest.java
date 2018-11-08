package fluent.ly;

import java.util.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class isTest {
  @Test public void testIsNotInAndOut() {
    assert !is.in(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2));
    assert is.out(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2));
  }

  @Test public void testIsInNotOut() {
    assert is.in(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2));
    assert !is.out(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2));
  }

  @Test public void testIsIntInNotIn() {
    assert !is.intIsIn(1, 2, 3, 4, 5, 6, 7);
  }

  @Test public void testIsIntIn() {
    assert is.intIsIn(5, 5, 6, 7, 8, 9);
  }

  @Test public void testIsEmptyStringNull() {
    assert is.empty((String) null);
  }

  @Test public void testIsEmptyString() {
    assert is.empty("");
  }

  @Test public void testIsEmptyArrayNull() {
    assert is.empty((Integer[]) null);
  }

  @Test public void testIsEmptyArray() {
    assert is.empty(new Integer[0]);
  }

  @Test public void testNullList() {
    assert is.empty((ArrayList<Integer>) null);
  }

  @Test public void testEmptyList() {
    assert is.empty(new ArrayList<Integer>());
  }
}
