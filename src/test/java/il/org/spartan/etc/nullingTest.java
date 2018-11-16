package il.org.spartan.etc;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class nullingTest {
  @Test public void testLyBooleanSupplier() {
    final BooleanSupplier tSupplier = () -> true, fSupplier = () -> false;
    azzert.isNull(nulling.ly(tSupplier));
    azzert.isNull(nulling.ly(fSupplier));
  }

  @Test public void testLyDoubleSupplier() {
    final Random r = new Random();
    final DoubleSupplier dSupplier = () -> r.nextDouble();
    azzert.isNull(nulling.ly(dSupplier));
  }

  @Test public void testLyIntSupplier() {
    final IntSupplier iSupplier = () -> 7;
    azzert.isNull(nulling.ly(iSupplier));
  }

  @Test public void testLyLongSupplier() {
    final LongSupplier lSupplier = () -> 777L;
    azzert.isNull(nulling.ly(lSupplier));
  }

  @Test public void testLyRunnable() {
    final Runnable r = () -> {
      final String x = "abc";
      x.replace('a', 'd');
    };
    azzert.isNull(nulling.ly(r));
  }

  @Test public void testLySupplierOfR() {
    final Supplier<@Nullable String> strSupplier = () -> {
      final Random r = new Random();
      return "foo" + box.box(Math.round(100 * r.nextDouble()));
    };
    azzert.isNull(nulling.ly(strSupplier));
  }
}
