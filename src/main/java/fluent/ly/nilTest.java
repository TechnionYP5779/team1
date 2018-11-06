package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;
import fluent.ly.nil.*;

public class nilTest {
  @Test @SuppressWarnings("static-method") public void testForgetting() {
    assertNull(nil.forgetting(Integer.valueOf(1), Integer.valueOf(2)));
    assertNull(nil.forgetting(Integer.valueOf(1), "abc"));
    assertNull(
        nil.forgetting(Integer.valueOf(1), Double.valueOf(2.5), "abc", Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))));
  }

  static String helperF(Integer ¢) {
    return ¢ + "";
  }
  
  @Test @SuppressWarnings("static-method") public void testGuardingly() {
    On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    assertNull(ff.on(null));
    assertNotNull(ff.on(Integer.valueOf(1)));
    assertEquals("1", ff.on(Integer.valueOf(1)));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringBoolean() {
    assertNull(nil.ignoring(true));
    assertNull(nil.ignoring(false));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringDouble() {
    assertNull(nil.ignoring(1.5));
    assertNull(nil.ignoring(2.0));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringLong() {
    assertNull(nil.ignoring(7034567L));
    assertNull(nil.ignoring(2L));
  }
}
