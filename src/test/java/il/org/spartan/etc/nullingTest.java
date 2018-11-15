package il.org.spartan.etc;

import java.util.*;
import java.util.function.*;

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
    Random r = new Random();
    DoubleSupplier iSupplier = () -> Math.round(100*r.nextDouble());
    azzert.isNull(nulling.ly(iSupplier));
  }

  @Test public void testLyLongSupplier() {
    DoubleSupplier lSupplier = () -> 777L;
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
    Supplier<String> strSupplier = () -> {
      Random r = new Random();
      return "foo" + box.box(Math.round(100 * r.nextDouble()));
    };
    azzert.isNull(nulling.ly(strSupplier));
  }
}
