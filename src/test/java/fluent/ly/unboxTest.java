package fluent.ly;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  @Test public void testBoolean() {
    final boolean expected = new Random().nextBoolean();
    assert expected == unbox(box(expected));
  }

  @Test public void testBooleanArray() {
    final int len = 100;
    final boolean[] expected = new boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextBoolean();
    assertArrayEquals(expected, unbox(box(expected)));
  }

  @Test public void testByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    assertEquals(arr[0], unbox(box(arr[0])));
  }

  @Test public void testByteArray() {
    final Random random = new Random();
    final byte[] expected = new byte[100];
    random.nextBytes(expected);
    assertArrayEquals(expected, unbox(box(expected)));
  }

  @Test public void testChar() {
    final char expected = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    assertEquals(expected, unbox(box(expected)));
  }

  @Test public void testCharArray() {
    final int len = 100;
    final char[] expected = new char[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
    assertArrayEquals(expected, unbox(box(expected)));
  }

  @Test public void testDouble() {
    final double expected = new Random().nextDouble();
    assertEquals(expected, unbox(box(expected)), 0.0000000001);
  }

  @Test public void testDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextDouble();
    final double[] res = unbox(box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testFloat() {
    final float expected = new Random().nextFloat();
    assertEquals(expected, unbox(box(expected)), 0.0000000001);
  }

  @Test public void testFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextFloat();
    final float[] res = unbox(box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testInt() {
    final int expected = new Random().nextInt();
    assertEquals(expected, unbox(box(expected)));
  }

  @Test public void testIntArray() {
    final int len = 100;
    final int[] expected = new int[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextInt();
    assertArrayEquals(expected, unbox(box(expected)));
  }

  @Test public void testLong() {
    final long expected = new Random().nextLong();
    assertEquals(expected, unbox(box(expected)));
  }

  @Test public void testLongArray() {
    final int len = 100;
    final long[] expected = new long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextLong();
    assertArrayEquals(expected, unbox(box(expected)));
  }

  @Test public void testShort() {
    final short expected = (short) new Random().nextInt(Short.MAX_VALUE + 1);
    assertEquals(expected, unbox(box(expected)));
  }

  @Test public void testShortArray() {
    final int len = 100;
    final short[] expected = new short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
    assertArrayEquals(expected, unbox(box(expected)));
  }
  
  @Test public void testItDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final Double[] tested = new Double[len];
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextDouble();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox.it(tested)));
  }

  @Test public void testItFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final Float[] tested = new Float[len];
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextFloat();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox.it(tested)));
  }

  @Test public void testItInteger() {
    final Integer tested = box(new Random().nextInt());
    azzert.that(tested.intValue(), is(unbox.it(tested)));
  }

  @Test public void testItIntegerArray() {
    final Random random = new Random();
    final int len = 100;
    final Integer[] tested = new Integer[len];
    final int[] expected = new int[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextInt();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox.it(tested)));
  }

  @Test public void testItListOfInteger() {
    final Random random = new Random();
    final int len = 100;
    final List<Integer> tested = new ArrayList<>();
    final int[] expected = new int[len];
    for (int i = 0; i < len; ++i) {
      final Integer num = box(random.nextInt());
      tested.add(num);
      expected[i] = num.intValue();
    }
    azzert.that(expected, is(unbox.it(tested)));
  }

  @Test public void testUnboxBoolean() {
    final Integer tested = box(new Random().nextInt());
    azzert.that(tested.intValue(), is(unbox(tested)));
  }

  @Test public void testUnboxBooleanArray() {
    final Random random = new Random();
    final int len = 100;
    final Boolean[] tested = new Boolean[len];
    final boolean[] expected = new boolean[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextBoolean();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.that(arr[0], is(unbox(box(arr[0]))));
  }

  @Test public void testUnboxByteArray() {
    final Random random = new Random();
    final int len = 100;
    final byte[] arr = new byte[len];
    random.nextBytes(arr);
    final Byte[] tested = new Byte[len];
    final byte[] expected = new byte[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = arr[¢];
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxCharacter() {
    final Character tested = box((char) new Random().nextInt(Character.MAX_VALUE + 1));
    azzert.that(tested.charValue(), is(unbox(tested)));
  }

  @Test public void testUnboxCharacterArray() {
    final Random random = new Random();
    final int len = 100;
    final Character[] tested = new Character[len];
    final char[] expected = new char[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxOrderedCollectionOfShort() {
    final Random random = new Random();
    final int len = 100;
    final Collection<Short> tested = new ArrayList<>();
    final short[] expected = new short[len];
    for (int i = 0; i < len; ++i) {
      final Short num = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
      tested.add(num);
      expected[i] = unbox(num);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxDouble() {
    final Double tested = box(new Random().nextDouble());
    azzert.that(tested.doubleValue(), is(unbox(tested)));
  }

  @Test public void testUnboxDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final Double[] tested = new Double[len];
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextDouble();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxFloat() {
    final Float tested = box(new Random().nextFloat());
    azzert.that(tested.floatValue(), is(unbox(tested)));
  }

  @Test public void testUnboxFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final Float[] tested = new Float[len];
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextFloat();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxInteger() {
    final Integer tested = box(new Random().nextInt());
    azzert.that(tested.intValue(), is(unbox(tested)));
  }

  @Test public void testUnboxIntegerArray() {
    final Random random = new Random();
    final int len = 100;
    final Integer[] tested = new Integer[len];
    final int[] expected = new int[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextInt();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxLong() {
    final Long tested = box(new Random().nextLong());
    azzert.that(tested.longValue(), is(unbox(tested)));
  }

  @Test public void testUnboxLongArray() {
    final Random random = new Random();
    final int len = 100;
    final Long[] tested = new Long[len];
    final long[] expected = new long[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextLong();
      tested[¢] = box(expected[¢]);
    }
    azzert.that(expected, is(unbox(tested)));
  }

  @Test public void testUnboxShort() {
    final Short tested = Short.valueOf((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.that(tested.shortValue(), is(unbox(tested)));
  }

  @Test public void testUnboxShortArray() {
    final Random random = new Random();
    final int len = 100;
    final Short[] tested = new Short[len];
    final short[] expected = new short[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
      expected[¢] = tested[¢].shortValue();
    }
    azzert.that(expected, is(unbox(tested)));
  }
}
