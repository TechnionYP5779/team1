package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BinaryTest {
  @Test public void andTest() {
    azzert.notNull(Binary.and(Binary.T, Binary.T));
    azzert.notNull(Binary.and(Binary.F, Binary.T));
    azzert.isNull(Binary.and(Binary.F, Binary.F));
    azzert.notNull(Binary.and(Binary.T, Binary.F));
  }

  @Test public void asBooleanTest() {
    azzert.notNull(Binary.asBoolean(Binary.T));
    azzert.isNull(Binary.asBoolean(Binary.F));
  }

  @Test public void eqTest() {
    azzert.notNull(Binary.eq(Binary.T, Binary.T));
    azzert.isNull(Binary.eq(Binary.F, Binary.T));
    azzert.notNull(Binary.eq(Binary.F, Binary.F));
    azzert.isNull(Binary.eq(Binary.T, Binary.F));
  }

  @Test public void orTest() {
    azzert.notNull(Binary.or(Binary.T, Binary.T));
    azzert.notNull(Binary.or(Binary.F, Binary.T));
    azzert.isNull(Binary.or(Binary.F, Binary.F));
    azzert.notNull(Binary.or(Binary.T, Binary.F));
  }

  @Test public void notTest() {
    azzert.isNull(Binary.not(Binary.T));
    azzert.notNull(Binary.not(Binary.F));
  }

  @Test public void etcTest() {
    try {
      Binary.T.equals(Binary.T);
    } catch (final IllegalArgumentException ¢) {
      assertEquals("il.org.spartan.utils.Binary@1", ¢.getMessage());
    }
    azzert.assertEquals(Integer.valueOf(1), Binary.T.clone().hashCode());
  }
}