package fluent.ly;

import org.junit.*;
import static fluent.ly.azzert.is;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

@SuppressWarnings("static-method") public class defaultsTest {
  @Test public void testToIntegerInt() {
    azzert.that(defaults.to(box(7), 0), is(7));
    azzert.that(defaults.to(null, 0), is(0));
  }

  @Test public void testToIntegerInteger() {
    azzert.that(defaults.to(box(7), box(0)), is(7));
    azzert.that(defaults.to(null, box(0)), is(0));
  }

  @Test public void testToTT() {
    assert unbox(defaults.to(box(true), box(false)));
    assert !unbox(defaults.to(null, box(false)));
  }
}
