package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/** A poor man's approximation of a mutable boolean, which is so much more
 * convenient than {@link Boolean}
 * @author Ori Marcovitch
 * @since Oct 16, 2016 */
public final class Bool {
  public static Bool valueOf(final boolean ¢) {
    return new Bool(¢);
  }

  public boolean inner;

  public Bool() {
  }

  public Bool(final boolean b) {
    inner = b;
  }

  public Bool clear() {
    return set(false);
  }

  public boolean get() {
    return inner;
  }

  /** Function form, good substitute for auto-boxing */
  public Boolean inner() {
    return Boolean.valueOf(inner);
  }

  public Bool set() {
    return set(true);
  }

  public Bool set(final boolean ¢) {
    inner = ¢;
    return this;
  }
  
  
  public static class TEST {
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
  
}
