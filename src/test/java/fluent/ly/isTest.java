package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class isTest {
  @Test public void testIsNotInAndOut() {
    assert !is.in(box(1), cantBeNull(box(8)), cantBeNull(box(100)), cantBeNull(box(2)));
    assert is.out(box(1), cantBeNull(box(8)), cantBeNull(box(100)), cantBeNull(box(2)));
  }

  @Test public void testIsInNotOut() {
    assert is.in(box(8), cantBeNull(box(8)), cantBeNull(box(100)), cantBeNull(box(2)));
    assert !is.out(box(8), cantBeNull(box(8)), cantBeNull(box(100)), cantBeNull(box(2)));
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
