package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "boxing", "static-method" }) public class boxTest {
  @Test public void testBoxBoolean() {
    final boolean tested = new Random().nextBoolean();
    azzert.assertEquals(tested, box.box(tested));
  }

  @Test public void testBoxBooleanArray() {
    final int len = 100;
    final boolean[] tested = new boolean[len];
    final Boolean[] expected = new Boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    Assert.assertEquals((Byte) arr[0], box.box(arr[0]));
  }

  @Test public void testBoxByteArray() {
    final Random random = new Random();
    final int len = 100;
    final byte[] tested = new byte[len];
    final Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = tested[¢];
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxChar() {
    final Character expected = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxCharArray() {
    final int len = 100;
    final char[] tested = new char[len];
    final Character[] expected = new Character[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxDouble() {
    final Double expected = new Random().nextDouble();
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxDoubleArray() {
    final int len = 100;
    final double[] tested = new double[len];
    final Double[] expected = new Double[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxFloat() {
    final Float expected = new Random().nextFloat();
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxFloatArray() {
    final int len = 100;
    final float[] tested = new float[len];
    final Float[] expected = new Float[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxInt() {
    final Integer expected = new Random().nextInt();
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxIntArray() {
    final int len = 100;
    final int[] tested = new int[len];
    final Integer[] expected = new Integer[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxLong() {
    final Long expected = new Random().nextLong();
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxLongArray() {
    final int len = 100;
    final long[] tested = new long[len];
    final Long[] expected = new Long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxShort() {
    final Short expected = (short) new Random().nextInt(Short.MAX_VALUE + 1);
    Assert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxShortArray() {
    final int len = 100;
    final short[] tested = new short[len];
    final Short[] expected = new Short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItBoolean() {
    final boolean tested = new Random().nextBoolean();
    azzert.assertEquals(tested, box.it(tested));
  }

  @Test public void testItBooleanArray() {
    final int len = 100;
    final boolean[] tested = new boolean[len];
    final Boolean[] expected = new Boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    Assert.assertEquals((Byte) arr[0], box.it(arr[0]));
  }

  @Test public void testItByteArray() {
    final Random random = new Random();
    final int len = 100;
    final byte[] tested = new byte[len];
    final Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = tested[¢];
    Assert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItChar() {
    final Character expected = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItCharArray() {
    final int len = 100;
    final char[] tested = new char[len];
    final Character[] expected = new Character[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItDouble() {
    final Double expected = new Random().nextDouble();
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItDoubleArray() {
    final int len = 100;
    final double[] tested = new double[len];
    final Double[] expected = new Double[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItFloat() {
    final Float expected = new Random().nextFloat();
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItFloatArray() {
    final int len = 100;
    final float[] tested = new float[len];
    final Float[] expected = new Float[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItInt() {
    final Integer expected = new Random().nextInt();
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItIntArray() {
    final int len = 100;
    final int[] tested = new int[len];
    final Integer[] expected = new Integer[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItLong() {
    final Long expected = new Random().nextLong();
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItLongArray() {
    final int len = 100;
    final long[] tested = new long[len];
    final Long[] expected = new Long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItShort() {
    final Short expected = (short) new Random().nextInt(Short.MAX_VALUE + 1);
    Assert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItShortArray() {
    final int len = 100;
    final short[] tested = new short[len];
    final Short[] expected = new Short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    Assert.assertArrayEquals(expected, box.it(tested));
  }
}
