package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class asTest {
  @Test @SuppressWarnings({ "static-method", "null" }) public void testAsIterable() {
    int count = 1;
    for (Iterator<Integer> ¢ = as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)).iterator(); ¢.hasNext();) {
      assert ¢.next().equals(Integer.valueOf(count));
      ++count;
    }
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testAsIterableLambda() {
    int count = 1;
    for (Iterator<Integer> ¢ = as.asIterableLambda(1, 2, 3).iterator(); ¢.hasNext();) {
      assert ¢.next().equals(count);
      ++count;
    }
  }

  @Test @SuppressWarnings("static-method") public void testBitBoolean() {
    assertEquals(as.bit(true), 1);
    assertEquals(as.bit(false), 0);
  }

  @Test @SuppressWarnings("static-method") public void testBitObject() {
    assertEquals(as.bit(Boolean.TRUE), 1);
    assertEquals(as.bit(null), 0);
  }

  @Test @SuppressWarnings("static-method") public void testIngeterList() {
    assertEquals(as.ingeterList(1, 23, 3, 44, 5).size(), 5);
  }

  @Test @SuppressWarnings("static-method") public void testIntArrayIntArray() {
    int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      assertEquals(¢, x[¢]);
  }

  @Test @SuppressWarnings("static-method") public void testIntArrayListOfInteger() {
    List<Integer> y = new ArrayList<>();
    for (int ¢ = 0; ¢ < 5; ++¢)
      y.add(Integer.valueOf(¢));
    int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      assertEquals(¢, x[¢]);
  }


  @Test @SuppressWarnings("static-method") public void testListIterableOfQextendsT() {
    assertEquals(an.empty.list(), as.list(new ArrayList<>()));
  }

  @Test @SuppressWarnings("static-method") public void testListTArray() {
    List<Integer> x = as.ingeterList(1, 2, 3);
    assert x.contains(Integer.valueOf(1));
    assert x.contains(Integer.valueOf(2));
    assert x.contains(Integer.valueOf(3));
  }

  @Test @SuppressWarnings({ "static-method", "unlikely-arg-type" }) public void testSet() {
    Set<? extends Integer> x = as.set(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    assert x.contains(Integer.valueOf(1));
    assert x.contains(Integer.valueOf(2));
    assert x.contains(Integer.valueOf(3));
  }

  @Test @SuppressWarnings("static-method") public void testStringObject() {
    assertEquals(as.string((Object) null), "null");
  }

  @Test @SuppressWarnings("static-method") public void testStringChar() {
    assertEquals(as.string('g'), "g");
  }

  @Test @SuppressWarnings("static-method") public void testStringString() {
    assertEquals(as.string(null), "null");
  }

  @Test @SuppressWarnings("static-method") public void testStrings() {
    List<String> x = new ArrayList<>();
    x.add("Hello");
    x.add("World");
    assertNotNull(as.strings(x));
  }

  @Test @SuppressWarnings("static-method") public void testAsIterableEssence() {
    assert Integer.valueOf(1).equals(as.iterator(Integer.valueOf(1)).next());
  }

  @Test @SuppressWarnings("static-method") public void testArray() {
    assert as.array(Integer.valueOf(1))[0].equals(Integer.valueOf(1));
  }
}
