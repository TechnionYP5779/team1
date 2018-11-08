package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class PairTest {
  private Pair<Integer, Integer> samplePair;
  private Integer first;
  private Integer second;

  @Before public void beforeFunction() {
    Random r = new Random();
    int nextInt = r.nextInt();
    first = Integer.valueOf(nextInt);
    nextInt = r.nextInt();
    second = Integer.valueOf(nextInt);
    samplePair = new Pair<>(first, second);
  }

  @Test public void testSymmetricFunctions() {
    assert samplePair.hashCode() == Pair.newPair(first, second).hashCode();
    assert samplePair.equals(Pair.newPair(first, second));
    assert (samplePair + "").equals(Pair.newPair(first, second) + "");
  }

  @Test public void testMakePairsInt() {
    assert Pair.makePairs(5).length == 5;
  }

  @Test public void testMakePairsIntInt() {
    assert Pair.makePairs(5, 5).length == 25;
  }
}