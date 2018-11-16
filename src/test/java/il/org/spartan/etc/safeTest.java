package il.org.spartan.etc;

import org.junit.*;

@SuppressWarnings("static-access") public class safeTest {
  private final double delta = 0.0000000001;

  @Test public void testDivByNonZero() {
    Assert.assertEquals(safe.div(1, 2), 0.5, delta);
  }

  @Test public void testDivByZero() {
    Assert.assertEquals(safe.div(1, 0), 1, delta);
  }
}
