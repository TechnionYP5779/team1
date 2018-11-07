package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class BoxUnboxTest {
  @Test public void testBoolean() {
    boolean expected = new Random().nextBoolean();
    assert expected == unbox.unbox(box.box(expected));
  }

  @Test public void testBooleanArray() {
    int len = 100;
    boolean[] expected = new boolean[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextBoolean();
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    assertEquals(arr[0], unbox.unbox(box.box(arr[0])));
  }

  @Test public void testByteArray() {
    Random random = new Random();
    byte[] expected = new byte[100];
    random.nextBytes(expected);
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testChar() {
    char expected = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testCharArray() {
    int len = 100;
    char[] expected = new char[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testDouble() {
    double expected = new Random().nextDouble();
    assertEquals(expected, unbox.unbox(box.box(expected)), 0.0000000001);
  }

  @Test public void testDoubleArray() {
    Random random = new Random();
    int len = 100;
    double[] expected = new double[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextDouble();
    double[] res = unbox.unbox(box.box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testFloat() {
    float expected = new Random().nextFloat();
    assertEquals(expected, unbox.unbox(box.box(expected)), 0.0000000001);
  }

  @Test public void testFloatArray() {
    Random random = new Random();
    int len = 100;
    float[] expected = new float[len];
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextFloat();
    float[] res = unbox.unbox(box.box(expected));
    for (int ¢ = 0; ¢ < len; ++¢)
      assertEquals(expected[¢], res[¢], 0.0000000001);
  }

  @Test public void testInt() {
    int expected = new Random().nextInt();
    assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testIntArray() {
    int len = 100;
    int[] expected = new int[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextInt();
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testLong() {
    long expected = new Random().nextLong();
    assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testLongArray() {
    int len = 100;
    long[] expected = new long[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = random.nextLong();
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testShort() {
    short expected = (short) new Random().nextInt(Short.MAX_VALUE + 1);
    assertEquals(expected, unbox.unbox(box.box(expected)));
  }

  @Test public void testShortArray() {
    int len = 100;
    short[] expected = new short[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
    assertArrayEquals(expected, unbox.unbox(box.box(expected)));
  }
}
