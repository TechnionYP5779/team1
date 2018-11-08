package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class BoxUnboxTest {
  @Test public void testBoolean() {
    final boolean expected = new Random().nextBoolean();
    azzert.assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testBooleanArray() {
    final int len = 100;
    final boolean[] expected = new boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextBoolean();
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.assertEquals(arr[0], unbox.unbox(box.box(arr[0])));
  }

  @Test public void testByteArray() {
    final Random random = new Random();
    final byte[] expected = new byte[100];
    random.nextBytes(expected);
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testChar() {
    final char expected = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    azzert.assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testCharArray() {
    final int len = 100;
    final char[] expected = new char[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testDouble() {
    final double expected = new Random().nextDouble();
    Assert.assertEquals(expected, unbox.unbox(box.box(expected)), 0.0000000001);
  }

  @Test public void testDoubleArray() {
    final Random random = new Random();
    final int len = 100;
    final double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextDouble();
    final double[] res = unbox.unbox(box.box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testFloat() {
    final float expected = new Random().nextFloat();
    Assert.assertEquals(expected, unbox.unbox(box.box(expected)), 0.0000000001);
  }

  @Test public void testFloatArray() {
    final Random random = new Random();
    final int len = 100;
    final float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextFloat();
    final float[] res = unbox.unbox(box.box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      Assert.assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testInt() {
    final int expected = new Random().nextInt();
    azzert.assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testIntArray() {
    final int len = 100;
    final int[] expected = new int[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextInt();
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testLong() {
    final long expected = new Random().nextLong();
    Assert.assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testLongArray() {
    final int len = 100;
    final long[] expected = new long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextLong();
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testShort() {
    final short expected = (short) new Random().nextInt(Short.MAX_VALUE + 1);
    azzert.assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testShortArray() {
    final int len = 100;
    final short[] expected = new short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
    Assert.assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }
}
