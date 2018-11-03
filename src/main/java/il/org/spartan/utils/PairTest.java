package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import il.org.spartan.classfiles.reify.ConstantPool.*;

public class PairTest {
  
  private Pair<Integer, Integer> samplePair;
  private Integer first;
  private Integer second;
  
  @Before
  public void beforeFunction(){
    Random r = new Random();
    first = r.nextInt();
    second = r.nextInt();
    samplePair =  new Pair<>(first, second) ;
  }

  
  @Test public void testHashCode() {
    assertTrue(samplePair.hashCode() == (first.hashCode() ^ second.hashCode() >>> 1));
  }

  @Test public void testMakePairsInt() {
    assertTrue(Pair.makePairs(first).length == first );
  }

  @Test public void testMakePairsIntInt() {
    assertTrue(Pair.makePairs(first,second).length == first* second );
  }

  @Test public void testNewPair() {
    fail("Not yet implemented");
  }

  @Test public void testPair() {
    fail("Not yet implemented");
  }

  @Test public void testEqualsObject() {
    fail("Not yet implemented");
  }

  @Test public void testToString() {
    fail("Not yet implemented");
  }
}
