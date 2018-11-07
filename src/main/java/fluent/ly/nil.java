package fluent.ly;

import java.util.*;
import java.util.function.*;

import org.junit.*;

import fluent.ly.nil.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
@SuppressWarnings({ "unused", "null" }) public interface nil {
  interface On<T, R> {
    R on(T t);
  }

  static <T> T forgetting(final Object _1, final Object... _2) {
    return null;
  }

  static <T, R> On<T, R> guardingly(final Function<T, R> f) {
    return λ -> λ == null ? null : f.apply(λ);
  }

  static <T> T ignoring(final boolean __) {
    return null;
  }

  static <T> T ignoring(final double __) {
    return null;
  }

  static <T> T ignoring(final long __) {
    return null;
  }
  
  public static class TEST {
    @Test @SuppressWarnings("static-method") public void testForgetting() {
      azzert.assertNull(nil.forgetting(Integer.valueOf(1), Integer.valueOf(2)));
      azzert.assertNull(nil.forgetting(Integer.valueOf(1), "abc"));
      azzert.assertNull(
          nil.forgetting(Integer.valueOf(1), Double.valueOf(2.5), "abc", Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))));
    }

    static String helperF(Integer ¢) {
      return ¢ + "";
    }
    
    @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGuardingly() {
      On<Integer, String> ff = nil.guardingly(TEST::helperF);
      azzert.assertNull(ff.on(null));
      azzert.assertNotNull(ff.on(Integer.valueOf(1)));
      azzert.assertEquals("1", ff.on(Integer.valueOf(1)));
    }

    @Test @SuppressWarnings("static-method") public void testIgnoringBoolean() {
      azzert.assertNull(nil.ignoring(true));
      azzert.assertNull(nil.ignoring(false));
    }

    @Test @SuppressWarnings("static-method") public void testIgnoringDouble() {
      azzert.assertNull(nil.ignoring(1.5));
      azzert.assertNull(nil.ignoring(2.0));
    }

    @Test @SuppressWarnings("static-method") public void testIgnoringLong() {
      azzert.assertNull(nil.ignoring(7034567L));
      azzert.assertNull(nil.ignoring(2L));
    }
  }

  
}
