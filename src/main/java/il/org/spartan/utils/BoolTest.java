package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class BoolTest {
  @Test @SuppressWarnings("static-method") public void testValueOf() {
    azzert.assertTrue(Bool.valueOf(true).get());
    azzert.assertFalse(Bool.valueOf(false).get());
    
  }

  @Test @SuppressWarnings("static-method") public void testClear() {
    azzert.assertFalse(Bool.valueOf(true).clear().get());
  }

  @Test @SuppressWarnings("static-method") public void testGet() {
    azzert.assertTrue(new Bool(true).get());
    azzert.assertFalse(new Bool(false).get());
    azzert.assertFalse(new Bool().get());
  }

  @Test @SuppressWarnings("static-method") public void testSet() {
    azzert.assertTrue(Bool.valueOf(false).set().get());
  }

  @Test @SuppressWarnings("static-method") public void testSetBoolean() {
    azzert.assertTrue(Bool.valueOf(false).set(true).get());
    azzert.assertFalse(Bool.valueOf(false).set(false).get());
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testInner() {
    azzert.assertEquals(new Bool(true).inner(), Boolean.TRUE);
    azzert.assertEquals(new Bool(false).inner(), Boolean.FALSE);
    azzert.assertEquals(new Bool().inner(), Boolean.FALSE);
  }
}
