package fluent.ly;

import il.org.spartan.etc.*;

/** Fluent API, see usage
 * @author Yossi Gil
 * @since 2017-04-10 */
public interface zero {
  static int forgetting(final Object _1, final Object... _2) {
    forget.all(_1, _2);
    return 0;
  }

  static int forget(final boolean __) {
    forget.it(__);
    return 0;
  }

  static int forget(final double __) {
    forget.it(__);
    return 0;
  }

  static int forget(final long __) {
    forget.it(__);
    return 0;
  }
}
