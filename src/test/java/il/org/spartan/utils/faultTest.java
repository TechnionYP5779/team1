package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class faultTest {
  @Test public void nullTest() {
    azzert.notNull(fault.done());
    azzert.notNull(fault.trace());
    azzert.notNull(fault.dump());
    azzert.notNull(fault.specifically("Beacause", new Object(), new Object(), new Object()));
  }

  @Test public void boolTest() {
    azzert.assertFalse(fault.unreachable());
    azzert.assertFalse(fault.bool(new Object()));
  }
}
