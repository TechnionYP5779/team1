package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/**
 * 
 * @author Matan
 *
 * @param <First> - The Pair's first type.
 * @param <Second>- The Pair's second type.
 */
@SuppressWarnings("unchecked") public class Pair<First, Second> {
  
  /**
   * makePairs(¢) 
   * @param <First>
   * @param <Second>
   * @param ¢ - an integer
   * @return given an integer value ¢, creates a new Pair array in the size of ¢.
   */
  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int ¢) {
    return new Pair[¢];
  }
  
  /**
   * makePairs(i,m) 
   * @param <First>
   * @param <Second>
   * @param i - an integer
   * @param m - an integer
   * @return given the integer values i,m, creates a new Pair array in the size of i*m.
   */
  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int i, final int m) {
    return makePairs(i * m);
  }

  /**
   * newPair(a,b)
   * @param <A>
   * @param <B>
   * @param a - of type A
   * @param b - of type B
   * @return given the values a,b, creates a new Pair containing a,b.
   */
  @NotNull public static <A, B> Pair<A, B> newPair(final A a, final B b) {
    return new Pair<>(a, b);
  }

  /**
   * eq(a,o) 
   * @param a - an object
   * @param o - an object
   * @return true iff a equals o.
   */
  private static boolean eq(final @Nullable Object a, final @Nullable Object o) {
    return a == null ? o == null : a.equals(o);
  }

  public final First first;
  public final Second second;

  /**
   * Pair(first,second) - creates a pair of first,second.
   * @param first - of type First
   * @param second - of type Second
   */
  public Pair(final First first, final Second second) {
    this.first = first;
    this.second = second;
  }

  /**
   * equals(¢)
   * @param ¢
   * @return true iff the object referenced by this equals to ¢
   */
  @Override public boolean equals(final @Nullable Object ¢) {
    return ¢ == this || ¢ != null && getClass().equals(¢.getClass()) && eq(first, ((Pair<?, ?>) ¢).first) && eq(second, ((Pair<?, ?>) ¢).second);
  }

  /**
   * hashCode()
   * @return the objects hash code.
   */
  @Override public int hashCode() {
    return Utils.hash(second) ^ Utils.hash(first) >>> 1;
  }

  /**
   * toString() 
   * @return - the object's string representation.
   */
  @Override @NotNull public String toString() {
    return "<" + first + "," + second + ">";
  }
}
