package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.is;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void testValueOf() {
    azzert.that(Bool.valueOf(true).get(), is(true));
    azzert.that(Bool.valueOf(false).get(), is(false));
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
    Assert.assertEquals(new Bool(true).inner(), Boolean.TRUE);
    Assert.assertEquals(new Bool(false).inner(), Boolean.FALSE);
    Assert.assertEquals(new Bool().inner(), Boolean.FALSE);
  }
}
