package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class IsTest {
  @Test public void testIsNotInAndOut() {
    assertFalse(is.in(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
    assertTrue(is.out(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }

  @Test public void testIsInNotOut() {
    assertTrue(is.in(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
    assertFalse(is.out(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }

  @Test public void testIsIntInNotIn() {
    assertFalse(is.intIsIn(1, 2, 3, 4, 5, 6, 7));
  }

  @Test public void testIsIntIn() {
    assertTrue(is.intIsIn(5, 5, 6, 7, 8, 9));
  }
  
  @Test public void testIsEmptyStringNull() {
    assertTrue(is.empty((String)null));
  }
  
  @Test public void testIsEmptyString() {
    assertTrue(is.empty(""));
  }
  
  @Test public void testIsEmptyArrayNull() {
    assertTrue(is.empty((Integer[])null));
  }
  
  @Test public void testIsEmptyArray() {
    assertTrue(is.empty(new Integer[0]));
  }
  
  
  
}
