package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-access") public class safeTest {
  private double delta = 0.0000000001;

  @Test public void testDivByNonZero() {
    azzert.assertEquals(safe.div(1, 2), 0.5, delta);
  }

  @Test public void testDivByZero() {
    azzert.assertEquals(safe.div(1, 0), 1, delta);
  }
}
