/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static org.junit.Assert.*;
import static org.junit.Assert.azzert.assertEquals;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;

/** A collection of <code><b>static</b></code> functions for converting from one
 * aggregate type to another.
 * @author Yossi Gil
 * @since Jul 8, 2014 */
@SuppressWarnings("null") public enum as {
  ;
  /** Convert an array of {@link Integer}s into an {@link Iterable}. For example,
   * to print the first Fibonacci numbers multiplied by the first prime numbers,
   * write:
   *
   * <pre>
   * for (Integer f: asIterable(1,1,2,3,5,8,13)
   *    for (Integer p: asIterable(2,3,5,7,11,13)
   *       System.out.println(f*p)
   * </pre>
   *
   * @param is what to iterate on (recall that a list of arguments of the same
   *           type is isomorphic to array parameters in Java
   * @return an {@link Iterable} over the array, which can then be used to to
   *         iterate over the parameter(s) */
  @SuppressWarnings("unused") public static Iterable<Integer> asIterable(final @NotNull Integer... is) {
    // Create an object of a new <em>anonymous</em> class that
    // <code><b>implements</b></code> {@link Iterable}
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  @SuppressWarnings("unused") public static Iterable<Integer> asIterableLambda(final @NotNull Integer... is) {
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  /** Converts a boolean into a bit value
   * @param $ some boolean value
   * @return 1 if the parameter is true, 0 otherwise */
  public static int bit(final boolean $) {
    return $ ? 1 : 0;
  }

  /** C like conversion of a reference to an {@link Object} into a 0/1 bit.
   * @param ¢ some object
   * @return <code>0</code> if the parameter is <code><b>null</b></code>.
   *         <code>1</code> otherwise.
   * @see as#bit(Object) */
  public static int bit(final @Nullable Object ¢) {
    return ¢ == null ? 0 : 1;
  }

  @NotNull public static List<Integer> ingeterList(final int... is) {
    final @NotNull List<Integer> $ = new ArrayList<>();
    for (final int ¢ : is)
      $.add(fluent.ly.box.it(¢));
    return $;
  }

  /** Converts a sequence of integer values into an array.
   * @param $ some sequence of values of the type parameter
   * @return parameters, organized as an array with entries whose type is the type
   *         parameter */
  public static int @NotNull [] intArray(final int... $) {
    return $;
  }

  /** Return a compact representation of a list of {@link Integer}s as an array of
   * type <code><b>int</b></code>.
   * @param is the list to be converted, none of the elements in it can be
   *           <code><b>null</b></code>
   * @return an array of <code><b>int</b></code>. representing the input. */
  public static int @NotNull [] intArray(final @NotNull List<Integer> is) {
    final int @NotNull [] $ = new int @NotNull [is.size()];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = is.get(¢).intValue();
    return $;
  }

  /** Creates an iterable for an array of objects
   * @param   <T> an arbitrary type
   * @param ¢ what to iterate on
   * @return an {@link Iterable} over the parameter */
  @SafeVarargs public static <T> Iterator<T> iterator(final T... ¢) {
    return as.list(¢).iterator();
  }

  /** Converts a list of <code><b>int</b></code>s into a {@link List} of
   * {@link Integer}s
   * @param ¢ what to convert
   * @return a {@link List} of of all <code><b>int</b></code>s in the parameter */
  public static List<Integer> list(final int... ¢) {
    return as.list(box.it(¢));
  }

  /** Converts an {@link Iterable} of a given type into a {@link List} of values
   * of this type.
   * @param   <T> type of items to be converted
   * @param $ what to convert
   * @return parameter, converted to the {@link List} of the given type */
  public static <T> @NotNull List<T> list(final @Nullable Iterable<? extends T> $) {
    return $ == null ? an.empty.list() : accumulate.to(new ArrayList<T>()).add($).elements();
  }

  /** Converts a sequence of objects of some common type T into a {@link List} of
   * values
   * @param   <T> type of objects to be converted
   * @param $ what to covert
   * @return result parameter, converted into a {@link List} */
  @SafeVarargs public static <T> @NotNull List<T> list(final T... $) {
    return accumulate.to(new ArrayList<@Nullable T>()).add($).elements();
  }

  /** Converts a sequence of objects of a given type into a {@link Set} of values
   * @param   <T> type of objects to be converted
   * @param ¢ what to covert
   * @return parameter, converted into a {@link Set} */
  @SafeVarargs public static <T> Set<? extends T> set(final @Nullable T... ¢) {
    return accumulate.to(new HashSet<T>()).add(¢).elements();
  }

  @NotNull public static String string(final @Nullable Object $) {
    return $ == null ? "null" : as.string($ + "");
  }

  @NotNull public static String string(final char $) {
    return $ + "";
  }

  @NotNull public static String string(final @Nullable String $) {
    return $ != null ? $ : "null";
  }

  /** Converts an {@link Iterable} into an array of {@link String}.
   * @param os what to covert
   * @return an array of the parameter values, each converted to i
   *         {@link String} */
  public static String @NotNull [] strings(final @Nullable Iterable<? extends @Nullable Object> os) {
    final @NotNull List<@NotNull String> $ = new ArrayList<>();
    if (os != null)
      for (final @Nullable Object ¢ : os)
        if (¢ != null)
          $.add(¢ + "");
    return Utils.cantBeNull($.toArray(new String @NotNull [$.size()]));
  }

  @SuppressWarnings("unused") static Iterable<Integer> asIterableEssence(final @NotNull Integer... is) {
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  // No values in an 'enum' which serves as a name space for a collection of
  // 'static' functions.
  /** A static nested class hosting unit tests for the nesting class Unit test for
   * the containing class. Note the naming convention: a) names of test methods do
   * not use are not prefixed by "test". This prefix is redundant. b) test methods
   * begin with the name of the method they check.
   * @author Yossi Gil
   * @since 2014-05-31 */
  @SuppressWarnings("static-method") public static class TEST {
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

    @Test  public void testIntArrayListOfInteger() {
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

    @Test @SuppressWarnings({ "unlikely-arg-type" }) public void testSet() {
      Set<? extends Integer> x = as.set(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
      assert x.contains(Integer.valueOf(1));
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
      assertNotNull(as.strings(x));
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
      Iterator<Integer> iter4 = as.iterator(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3),Integer.valueOf(4),Integer.valueOf(5));
      int j = 1;
      for(int ¢ : iter1) {
        azzert.assertEquals(j, ¢);
        ++j;
      }
      j = 1;
      for(int ¢ : iter2) {
        azzert.assertEquals(j, ¢);
        ++j;
      }
      j = 1;
      for(int ¢ : iter3) {
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
      Integer[] array = as.array(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3));
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

  /** Converts a sequence of values into an array.
   * @param   <T> some arbitrary type
   * @param $ some sequence of values of the type parameter
   * @return parameter, organized as an array with entries whose type is the type
   *         parameter */
  @SafeVarargs public static <T> T[] array(final T... $) {
    return $;
  }
}