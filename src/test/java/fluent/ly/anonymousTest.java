package fluent.ly;

import static fluent.ly.azzert.*;

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
    azzert.that(anonymous.ly(() -> d), is(d));
  }

  @Test public void testLyIntSupplier() {
    final int i = new Random().nextInt(100);
    azzert.that(anonymous.ly(() -> i), is(i));
  }

  @Test public void testLyLongSupplier() {
    final long l = new Random().nextLong();
    azzert.that(anonymous.ly(() -> l), is(l));
  }

  @Test public void testLySupplierOfT() {
    azzert.that(anonymous.ly(() -> "abc"), is("abc"));
  }
}
