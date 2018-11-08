package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "static-access" }) 
public class BoolTest {
  @Test public void testValueOf() {
    azzert.assertTrue(Bool.valueOf(true).get());
    azzert.assertFalse(Bool.valueOf(false).get());
  }

  @Test public void testClear() {
    azzert.assertFalse(Bool.valueOf(true).clear().get());
  }

  @Test public void testGet() {
    azzert.assertTrue(new Bool(true).get());
    azzert.assertFalse(new Bool(false).get());
    azzert.assertFalse(new Bool().get());
  }

  @Test public void testSet() {
    azzert.assertTrue(Bool.valueOf(false).set().get());
  }

  @Test public void testSetBoolean() {
    azzert.assertTrue(Bool.valueOf(false).set(true).get());
    azzert.assertFalse(Bool.valueOf(false).set(false).get());
  }

  @Test public void testInner() {
    azzert.assertEquals(new Bool(true).inner(), Boolean.TRUE);
    azzert.assertEquals(new Bool(false).inner(), Boolean.FALSE);
    azzert.assertEquals(new Bool().inner(), Boolean.FALSE);
  }
}
