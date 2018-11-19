package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

@SuppressWarnings("static-method") public class BoxUnboxTest {
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
}
