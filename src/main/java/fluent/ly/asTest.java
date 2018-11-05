package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class asTest {
  @SuppressWarnings({ "static-method", "null" }) @Test public void testAsIterable() {
    int count =1;
    for (Iterator<Integer> iterator = as.asIterable(Integer.valueOf(1),Integer.valueOf(2),
        Integer.valueOf(3)).iterator(); iterator.hasNext();) {
      assertTrue(iterator.next().equals(Integer.valueOf(count)));
      count ++;
    }
  }

  @SuppressWarnings({ "static-method", "boxing" }) @Test public void testAsIterableLambda() {
    int count =1;
    for (Iterator<Integer> iterator = as.asIterableLambda(1,2,3).iterator(); iterator.hasNext();) {
      assertTrue(iterator.next().equals(count));
      count ++;
    }
  }

  @SuppressWarnings("static-method") @Test public void testBitBoolean() {
    assertEquals(as.bit(true), 1);
    assertEquals(as.bit(false),0);
  }

  @SuppressWarnings("static-method") @Test public void testBitObject() {
    assertEquals(as.bit( Boolean.valueOf(true)), 1);
    assertEquals(as.bit(null),0);
  }

  @SuppressWarnings("static-method") @Test public void testIngeterList() {
    assertEquals(as.ingeterList(1,23,3,44,5).size(),5);
  }

  @SuppressWarnings("static-method") @Test public void testIntArrayIntArray() {
    int[] x= as.intArray(0,1,2,3,4);
    for (int i=0; i<5; i++) {
       assertEquals(i,x[i]);
    }
  }

  @SuppressWarnings("static-method") @Test public void testIntArrayListOfInteger() {
    List<Integer > y = new ArrayList<>();
    for (int i=0; i<5; i++) {
      y.add(Integer.valueOf(i));
   }
    int[] x= as.intArray(0,1,2,3,4);
    for (int i=0; i<5; i++) {
       assertEquals(i,x[i]);
    }
  }


  @SuppressWarnings("static-method") @Test public void testListIterableOfQextendsT() {
    List<Object> x = new ArrayList<> ();
    assertEquals( an.empty.list(), as.list(x));
  }

  @SuppressWarnings("static-method") @Test public void testListTArray() {
    List<Integer> x = as.list(1,2,3);
    assertTrue(x.contains(Integer.valueOf(1)));
    assertTrue(x.contains(Integer.valueOf(2)));
    assertTrue(x.contains(Integer.valueOf(3)));
    
  }

  @SuppressWarnings({ "static-method", "unlikely-arg-type" }) @Test public void testSet() {
    Set<? extends Integer> x = as.set(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3));
    assertTrue(x.contains(Integer.valueOf(1)));
    assertTrue(x.contains(Integer.valueOf(2)));
    assertTrue(x.contains(Integer.valueOf(3)));
    
  }

  @SuppressWarnings("static-method") @Test public void testStringObject() {
    assertEquals(as.string((Object)null), "null");
  }

  @SuppressWarnings("static-method") @Test public void testStringChar() {
    assertEquals(as.string('g'),"" );
  }

  @SuppressWarnings("static-method") @Test public void testStringString() {
    assertEquals(as.string(null), "null");
  }

  @SuppressWarnings("static-method") @Test public void testStrings() {
    List<String > x= new ArrayList<>();
    x.add("Hello");
    x.add("World");
    assertNotNull(as.strings(x));
  }

  @SuppressWarnings("static-method") @Test public void testAsIterableEssence() {
    Iterator<Integer> x = as.iterator(Integer.valueOf(1));
    assertTrue(Integer.valueOf(1).equals(x.next()));
  }

  @SuppressWarnings("static-method") @Test public void testArray() {
    assertTrue(as.array(Integer.valueOf(1))[0].equals(Integer.valueOf(1)));
  }
}
