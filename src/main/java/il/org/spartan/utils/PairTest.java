package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

//import il.org.spartan.*;

public class PairTest {
  
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
    assertTrue(samplePair.hashCode() == Pair.newPair(first, second).hashCode());
    assertTrue(samplePair.equals(Pair.newPair(first, second)));
    assertTrue(samplePair.toString().equals(Pair.newPair(first, second).toString()));
  }

  @SuppressWarnings("static-method") @Test public void testMakePairsInt() {
    assertTrue(Pair.makePairs(5).length == 5 );
  }

  @SuppressWarnings("static-method") @Test public void testMakePairsIntInt() {
    assertTrue(Pair.makePairs(5,5).length == 5* 5 );
  }
}
