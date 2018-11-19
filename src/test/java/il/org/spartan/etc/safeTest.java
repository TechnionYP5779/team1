package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class safeTest {
  @Test public void testDivByNonZero() {
    azzert.that(safe.div(1, 2), is(0.5));
  }

  @Test public void testDivByZero() {
    azzert.that(safe.div(1, 0), is(1.0));
  }

  @Test public void testErrorMarginsNotIgnoredSanityCheck() {
    azzert.that(safe.div(1, 0), not(is(1.000000000000001)));
  }
}
