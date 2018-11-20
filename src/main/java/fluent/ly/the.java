package fluent.ly;

import static fluent.ly.___.*;
import static fluent.ly.idiomatic.*;
import static fluent.ly.unbox.*;

import java.util.*;

import org.jetbrains.annotations.*;

/**
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface the {
  /**
   * Gives the index(position) of an integer inside of the given list of integers
   * @param i integer to be found
   * @param is list of integers to find in
   * @return index of i if found, -1 otherwise
   */
  static int index(final int i, final int... is) {
    for (final Integer $ : range.from(0).to(is.length))
      if (is[unbox($)] == i)
        return unbox($);
    return -1;
  }

  /**
   * A function that returns null
   * @param <T>
   * @return null
   */
  static <@Nullable T> T nil() {
    return null;
  }

  /**
   * Gives the concatenation of an integer and the size of a collection in a new format
   * @param i integer
   * @param os collection of values
   * @return string " #i/(size of os)"
   */
  static String nth(final int i, final Collection<?> os) {
    return the.nth(i, os.size());
  }

  /**
   * Gives the concatenation of two integers in a new format
   * @param i integer
   * @param n integer
   * @return string " #i/n"
   */
  static String nth(final int i, final int n) {
    return nth(i + "", n + "");
  }

  /**
   * Gives the concatenation of two strings in a new format
   * @param s string
   * @param n string
   * @return string " #s/n"
   */
  static String nth(final @NotNull String s, final @NotNull String n) {
    return " #" + s + "/" + n;
  }

  /**
   * Gives the element before last of the list
   * @param <T> some type
   * @param ¢ list of said type
   * @return the element one before last in the list given, null if list has less than 2
   * members or the list is null
   */
  static <T> @Nullable T penultimateOf(final List<T> ¢) {
    return ¢ == null || ¢.size() < 2 ? null : ¢.get(¢.size() - 2);
  }

  /**
   * Gives the element previous to the element selected in the list
   * @param <T> some type
   * @param t element of said type
   * @param ts list of said type
   * @return the element previous to the element given, if there is no previous element, or
   * the list is null, returns null
   */
  static <T> @Nullable T previous(final T t, final List<T> ts) {
    if (ts == null)
      return null;
    final int $ = ts.indexOf(t);
    return $ < 1 ? null : ts.get($ - 1);
  }

  /**
   * Gives the tail of a list, i.e all elements beginning from the second element
   * @param <T> some type
   * @param ¢ list of said type
   * @return list that begins from the second elements of given list
   */
  static <@Nullable T> @NotNull List<T> tailOf(final @Nullable List<T> ¢) {
    final @NotNull List<T> $ = as.list(¢);
    $.remove(the.headOf($));
    return $;
  }

  /**
   * Gives the tail of a string, i.e the string starting from the second character
   * @param ¢ string
   * @return string that begins from the second character of given string
   */
  static String tailOf(final @NotNull String ¢) {
    return ¢.substring(1);
  }

  /**
   * Gives a list with all other elements starting from the first location of an element in
   * a list
   * @param <T> some type
   * @param t element of said type
   * @param ts iterable of said type
   * @return the list of all other elements starting from the first location of the
   * given element
   */
  static <T> List<T> rest(final T t, final Iterable<T> ts) {
    boolean add = false;
    final List<T> $ = an.empty.list();
    for (final T x : ts)
      if (add)
        $.add(x);
      else
        add = x == t;
    return $;
  }

  /**
   * Gives the first element of a list
   * @param <T> some type
   * @param ¢ list of said type
   * @return the first element of given type, and null if the list is empty or null
   */
  @Contract("null -> null") @Nullable static <T> T headOf(final @Nullable List<T> ¢) {
    return ¢ == null || ¢.isEmpty() ? null : ¢.get(0);
  }

  /**
   * Give the last character of a string
   * @param ¢ string
   * @return last character of inputed string
   */
  static char characterOf(final @NotNull String ¢) {
    return the.beforeLastOf(¢, 0);
  }

  /**
   * Gives the character at the requested index in a string
   * @param s string
   * @param i integer
   * @return ith character in the given string
   */
  @Contract(pure = true) static char ith(final @NotNull String s, final int i) {
    return s.charAt(i);
  }

  /**
   * Gives the last element in a list
   * @param <T> some type
   * @param ¢ list of said type
   * @return the last element of a given list, and null if the list is empty, or is null
   */
  @Contract("null -> null") @Nullable static <@Nullable T> T lastOf(final @Nullable List<@Nullable T> ¢) {
    return ¢ == null || ¢.isEmpty() ? null : ¢.get(¢.size() - 1);
  }

  /**
   * Give the last character of a string
   * @param ¢ string
   * @return last character of inputed string
   */
  static char lastOf(final @NotNull String ¢) {
    return beforeLastOf(¢, 0);
  }

  /**
   * Gives a character from the end of the string according to the input 
   * @param s string
   * @param i integer
   * @return the ith character from the end of the given string
   */
  static char beforeLastOf(final @NotNull String s, final int i) {
    return s.charAt(s.length() - i - 1);
  }

  /**
   * Gives the iterator starting from the second element
   * @param <T> some type
   * @param ¢ iterable of said type
   * @return new iterator that starts from the second element of the given iterable's iterator
   */
  @NotNull static <T> Iterable<T> lastOf(final @NotNull Iterable<T> ¢) {
    return () -> new Iterator<>() {
      Iterator<T> $ = ¢.iterator();
      {
        $.next();
      }

      @Override public boolean hasNext() {
        return $.hasNext();
      }

      @Override public T next() {
        return $.next();
      }
    };
  }

  /**
   * Gives the first element of a list only if it is the only element
   * @param <T> some type
   * @param ¢ list of said type
   * @return first element of given list that contains one element, or null otherwise.
   */
  @Nullable static <T> T onlyOneOf(final @Nullable List<T> ¢) {
    return ¢ == null || ¢.size() != 1 ? null : headOf(¢);
  }

  /**
   * Gives the second element of a list
   * @param <T> some type
   * @param ¢ list of said type
   * @return second element of given list or null, if the list has less than 2 elements, or is null
   */
  @Contract("null -> null") @Nullable static <T> T secondOf(final @Nullable List<T> ¢) {
    return ¢ == null || ¢.size() < 2 ? null : ¢.get(1);
  }

  /** Computes the maximum of two or more integers.
   * @param a some integer
   * @param is additional integers
   * @return largest of the parameters */
  static int max(final int a, final int... is) {
    int $ = a;
    for (final int ¢ : is)
      $ = Math.max($, ¢);
    return $;
  }

  /** Computes the minimum of two or more integers
   * @param a some integer
   * @param is additional
   * @return smallest of the parameters */
  static int min(final int a, final int... is) {
    int $ = a;
    for (final int ¢ : is)
      $ = Math.min($, ¢);
    return $;
  }

  /**
   * Gives the last element in an array
   * @param <T> some type
   * @param ¢ array of said type
   * @return last element in the given array
   */
  static <T> T lastOf(final T[] ¢) {
    return ¢[¢.length - 1];
  }

  /** @param <T> JD
   * @param ¢ JD
   * @return last item in a list or <code><b>null</b></code> if the parameter is
   *         <code><b>null</b></code> or empty */
  static <T> @Nullable T last(final List<T> ¢) {
    return eval(() -> ¢.get(¢.size() - 1)).unless(¢ == null || ¢.isEmpty());
  }

  /** Computes the square of a given integer
   * @param ¢ some integer
   * @return square of the parameter */
  static int sqr(final int ¢) {
    return ¢ * ¢;
  }

  /** Chop the first character of a string.
   * @param ¢ a non-<code><b>null</b></code> string of length at least one
   * @return <code>s</code> but without its first character. */
  static String rest(final @NotNull String ¢) {
    nonnull(¢);
    positive(¢.length());
    return ¢.substring(1);
  }

  /**
   * Gives a new array starting from the second element of an array
   * @param <T> some type
   * @param ¢ array of said type
   * @return new array starting from the second element of the given array.
   */
  static <T> T[] tailOf(final T[] ¢) {
    return Arrays.copyOfRange(¢, 1, ¢.length);
  }
}
