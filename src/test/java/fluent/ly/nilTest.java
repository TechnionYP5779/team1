package fluent.ly;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

@SuppressWarnings("static-method") public class nilTest {
  @Test public void testForgetting() {
    azzert.assertNull(nil.forgetting(Integer.valueOf(1), Integer.valueOf(2)));
    azzert.assertNull(nil.forgetting(Integer.valueOf(1), "abc"));
    azzert.assertNull(
        nil.forgetting(Integer.valueOf(1), Double.valueOf(2.5), "abc", Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))));
  }

  static String helperF(final Integer ¢) {
    return ¢ + "";
  }

  @Test public void testGuardingly() {
    final On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    azzert.assertNull(ff.on(null));
    Assert.assertNotNull(ff.on(Integer.valueOf(1)));
    Assert.assertEquals("1", ff.on(Integer.valueOf(1)));
  }

  @Test public void testIgnoringBoolean() {
    azzert.assertNull(nil.ignoring(true));
    azzert.assertNull(nil.ignoring(false));
  }

  @Test public void testIgnoringDouble() {
    azzert.assertNull(nil.ignoring(1.5));
    azzert.assertNull(nil.ignoring(2.0));
  }

  @Test public void testIgnoringLong() {
    azzert.assertNull(nil.ignoring(7034567L));
    azzert.assertNull(nil.ignoring(2L));
  }
}
