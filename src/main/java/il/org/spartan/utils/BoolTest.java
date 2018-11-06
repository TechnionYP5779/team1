package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class BoolTest {
  @Test @SuppressWarnings("static-method") public void testValueOf() {
    assert Bool.valueOf(true).get();
    assert !Bool.valueOf(false).get();
  }

  @Test @SuppressWarnings("static-method") public void testClear() {
    assert !Bool.valueOf(true).clear().get();
  }

  @Test @SuppressWarnings("static-method") public void testGet() {
    assert new Bool(true).get();
    assert !new Bool(false).get();
    assert !new Bool().get();
  }

  @Test @SuppressWarnings("static-method") public void testSet() {
    assert Bool.valueOf(false).set().get();
  }

  @Test @SuppressWarnings("static-method") public void testSetBoolean() {
    assert Bool.valueOf(false).set(true).get();
    assert !Bool.valueOf(false).set(false).get();
  }
  
  @Test @SuppressWarnings("static-method") public void testInner() {
    assertEquals(new Bool(true).inner(), Boolean.TRUE);
    assertEquals(new Bool(false).inner(), Boolean.FALSE);
    assertEquals(new Bool().inner(), Boolean.FALSE);
  }
}
