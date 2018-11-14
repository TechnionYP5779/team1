package fluent.ly;

import java.util.*;
import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void testLyBooleanSupplier() {
    final BooleanSupplier supFalse = () -> false;
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(supFalse);
  }

  @Test public void testLyDoubleSupplier() {
    final double d = Math.random();
    Assert.assertEquals(anonymous.ly(() -> d), d, 0.001);
  }

  @Test public void testLyIntSupplier() {
    final int i = new Random().nextInt(100);
    azzert.assertEquals(i, anonymous.ly(() -> i));
  }

  @Test public void testLyLongSupplier() {
    final long l = new Random().nextLong();
    Assert.assertEquals(l, anonymous.ly(() -> l));
  }

  @Test public void testLySupplierOfT() {
    Assert.assertEquals("abc", anonymous.ly(() -> "abc"));
  }
}
