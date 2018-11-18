package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class asTest {
  @Test public void testAsIterable() {
    int count = 1;
    for (final Integer ¢ : as.asIterable(box(1), box(2), box(3))) {
      assert ¢.equals(box(count));
      ++count;
    }
  }

  @Test public void testAsIterableLambda() {
    int count = 1;
    for (final Integer ¢ : as.asIterableLambda(box(1), box(2), box(3))) {
      assert ¢.equals(box(count));
      ++count;
    }
  }

  @Test public void testBitBoolean() {
    azzert.that(as.bit(true), is(1));
    azzert.that(as.bit(false), is(0));
  }

  @Test public void testBitObject() {
    azzert.that(as.bit(Boolean.TRUE), is(1));
    azzert.that(as.bit(null), is(0));
  }

  @Test public void testIngeterList() {
    azzert.that(as.ingeterList(1, 23, 3, 44, 5).size(), is(5));
  }

  @Test public void testIntArrayIntArray() {
    final int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      azzert.that(¢, is(x[¢]));
  }

  @Test public void testIntArrayListOfInteger() {
    final List<Integer> y = new ArrayList<>();
    for (int ¢ = 0; ¢ < 5; ++¢)
      y.add(box(¢));
    final int[] x = as.intArray(0, 1, 2, 3, 4);
    for (int ¢ = 0; ¢ < 5; ++¢)
      azzert.that(¢, is(x[¢]));
  }

  @Test public void testListIterableOfQextendsT() {
    azzert.that(an.empty.list(), is(as.list(new ArrayList<>())));
  }

  @Test public void testListTArray() {
    final List<Integer> x = as.ingeterList(1, 2, 3);
    assert x.contains(box(1));
    assert x.contains(box(2));
    assert x.contains(box(3));
  }

  @Test public void testSet() {
    azzert.that(as.set(box(1), box(2), box(3)).size(), is(3));
  }

  @Test public void testStringObject() {
    azzert.that(as.string((Object) null), is("null"));
  }

  @Test public void testStringChar() {
    azzert.that(as.string('g'), is("g"));
  }

  @Test public void testStringString() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void testStrings() {
    final List<String> x = new ArrayList<>();
    x.add("Hello");
    x.add("World");
    Assert.assertNotNull(as.strings(x));
  }

  @Test public void testAsIterableEssence() {
    assert box(1).equals(as.iterator(box(1)).next());
  }

  @Test public void testArray() {
    assert as.array(box(1))[0].equals(box(1));
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
    azzert.that(is.get(0), is(box(12)));
    azzert.that(is.get(1), is(box(13)));
    azzert.that(is.get(2), is(box(14)));
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
    final Iterable<Integer> iter1 = as.asIterable(box(1), box(2), box(3), box(4), box(5)),
        iter2 = as.asIterableLambda(box(1), box(2), box(3), box(4), box(5)), iter3 = as.asIterableEssence(box(1), box(2), box(3), box(4), box(5));
    final Iterator<Integer> iter4 = as.iterator(box(1), box(2), box(3), box(4), box(5));
    int j = 1;
    for (final int ¢ : iter1) {
      azzert.that(j, is(¢));
      ++j;
    }
    j = 1;
    for (final int ¢ : iter2) {
      azzert.that(j, is(¢));
      ++j;
    }
    j = 1;
    for (final int ¢ : iter3) {
      azzert.that(j, is(¢));
      ++j;
    }
    j = 1;
    for (; iter4.hasNext(); ++j)
      azzert.that(box(j), is(iter4.next()));
  }

  @Test public void bit() {
    final Object obj = new Object();
    azzert.that(0, is(as.bit(null)));
    azzert.that(1, is(as.bit(obj)));
  }

  @Test public void array() {
    final Integer[] array = as.array(box(1), box(2), box(3));
    azzert.that(array[0], is(1));
    azzert.that(array[1], is(2));
    azzert.that(array[2], is(3));
  }

  @Test public void strings() {
    final String[] stringArray = as.strings(as.list("Hello", "Hi")), stringArray2 = as.strings(null);
    final ArrayList<String> checkNullObject = new ArrayList<>();
    checkNullObject.add("Hello");
    checkNullObject.add(null);
    checkNullObject.add("Hi");
    final String[] stringArray3 = as.strings(checkNullObject);
    azzert.that(stringArray[0], is("Hello"));
    azzert.that(stringArray[1], is("Hi"));
    azzert.that(stringArray2.length, is(0));
    azzert.that(stringArray3[0], is("Hello"));
    azzert.that(stringArray3[1], is("Hi"));
  }

  @Test public void listAndSet() {
    final ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add("Hello");
    stringArrayList.add("Hi");
    final List<String> stringList = as.list(stringArrayList);
    final Set<?> stringSet = as.set("Hello", "Hi");
    assertCollectionsEqual(stringArrayList, stringList);
    azzert.that(stringSet.size(), is(2));
  }

  @Test public void string() {
    final String nullString = as.string(null), helloString = as.string("hello");
    azzert.that("a", is(as.string('a')));
    azzert.that("null", is(nullString));
    azzert.that("hello", is(helloString));
  }
}
