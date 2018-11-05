package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class BoolTest {
  @SuppressWarnings("static-method") @Test public void testValueOf() {
    assertTrue(Bool.valueOf(true).get());
    assertFalse(Bool.valueOf(false).get());
  }

  @SuppressWarnings("static-method") @Test public void testClear() {
    assertFalse(Bool.valueOf(true).clear().get());
  }

  @SuppressWarnings("static-method") @Test public void testGet() {
    assertTrue(new Bool(true).get());
    assertFalse(new Bool(false).get());
    assertFalse(new Bool().get());
  }

  @SuppressWarnings("static-method") @Test public  void testSet() {
    assertTrue(Bool.valueOf(false).set().get());
  }

  @SuppressWarnings("static-method") @Test public  void testSetBoolean() {
    assertTrue(Bool.valueOf(false).set(true).get());
    assertFalse(Bool.valueOf(false).set(false).get());
  }
  
  @SuppressWarnings("static-method") @Test public  void testInner() {
    assertEquals(new Bool(true).inner(), Boolean.valueOf(true));
    assertEquals(new Bool(false).inner(), Boolean.valueOf(false));
    assertEquals(new Bool().inner(), Boolean.valueOf(false));
  }
}
