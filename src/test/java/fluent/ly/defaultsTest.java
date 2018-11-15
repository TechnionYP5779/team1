package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class defaultsTest {
  @Test public void testToIntegerInt() {
    azzert.assertEquals(7, defaults.to(box.box(7), 0));
    azzert.assertEquals(0, defaults.to(null, 0));
  }

  @Test public void testToIntegerInteger() {
    azzert.assertEquals(7, defaults.to(box.box(7), box.box(0)));
    azzert.assertEquals(0, defaults.to(null, box.box(0)));
  }

  @Test public void testToTT() {
    azzert.assertTrue(unbox.unbox(defaults.to(box.box(true), box.box(false))));
    azzert.assertFalse(unbox.unbox(defaults.to(null, box.box(false))));
  }
}
