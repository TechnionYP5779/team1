package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  @Test public void testItDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final Double[] tested = new Double[len];
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextDouble();
      tested[¢] = box.box(expected[¢]);
    }
    final double[] res = unbox.it(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testItFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final Float[] tested = new Float[len];
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextFloat();
      tested[¢] = box.box(expected[¢]);
    }
    final float[] res = unbox.it(tested);
    final float epsilon = (float) 0.0000001;
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], epsilon);
  }

  @Test public void testItInteger() {
    final Integer tested = box.box(new Random().nextInt());
    azzert.assertEquals(tested.intValue(), unbox.it(tested));
  }

  @Test public void testItIntegerArray() {
    final Random random = new Random();
    final int len = 100;
    final Integer[] tested = new Integer[len];
    final int[] expected = new int[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextInt();
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.it(tested));
  }

  @Test public void testItListOfInteger() {
    final Random random = new Random();
    final int len = 100;
    final List<Integer> tested = new ArrayList<>();
    final int[] expected = new int[len];
    for (int i = 0; i < len; ++i) {
      final Integer num = box.box(random.nextInt());
      tested.add(num);
      expected[i] = num.intValue();
    }
    Assert.assertArrayEquals(expected, unbox.it(tested));
  }

  @Test public void testUnboxBoolean() {
    final Integer tested = box.box(new Random().nextInt());
    azzert.assertEquals(tested.intValue(), unbox.unbox(tested));
  }

  @Test public void testUnboxBooleanArray() {
    final Random random = new Random();
    final int len = 100;
    final Boolean[] tested = new Boolean[len];
    final boolean[] expected = new boolean[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextBoolean();
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.assertEquals(arr[0], unbox.unbox(box.box(arr[0])));
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
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxCharacter() {
    final Character tested = box.box((char) new Random().nextInt(Character.MAX_VALUE + 1));
    azzert.assertEquals(tested.charValue(), unbox.unbox(tested));
  }

  @Test public void testUnboxCharacterArray() {
    final Random random = new Random();
    final int len = 100;
    final Character[] tested = new Character[len];
    final char[] expected = new char[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxOrderedCollectionOfShort() {
    final Random random = new Random();
    final int len = 100;
    final Collection<Short> tested = new ArrayList<>();
    final short[] expected = new short[len];
    for (int i = 0; i < len; ++i) {
      final Short num = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
      tested.add(num);
      expected[i] = unbox.unbox(num);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxDouble() {
    final Double tested = box.box(new Random().nextDouble());
    Assert.assertEquals(tested.doubleValue(), unbox.unbox(tested), 0.0000000001);
  }

  @Test public void testUnboxDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final Double[] tested = new Double[len];
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextDouble();
      tested[¢] = box.box(expected[¢]);
    }
    final double[] res = unbox.unbox(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testUnboxFloat() {
    final Float tested = box.box(new Random().nextFloat());
    Assert.assertEquals(tested.floatValue(), unbox.unbox(tested), (float) 0.0000001);
  }

  @Test public void testUnboxFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final Float[] tested = new Float[len];
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextFloat();
      tested[¢] = box.box(expected[¢]);
    }
    final float[] res = unbox.unbox(tested);
    final float epsilon = (float) 0.0000001;
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], epsilon);
  }

  @Test public void testUnboxInteger() {
    final Integer tested = box.box(new Random().nextInt());
    azzert.assertEquals(tested.intValue(), unbox.unbox(tested));
  }

  @Test public void testUnboxIntegerArray() {
    final Random random = new Random();
    final int len = 100;
    final Integer[] tested = new Integer[len];
    final int[] expected = new int[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextInt();
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxLong() {
    final Long tested = box.box(new Random().nextLong());
    Assert.assertEquals(tested.longValue(), unbox.unbox(tested));
  }

  @Test public void testUnboxLongArray() {
    final Random random = new Random();
    final int len = 100;
    final Long[] tested = new Long[len];
    final long[] expected = new long[len];
    for (int ¢ = 0; ¢ < len; ++¢) {
      expected[¢] = random.nextLong();
      tested[¢] = box.box(expected[¢]);
    }
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxShort() {
    final Short tested = Short.valueOf((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.assertEquals(tested.shortValue(), unbox.unbox(tested));
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
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }
}
