package fluent.ly;

import static fluent.ly.azzert.*;
import java.util.*;
import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "static-access", "null" }) public class asTest {
  @Test public void testAsIterable() {
    int count = 1;
    for (Iterator<Integer> ¢ = as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)).iterator(); ¢.hasNext();) {
      assert ¢.next().equals(Integer.valueOf(count));
      ++count;
    }
  }

  @Test public void testAsIterableLambda() {
    int count = 1;
    for (Iterator<Integer> ¢ = as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)).iterator(); ¢.hasNext();) {
      assert ¢.next().equals(Integer.valueOf(count));
      ++count;
    }
  }

  @Test public void testBitBoolean() {
    azzert.assertEquals(as.bit(true), 1);
    azzert.assertEquals(as.bit(false), 0);
  }

  @Test public void testBitObject() {
    azzert.assertEquals(as.bit(Boolean.TRUE), 1);
    azzert.assertEquals(as.bit(null), 0);
  }

  @Test public void testIngeterList() {
    azzert.assertEquals(as.ingeterList(1, 23, 3, 44, 5).size(), 5);
  }

  @Test public void testIntArrayIntArray() {
    int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      azzert.assertEquals(¢, x[¢]);
  }

  @Test public void testIntArrayListOfInteger() {
    List<Integer> y = new ArrayList<>();
    for (int ¢ = 0; ¢ < 5; ++¢)
      y.add(Integer.valueOf(¢));
    int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      azzert.assertEquals(¢, x[¢]);
  }

  @Test public void testListIterableOfQextendsT() {
    azzert.assertEquals(an.empty.list(), as.list(new ArrayList<>()));
  }

  @Test public void testListTArray() {
    List<Integer> x = as.ingeterList(1, 2, 3);
    assert x.contains(Integer.valueOf(1));
    assert x.contains(Integer.valueOf(2));
    assert x.contains(Integer.valueOf(3));
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void testSet() {
    Set<? extends Integer> x = as.set(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    x.contains(Integer.valueOf(1));
    assert x.contains(Integer.valueOf(2));
    assert x.contains(Integer.valueOf(3));
  }

  @Test public void testStringObject() {
    azzert.assertEquals(as.string((Object) null), "null");
  }

  @Test public void testStringChar() {
    azzert.assertEquals(as.string('g'), "g");
  }

  @Test public void testStringString() {
    azzert.assertEquals(as.string(null), "null");
  }

  @Test public void testStrings() {
    List<String> x = new ArrayList<>();
    x.add("Hello");
    x.add("World");
    azzert.assertNotNull(as.strings(x));
  }

  @Test public void testAsIterableEssence() {
    assert Integer.valueOf(1).equals(as.iterator(Integer.valueOf(1)).next());
  }

  @Test public void testArray() {
    assert as.array(Integer.valueOf(1))[0].equals(Integer.valueOf(1));
  }

  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }

  @Test public void asIterable() {
    Iterable<Integer> iter1 = as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)),
        iter2 = as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)),
        iter3 = as.asIterableEssence(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
    Iterator<Integer> iter4 = as.iterator(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
    int j = 1;
    for (int ¢ : iter1) {
      azzert.assertEquals(j, ¢);
      ++j;
    }
    j = 1;
    for (int ¢ : iter2) {
      azzert.assertEquals(j, ¢);
      ++j;
    }
    j = 1;
    for (int ¢ : iter3) {
      azzert.assertEquals(j, ¢);
      ++j;
    }
    j = 1;
    for (; iter4.hasNext(); ++j)
      azzert.assertEquals(j, iter4.next());
  }

  @Test public void bit() {
    Object obj = new Object();
    azzert.assertEquals(0, as.bit(null));
    azzert.assertEquals(1, as.bit(obj));
  }

  @Test public void array() {
    Integer[] array = as.array(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    azzert.assertEquals(array[0], 1);
    azzert.assertEquals(array[1], 2);
    azzert.assertEquals(array[2], 3);
  }

  @Test public void strings() {
    String[] stringArray = as.strings(as.list("Hello", "Hi")), stringArray2 = as.strings(null);
    ArrayList<String> checkNullObject = new ArrayList<>();
    checkNullObject.add("Hello");
    checkNullObject.add(null);
    checkNullObject.add("Hi");
    String[] stringArray3 = as.strings(checkNullObject);
    azzert.assertEquals(stringArray[0], "Hello");
    azzert.assertEquals(stringArray[1], "Hi");
    azzert.assertEquals(0, stringArray2.length);
    azzert.assertEquals(stringArray3[0], "Hello");
    azzert.assertEquals(stringArray3[1], "Hi");
  }

  @Test public void listAndSet() {
    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add("Hello");
    stringArrayList.add("Hi");
    List<String> stringList = as.list(stringArrayList);
    Set<?> stringSet = as.set("Hello", "Hi");
    assertCollectionsEqual(stringArrayList, stringList);
    azzert.assertEquals(stringSet.size(), 2);
  }

  @Test public void string() {
    String nullString = as.string(null), helloString = as.string("hello");
    azzert.assertEquals("a", as.string('a'));
    azzert.assertEquals("null", nullString);
    azzert.assertEquals("hello", helloString);
  }
}
