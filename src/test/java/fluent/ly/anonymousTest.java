package fluent.ly;

import java.util.*;
import java.util.function.*;

import org.junit.*;

 public class anonymousTest {
  @Test @SuppressWarnings("static-method") public void testLyBooleanSupplier() {
    final BooleanSupplier supFalse = () -> false;
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(supFalse);
  }

  @Test @SuppressWarnings("static-method") public void testLyDoubleSupplier() {
    final double d = Math.random();
    Assert.assertEquals(anonymous.ly(() -> d), d, 0.001);
  }

  @Test @SuppressWarnings("static-method") public void testLyIntSupplier() {
    final int i = new Random().nextInt(100);
    azzert.assertEquals(i, anonymous.ly(() -> i));
  }

  @Test @SuppressWarnings("static-method") public void testLyLongSupplier() {
    final long l = new Random().nextLong();
    Assert.assertEquals(l, anonymous.ly(() -> l));
  }

  @Test @SuppressWarnings("static-method") public void testLySupplierOfT() {
    Assert.assertEquals("abc", anonymous.ly(() -> "abc"));
  }
}
