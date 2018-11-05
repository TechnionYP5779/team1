package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;
import java.util.function.*;

import org.junit.*;

public class anonymousTest {
  @SuppressWarnings("static-method") @Test public  void testLyBooleanSupplier() {
    BooleanSupplier supTrue = () -> true;
    BooleanSupplier supFalse = () -> false;
    assertTrue(anonymous.ly(supTrue));
    assertFalse(anonymous.ly(supFalse));
  }

  @SuppressWarnings("static-method") @Test public  void testLyDoubleSupplier() {
    double d = Math.random();
    DoubleSupplier dSupplier = () -> d;
    assertEquals(anonymous.ly(dSupplier), d, 0.001);
  }

  @SuppressWarnings("static-method") @Test public  void testLyIntSupplier() {
    Random rand = new Random();
    int i = rand.nextInt(100);
    IntSupplier iSupplier = () -> i; 
    assertEquals(i, anonymous.ly(iSupplier));
  }

  @SuppressWarnings("static-method") @Test public  void testLyLongSupplier() {
    Random rand = new Random();
    long l = rand.nextLong();
    LongSupplier lSupplier = () -> l; 
    assertEquals(l, anonymous.ly(lSupplier));
  }

  @SuppressWarnings("static-method") @Test public  void testLySupplierOfT() {
    Supplier<String> sSupplier = () -> "abc";
    assertEquals("abc", anonymous.ly(sSupplier));
  }
}
