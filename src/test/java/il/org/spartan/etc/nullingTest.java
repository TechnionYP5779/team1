package il.org.spartan.etc;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class nullingTest {
  @Test public void testLyBooleanSupplier() {
    BooleanSupplier tSupplier = () -> true, fSupplier = () -> false;
    azzert.isNull(nulling.ly(tSupplier));
    azzert.isNull(nulling.ly(fSupplier));
  }

  @Test public void testLyDoubleSupplier() {
    Random r = new Random();
    DoubleSupplier dSupplier = () -> r.nextDouble();
    azzert.isNull(nulling.ly(dSupplier));
  }

  @Test public void testLyIntSupplier() {
    IntSupplier iSupplier = () -> 7;
    azzert.isNull(nulling.ly(iSupplier));
  }

  @Test public void testLyLongSupplier() {
    LongSupplier lSupplier = () -> 777L;
    azzert.isNull(nulling.ly(lSupplier));
  }

  @Test public void testLyRunnable() {
    Runnable r = () -> {
      String x = "abc";
      x.replace('a', 'd');
    };
    azzert.isNull(nulling.ly(r));
  }

  @Test public void testLySupplierOfR() {
    Supplier<@Nullable String> strSupplier = () -> {
      Random r = new Random();
      return "foo" + box.box(Math.round(100 * r.nextDouble()));
    };
    azzert.isNull(nulling.ly(strSupplier));
  }
}
