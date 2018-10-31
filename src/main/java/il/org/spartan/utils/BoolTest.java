package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class BoolTest {
  @Test public void testValueOf() {
    assertTrue(Bool.valueOf(true).get());
    assertFalse(Bool.valueOf(false).get());
  }

  @Test public void testClear() {
    assertFalse(Bool.valueOf(true).clear().get());
  }

  @Test public void testGet() {
    assertTrue(new Bool(true).get());
    assertFalse(new Bool(false).get());
    assertFalse(new Bool().get());
  }

  @Test public void testSet() {
    assertTrue(Bool.valueOf(false).set().get());
  }

  @Test public void testSetBoolean() {
    assertTrue(Bool.valueOf(false).set(true).get());
    assertFalse(Bool.valueOf(false).set(false).get());
  }
  
  @Test public void testInner() {
    assertEquals(new Bool(true).inner(), new Boolean(true));
    assertEquals(new Bool(false).inner(), new Boolean(false));
    assertEquals(new Bool().inner(), new Boolean(false));
  }
}
