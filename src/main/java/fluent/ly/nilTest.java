package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

public class nilTest {
  @SuppressWarnings("static-method") @Test public  void testForgetting() {
    assertNull(nil.forgetting(new Integer(1), new Integer(2)));
    assertNull(nil.forgetting(new Integer(1), "abc"));
    assertNull(nil.forgetting(new Integer(1), new Double(2.5), "abc", Arrays.asList(new Integer(1),
        new Integer(2),new Integer(3))));
  }

  static String helperF(Integer i) {
    return i.toString();
  }
  
  @SuppressWarnings("static-method") @Test public  void testGuardingly() {
    On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    assertNull(ff.on(null));
    assertNotNull(ff.on(new Integer(1)));
    assertEquals("1", ff.on(new Integer(1)));
  }

  @SuppressWarnings("static-method") @Test public  void testIgnoringBoolean() {
    assertNull(nil.ignoring(true));
    assertNull(nil.ignoring(false));
  }

  @SuppressWarnings("static-method") @Test public  void testIgnoringDouble() {
    assertNull(nil.ignoring(1.5));
    assertNull(nil.ignoring(2.0));
  }

  @SuppressWarnings("static-method") @Test public  void testIgnoringLong() {
    assertNull(nil.ignoring((long)7034567));
    assertNull(nil.ignoring((long)2));
  }
}
