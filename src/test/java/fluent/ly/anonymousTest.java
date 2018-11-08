package fluent.ly;

import java.util.*;
import java.util.function.*;
import org.junit.*;

@SuppressWarnings("static-access") public class anonymousTest {
  @Test @SuppressWarnings("static-method") public void testLyBooleanSupplier() {
    BooleanSupplier supFalse = () -> false;
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(supFalse);
  }

  @Test @SuppressWarnings("static-method") public void testLyDoubleSupplier() {
    double d = Math.random();
    azzert.assertEquals(anonymous.ly(() -> d), d, 0.001);
  }

  @Test @SuppressWarnings("static-method") public void testLyIntSupplier() {
    int i = new Random().nextInt(100);
    azzert.assertEquals(i, anonymous.ly(() -> i));
  }

  @Test @SuppressWarnings("static-method") public void testLyLongSupplier() {
    long l = new Random().nextLong();
    azzert.assertEquals(l, anonymous.ly(() -> l));
  }

  @Test @SuppressWarnings("static-method") public void testLySupplierOfT() {
    azzert.assertEquals("abc", anonymous.ly(() -> "abc"));
  }
}
