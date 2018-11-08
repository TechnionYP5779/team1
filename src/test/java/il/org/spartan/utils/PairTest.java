package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

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
    azzert.assertTrue(samplePair.hashCode() == Pair.newPair(first, second).hashCode());
    azzert.assertTrue(samplePair.equals(Pair.newPair(first, second)));
    azzert.assertTrue((samplePair + "").equals(Pair.newPair(first, second) + ""));
  }

  @Test public void testMakePairsInt() {
    azzert.assertTrue(Pair.makePairs(5).length == 5);
  }

  @Test public void testMakePairsIntInt() {
    azzert.assertTrue(Pair.makePairs(5, 5).length == 25);
  }
}