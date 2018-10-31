package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

public class nilTest {
  @Test public void testForgetting() {
    assertNull(nil.forgetting(new Integer(1), new Integer(2)));
    assertNull(nil.forgetting(new Integer(1), "abc"));
    assertNull(nil.forgetting(new Integer(1), new Double(2.5), "abc", Arrays.asList(1,2,3)));
  }

  static String helperF(Integer i) {
    return i.toString();
  }
  
  @Test public void testGuardingly() {
    On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    assertNull(ff.on(null));
    assertNotNull(ff.on(new Integer(1)));
    assertEquals("1", ff.on(new Integer(1)));
  }

  @Test public void testIgnoringBoolean() {
    assertNull(nil.ignoring(true));
    assertNull(nil.ignoring(false));
  }

  @Test public void testIgnoringDouble() {
    assertNull(nil.ignoring(1.5));
    assertNull(nil.ignoring(2.0));
  }

  @Test public void testIgnoringLong() {
    assertNull(nil.ignoring((long)7034567));
    assertNull(nil.ignoring((long)2));
  }
}
