package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;

public class Pair<First, Second> {
  @SuppressWarnings("unchecked") //
  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int ¢) {
    return new Pair[¢];
  }

  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int i, final int m) {
    return makePairs(i * m);
  }

  @NotNull public static <A, B> Pair<A, B> newPair(final A a, final B b) {
    return new Pair<>(a, b);
  }

  private static boolean eq(final @Nullable Object a, final @Nullable Object o) {
    return a == null ? o == null : a.equals(o);
  }

  public final First first;
  public final Second second;

  public Pair(final First first, final Second second) {
    this.first = first;
    this.second = second;
  }

  @Override public boolean equals(final @Nullable Object ¢) {
    return ¢ == this || ¢ != null && getClass().equals(¢.getClass()) && eq(first, ((Pair<?, ?>) ¢).first) && eq(second, ((Pair<?, ?>) ¢).second);
  }

  @Override public int hashCode() {
    return Utils.hash(second) ^ Utils.hash(first) >>> 1;
  }

  @Override @NotNull public String toString() {
    return "<" + first + "," + second + ">";
  }
  @SuppressWarnings("static-method") public static class TEST {
    private Pair<Integer, Integer> samplePair;
    private Integer first;
    private Integer second;
    
    @Before
    public void beforeFunction(){
      Random r = new Random();
      int nextInt = r.nextInt();
      first = Integer.valueOf(nextInt);
      nextInt = r.nextInt();
      second = Integer.valueOf(nextInt);
      samplePair =  new Pair<>(first, second) ;
    }

    
    @Test public void testSymmetricFunctions() {
      assert samplePair.hashCode() == Pair.newPair(first, second).hashCode();
      assert samplePair.equals(Pair.newPair(first, second));
      assert (samplePair + "").equals(Pair.newPair(first, second) + "");
    }

    @Test  public void testMakePairsInt() {
      assert Pair.makePairs(5).length == 5;
    }

    @Test  public void testMakePairsIntInt() {
      assert Pair.makePairs(5, 5).length == 25;
    }
  }
}
