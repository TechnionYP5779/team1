package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "static-access" }) 
public class BoolTest {
  @Test public void testValueOf() {
    assert Bool.valueOf(true).get();
    assert !Bool.valueOf(false).get();
  }

  @Test public void testClear() {
    assert !Bool.valueOf(true).clear().get();
  }

  @Test public void testGet() {
    assert new Bool(true).get();
    assert !new Bool(false).get();
    assert !new Bool().get();
  }

  @Test public void testSet() {
    assert Bool.valueOf(false).set().get();
  }

  @Test public void testSetBoolean() {
    assert Bool.valueOf(false).set(true).get();
    assert !Bool.valueOf(false).set(false).get();
  }

  @Test public void testInner() {
    azzert.assertEquals(new Bool(true).inner(), Boolean.TRUE);
    azzert.assertEquals(new Bool(false).inner(), Boolean.FALSE);
    azzert.assertEquals(new Bool().inner(), Boolean.FALSE);
  }
}
