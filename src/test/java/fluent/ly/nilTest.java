package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

@SuppressWarnings("static-method") public class nilTest {
  @Test public void testForgetting() {
    azzert.isNull(nil.forgetting(box(1), box(2)));
    azzert.isNull(nil.forgetting(box(1), "abc"));
    azzert.isNull(nil.forgetting(box(1), box(2.5), "abc", Arrays.asList(box(1), box(2), box(3))));
  }

  static String helperF(final Integer ¢) {
    return ¢ + "";
  }

  @Test public void testGuardingly() {
    final On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    azzert.isNull(ff.on(null));
    azzert.notNull(ff.on(box(1)));
    azzert.that(ff.on(box(11)), is("11"));
  }

  @Test public void testIgnoringBoolean() {
    azzert.isNull(nil.ignoring(true));
    azzert.isNull(nil.ignoring(false));
  }

  @Test public void testIgnoringDouble() {
    azzert.isNull(nil.ignoring(1.5));
    azzert.isNull(nil.ignoring(2.0));
  }

  @Test public void testIgnoringLong() {
    azzert.isNull(nil.ignoring(7034567L));
    azzert.isNull(nil.ignoring(2L));
  }
}
