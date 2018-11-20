package fluent.ly;

import java.util.function.*;

/** TODO saifun: document class
 * @author Yossi Gil
 * @since 2017-04-08 */
/**
 * This interface can be used to get a supplier or a runnable object and deal with it in case of an exception.
 * This interface can wrap such classes run. In case everything went well, it returns the output value.
 * In case something went wrong, and a non-checked exception was thrown - something such as NullPointerException() 
 * or RuntimeException(), it runs the consumer it got to deal with the exception.
 * 
 * @author saifu
 *
 */
public interface robust {
  static void ly(final Runnable r, final Consumer<Exception> c) {
    robust.lyNull(() -> nulling.ly(r::run), c);
  }

  static void ly(final Runnable r, final Runnable x) {
    robust.ly(r, __ -> x.run());
  }

  /**
   * Returns the result of the supplier run, and if it failed, runs the function and returns its result
   * @param <T> - the type of the returned element
   * @param t - the supplier to run
   * @param f - the function to run in case of a failure
   * @return - the output of the supplier in case of success, and the output of the function in case of a failure
   */
  static <T> T ly(final Supplier<T> t, final Function<Exception, T> f) {
    try {
      return t.get();
    } catch (final Exception $) {
      return f.apply($);
    }
  }

  /**
   * Returns the value of the boolean supplier, and if it failed, runs the consumer to deal with the exception and returns false
   * @param s - the boolean supplier
   * @param c - the consumer
   * @return - the value of the boolean supplier in case of success, false in case of a failure
   */
  static boolean lyFalse(final BooleanSupplier s, final Consumer<Exception> c) {
    try {
      return s.getAsBoolean();
    } catch (final Exception $) {
      c.accept($);
      return false;
    }
  }

  static <T> T lyNull(final Supplier<T> t) {
    return robust.ly(t, __ -> null);
  }

  static <T> T lyNull(final Supplier<T> t, final Consumer<Exception> c) {
    return robust.ly(t, λ -> nulling.ly(() -> c.accept(λ)));
  }

  static <T> T lyNull(final Supplier<T> t, final Runnable r) {
    return robust.ly(t, __ -> nulling.ly(r));
  }

  /**
   * Returns the value of the boolean supplier, and if it failed, runs the consumer to deal with the exception and returns true
   * @param s - the boolean supplier
   * @param c - the consumer
   * @return - the value of the boolean supplier in case of success, true in case of a failure
   */
  static boolean lyTrue(final BooleanSupplier $, final Consumer<Exception> c) {
    try {
      return $.getAsBoolean();
    } catch (final Exception ¢) {
      c.accept(¢);
      return true;
    }
  }

  static boolean lyTrue(final Runnable r, final Consumer<Exception> c) {
    try {
      r.run();
    } catch (final Exception ¢) {
      c.accept(¢);
    }
    return true;
  }
}
