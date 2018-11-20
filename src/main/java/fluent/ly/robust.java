package fluent.ly;

import java.util.function.*;

/**
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
   * The function calls robustly with the two runnables as the second is wrapped as a consumer
   * @param r - the first runnable (this would be the runnable for the robustly)
   * @param x - the second runnable (this would be the consumer for the robustly)
   */
  static void ly(final Runnable r, final Runnable x) {
    robust.ly(r, __ -> x.run());
  }
  
  /**
   * runs robustlyNull with a supplier that runs r and returns null. If there is an exception, the consumer deals with it.
   * @param r - the runnable
   * @param c - the consumer
   */
  static void ly(final Runnable r, final Consumer<Exception> c) {
    robust.lyNull(() -> nulling.ly(r::run), c);
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

  /**
   * Returns the supplier result, and in case of an exception returns null
   * @param <T> - the type of the supplier result
   * @param t - the supplier
   * @return the supplier result, and null in case of an exception
   */
  static <T> T lyNull(final Supplier<T> t) {
    return robust.ly(t, __ -> null);
  }

  /**
   * Runs the supplier, returns its result, and in case of an exception, runs the consumer to deal with the exception and returns the.nil()
   * @param <T> - the result type
   * @param t - the supplier
   * @param c - the consumer 
   * @return - the supplier result, and the.nil() in case of an exception
   */
  static <T> T lyNull(final Supplier<T> t, final Consumer<Exception> c) {
    return robust.ly(t, λ -> nulling.ly(() -> c.accept(λ)));
  }

  /**
   * Runs the supplier, returns its result, and in case of an exception runs the runnable and returns the.nil()
   * @param <T> - the result type
   * @param t - the supplier
   * @param r - the runnable
   * @return - the supplier result, and in case of an exception the.nil()
   */
  static <T> T lyNull(final Supplier<T> t, final Runnable r) {
    return robust.ly(t, __ -> nulling.ly(r));
  }

  /**
   * Returns the value of the boolean supplier, and if it failed, runs the consumer to deal with the exception and returns true
   * @param $ - the boolean supplier
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

  /**
   * Runs the runnable, and if it failed, runs the consumer to deal with the exception and returns true
   * @param r - the runnable
   * @param c - the consumer
   * @return - always true
   */
  static boolean lyTrue(final Runnable r, final Consumer<Exception> c) {
    try {
      r.run();
    } catch (final Exception ¢) {
      c.accept(¢);
    }
    return true;
  }
}
