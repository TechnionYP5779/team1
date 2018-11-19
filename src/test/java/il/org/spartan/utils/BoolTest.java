package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
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
    assert unbox.unbox(new Bool(true).inner());
    assert !unbox.unbox(new Bool(false).inner());
    assert !unbox.unbox(new Bool().inner());
  }
}
