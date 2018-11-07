package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A utility class, offering a collection of function to unbox arrays and
 * collection of the boxed versions of the primitive types. The input of each
 * unboxing function is a {@link Collection} or an array of one the following
 * eight reference types
 * <ol>
 * <li>{@link Boolean}
 * <li>{@link Byte}
 * <li>{@link Character}
 * <li>{@link Double}
 * <li>{@link Float}
 * <li>{@link Integer}
 * <li>{@link Long}
 * <li>{@link Short}
 * </ol>
 * The returned value is an array of the equivalent primitive type.
 * <p>
 * Note that unboxing of a single value of a reference type is easy using a
 * function such as {@link Long#longValue()}
 * @author Yossi Gil.
 * @see box */
@SuppressWarnings("null") public enum unbox {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  public static double @NotNull [] it(final @NotNull Double[] ¢) {
    return unbox(¢);
  }

  public static float @NotNull [] it(Float[] ¢) {
    return unbox(¢);
  }

  public static int it(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  public static int @NotNull [] it(final @NotNull Integer[] ¢) {
    return unbox(¢);
  }

  public static int @NotNull [] it(final @NotNull List<Integer> ¢) {
    return it(¢.toArray(new Integer[¢.size()]));
  }

  public static boolean unbox(final @NotNull Boolean ¢) {
    return ¢.booleanValue();
  }

  /** unbox an array of {@link Boolean}s into an array of
   * <code><b>boolean</b></code>s.
   * @param bs an array of {@link Boolean}s
   * @return an equivalent array of <code><b>boolean</b></code>s. */
  public static boolean @NotNull [] unbox(final @NotNull Boolean[] bs) {
    final boolean @NotNull [] $ = new boolean[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].booleanValue();
    return $;
  }

  public static byte unbox(final @NotNull Byte ¢) {
    return ¢.byteValue();
  }

  /** unbox an array of {@link Byte}s into an array of <code><b>byte</b></code> s.
   * @param bs an array of {@link Byte}s
   * @return an equivalent array of <code><b>byte</b></code>s. */
  public static byte @NotNull [] unbox(final @NotNull Byte[] bs) {
    final byte @NotNull [] $ = new byte[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].byteValue();
    return $;
  }

  public static char unbox(final @NotNull Character ¢) {
    return ¢.charValue();
  }

  /** unbox an array of {@link Character}s into an array of
   * <code><b>char</b></code>s.
   * @param cs an array of {@link Character}s
   * @return an equivalent array of <code><b>char</b></code>s. */
  public static char @NotNull [] unbox(final @NotNull Character[] cs) {
    final char @NotNull [] $ = new char[cs.length];
    for (int ¢ = 0; ¢ < cs.length; ++¢)
      $[¢] = cs[¢].charValue();
    return $;
  }

  /** unbox a {@link Collection} of {@link Short}s into an array of
   * <code><b>short</b></code>s.
   * @param ss a {@link Collection} of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unbox(final @NotNull Collection<Short> ss) {
    final short @NotNull [] $ = new short[ss.size()];
    int i = 0;
    for (final @NotNull Short v : ss)
      $[i++] = v.shortValue();
    return $;
  }

  public static double unbox(final @NotNull Double ¢) {
    return ¢.doubleValue();
  }

  /** unbox an array of {@link Double}s into an array of
   * <code><b>double</b></code>s.
   * @param ds an array of {@link Double}s
   * @return an equivalent array of <code><b>double</b></code>s. */
  public static double @NotNull [] unbox(final @NotNull Double[] ds) {
    final double @NotNull [] $ = new double[ds.length];
    for (int ¢ = 0; ¢ < ds.length; ++¢)
      $[¢] = ds[¢].doubleValue();
    return $;
  }

  public static float unbox(final @NotNull Float ¢) {
    return ¢.floatValue();
  }

  /** unbox an array of {@link Float}s into an array of <code><b>float</b></code>
   * s.
   * @param fs an array of {@link Float}s
   * @return an equivalent array of <code><b>float</b></code>s. */
  public static float @NotNull [] unbox(final Float[] fs) {
    final float @NotNull [] $ = new float[fs.length];
    for (int ¢ = 0; ¢ < fs.length; ++¢)
      $[¢] = fs[¢].floatValue();
    return $;
  }

  public static int unbox(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  /** unbox an array of {@link Integer}s into an array of <code><b>int</b></code>
   * s.
   * @param is an array of {@link Integer}s
   * @return an equivalent array of <code><b>int</b></code>s. */
  public static int @NotNull [] unbox(final @NotNull Integer[] is) {
    final int @NotNull [] $ = new int[is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = is[¢].intValue();
    return $;
  }

  public static long unbox(final @NotNull Long ¢) {
    return ¢.longValue();
  }

  /** unbox an array of {@link Long}s into an array of <code><b>long</b></code> s.
   * @param ls an array of {@link Long}s
   * @return an equivalent array of <code><b>long</b></code>s. */
  public static long @NotNull [] unbox(final @NotNull Long[] ls) {
    final long @NotNull [] $ = new long[ls.length];
    for (int ¢ = 0; ¢ < ls.length; ++¢)
      $[¢] = ls[¢].longValue();
    return $;
  }

  public static short unbox(final @NotNull Short ¢) {
    return ¢.shortValue();
  }

  /** unbox an array of {@link Short}s into an array of <code><b>short</b></code>
   * s.
   * @param ss an array of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unbox(final @NotNull Short[] ss) {
    final short @NotNull [] $ = new short[ss.length];
    for (int ¢ = 0; ¢ < ss.length; ++¢)
      $[¢] = ss[¢].shortValue();
    return $;
  }
  
  @SuppressWarnings({"boxing","static-method","static-access"}) public static class TEST {
    @Test public void testItDoubleArray() {
      Random random = new Random();
      int len = 100;
      Double[] tested = new Double[len];
      double[] expected = new double[len];
      for (int ¢ = 0; ¢ < len; ++¢)
        expected[¢] = tested[¢] = random.nextDouble();
      double[] res = unbox.it(tested);
      for (int ¢ = 0; ¢ < len; ++¢)
        azzert.assertEquals(expected[¢], res[¢], 0.0000000001);
    }

    @Test public void testItFloatArray() {
      Random random = new Random();
      int len = 100;
      Float[] tested = new Float[len];
      float[] expected = new float[len];
      for (int ¢ = 0; ¢ < len; ++¢)
        expected[¢] = tested[¢] = random.nextFloat();
      float[] res = unbox.it(tested);
      float epsilon = (float) 0.0000001;
      for (int ¢ = 0; ¢ < len; ++¢)
        azzert.assertEquals(expected[¢], res[¢], epsilon);
    }

    @Test public void testItInteger() {
      Integer tested = new Random().nextInt();
      azzert.assertEquals((int)tested, unbox.it(tested));
    }

    @Test public void testItIntegerArray() {
      Random random = new Random();
      int len = 100;
      Integer[] tested = new Integer[len];
      int[] expected = new int[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextInt();
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.it(tested));
    }

    @Test public void testItListOfInteger() {
      Random random = new Random();
      int len = 100;
      List<Integer> tested = new ArrayList<>();
      int[] expected = new int[len];
      for (int i = 0; i < len; ++i) {
        Integer num = random.nextInt();
        tested.add(num);
        expected[i] = num;
      }
      azzert.assertArrayEquals(expected, unbox.it(tested));
    }

    @Test public void testUnboxBoolean() {
      Integer tested = new Random().nextInt();
      azzert.assertEquals((int)tested, unbox.unbox(tested));
    }

    @Test public void testUnboxBooleanArray() {
      Random random = new Random();
      int len = 100;
      Boolean[] tested = new Boolean[len];
      boolean[] expected = new boolean[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextBoolean();
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxByte() {
      Random random = new Random();
      byte[] arr = new byte[1];
      random.nextBytes(arr);
      azzert.assertEquals(arr[0], unbox.unbox(arr[0]));
    }

    @Test public void testUnboxByteArray() {
      Random random = new Random();
      int len = 100;
      byte[] arr = new byte[len];
      random.nextBytes(arr);
      Byte[] tested = new Byte[len];
      byte[] expected = new byte[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = arr[¢];
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxCharacter() {
      Character tested = ((char) new Random().nextInt(Character.MAX_VALUE + 1));
      azzert.assertEquals((int)tested, unbox.unbox(tested));
    }

    @Test public void testUnboxCharacterArray() {
      Random random = new Random();
      int len = 100;
      Character[] tested = new Character[len];
      char[] expected = new char[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = ((char) random.nextInt(Character.MAX_VALUE + 1));
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxOrderedCollectionOfShort() {
      Random random = new Random();
      int len = 100;
      Collection<Short> tested = new ArrayList<>();
      short[] expected = new short[len];
      for (int i = 0; i < len; ++i) {
        Short num = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
        tested.add(num);
        expected[i] = num;
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxDouble() {
      Double tested = new Random().nextDouble();
      azzert.assertEquals(tested, unbox.unbox(tested), 0.0000000001);
    }

    @Test public void testUnboxDoubleArray() {
      Random random = new Random();
      int len = 100;
      Double[] tested = new Double[len];
      double[] expected = new double[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextDouble();
        expected[¢] = tested[¢];
      }
      double[] res = unbox.unbox(tested);
      for (int ¢ = 0; ¢ < len; ++¢)
        azzert.assertEquals(expected[¢], res[¢], 0.0000000001);
    }

    @Test public void testUnboxFloat() {
      Float tested = new Random().nextFloat();
      azzert.assertEquals(tested, unbox.unbox(tested), (float) 0.0000001);
    }

    @Test public void testUnboxFloatArray() {
      Random random = new Random();
      int len = 100;
      Float[] tested = new Float[len];
      float[] expected = new float[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextFloat();
        expected[¢] = tested[¢];
      }
      float[] res = unbox.unbox(tested);
      float epsilon = (float) 0.0000001;
      for (int ¢ = 0; ¢ < len; ++¢)
        azzert.assertEquals(expected[¢], res[¢], epsilon);
    }

    @Test public void testUnboxInteger() {
      Integer tested = new Random().nextInt();
      azzert.assertEquals((int)tested, unbox.unbox(tested));
    }

    @Test public void testUnboxIntegerArray() {
      Random random = new Random();
      int len = 100;
      Integer[] tested = new Integer[len];
      int[] expected = new int[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextInt();
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxLong() {
      Long tested = new Random().nextLong();
      azzert.assertEquals((long)tested, unbox.unbox(tested));
    }

    @Test public void testUnboxLongArray() {
      Random random = new Random();
      int len = 100;
      Long[] tested = new Long[len];
      long[] expected = new long[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = random.nextLong();
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }

    @Test public void testUnboxShort() {
      Short tested = Short.valueOf((short) new Random().nextInt(Short.MAX_VALUE + 1));
      azzert.assertEquals((short)tested, unbox.unbox(tested));
    }

    @Test public void testUnboxShortArray() {
      Random random = new Random();
      int len = 100;
      Short[] tested = new Short[len];
      short[] expected = new short[len];
      for (int ¢ = 0; ¢ < len; ++¢) {
        tested[¢] = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
        expected[¢] = tested[¢];
      }
      azzert.assertArrayEquals(expected, unbox.unbox(tested));
    }
  }
}
