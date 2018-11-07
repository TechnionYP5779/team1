package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;
import java.util.function.*;

import org.junit.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface anonymous {
  static boolean ly(final BooleanSupplier $) {
    return $.getAsBoolean();
  }

  static double ly(final DoubleSupplier $) {
    return $.getAsDouble();
  }

  static int ly(final IntSupplier $) {
    return $.getAsInt();
  }

  static long ly(final LongSupplier $) {
    return $.getAsLong();
  }

  static <T> T ly(final Supplier<T> $) {
    return $.get();
  }
  
  
  public static class TEST {
    @Test @SuppressWarnings("static-method") public void testLyBooleanSupplier() {
      BooleanSupplier supFalse = () -> false;
      assert anonymous.ly(() -> true);
      assert !anonymous.ly(supFalse);
    }

    @Test @SuppressWarnings("static-method") public void testLyDoubleSupplier() {
      double d = Math.random();
      assertEquals(anonymous.ly(() -> d), d, 0.001);
    }

    @Test @SuppressWarnings("static-method") public void testLyIntSupplier() {
      int i = new Random().nextInt(100);
      assertEquals(i, anonymous.ly(() -> i));
    }

    @Test @SuppressWarnings("static-method") public void testLyLongSupplier() {
      long l = new Random().nextLong();
      assertEquals(l, anonymous.ly(() -> l));
    }

    @Test @SuppressWarnings("static-method") public void testLySupplierOfT() {
      assertEquals("abc", anonymous.ly(() -> "abc"));
    }
  }
}
