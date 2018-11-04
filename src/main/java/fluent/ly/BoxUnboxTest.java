package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class BoxUnboxTest {
  @Test public void testBoolean() {
    Random random = new Random();
    boolean expected = random.nextBoolean();
    Boolean mybox = box.box(expected);
    boolean res = unbox.unbox(mybox);
    assertTrue(expected == res);
  }

  @Test public void testBooleanArray() {
    int len = 100;
    boolean[] expected = new boolean[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      expected[i] = random.nextBoolean();
    }
    Boolean[] mybox = box.box(expected);
    boolean[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }

  @Test public void testByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    byte expected = arr[0];
    Byte mybox = box.box(expected);
    byte res = unbox.unbox(mybox);
    assertEquals(expected, res);
  }

  @Test public void testByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] expected = new byte[len];
    random.nextBytes(expected);
    Byte[] mybox = box.box(expected);
    byte[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }

  @Test public void testChar() {
    Random random = new Random();
    char expected = (char) random.nextInt(Character.MAX_VALUE + 1);
    Character mybox = box.box(expected);
    char res = unbox.unbox(mybox);
    assertEquals(expected, res);
  }

  @Test public void testCharArray() {
    int len = 100;
    char[] expected = new char[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      expected[i] = (char) random.nextInt(Character.MAX_VALUE + 1);
    }
    Character[] mybox = box.box(expected);
    char[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }

  @Test public void testDouble() {
    Random random = new Random();
    double expected = random.nextDouble();
    Double mybox = box.box(expected);
    double res = unbox.unbox(mybox);
    double delta = 0.0000000001;
    assertEquals(expected,res,delta);
  }

  @Test public void testDoubleArray() {
    Random random = new Random();
    int len = 100;
    double[] expected = new double[len];
    for (int i = 0; i < len; i++) {
      expected[i] = random.nextDouble();
    }
    Double[] mybox = box.box(expected);
    double[] res = unbox.unbox(mybox);
    double delta = 0.0000000001;
    for (int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], delta);
    }
  }

  @Test public void testFloat() {
    Random random = new Random();
    float expected = random.nextFloat();
    Float mybox = box.box(expected);
    float res = unbox.unbox(mybox);
    double delta = 0.0000000001;
    assertEquals(expected, res, delta);
  }

  @Test public void testFloatArray() {
    Random random = new Random();
    int len = 100;
    float[] expected = new float[len];
    for (int i = 0; i < len; i++) {
      expected[i] = random.nextFloat();
    }
    Float[] mybox = box.box(expected);
    float[] res = unbox.unbox(mybox);
    double delta = 0.0000000001;
    for (int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], delta);
    }
  }

  @Test public void testInt() {
    Random random = new Random();
    int expected = random.nextInt();
    Integer mybox = box.box(expected);
    int res = unbox.unbox(mybox);
    assertEquals(expected, res);
  }

  @Test public void testIntArray() {
    int len = 100;
    int[] expected = new int[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      expected[i] = random.nextInt();
    }
    Integer[] mybox = box.box(expected);
    int[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }

  @Test public void testLong() {
    Random random = new Random();
    long expected = random.nextLong();
    Long mybox = box.box(expected);
    long res = unbox.unbox(mybox);
    assertEquals(expected, res);
  }

  @Test public void testLongArray() {
    int len = 100;
    long[] expected = new long[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      expected[i] = random.nextLong();
    }
    Long[] mybox = box.box(expected);
    long[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }

  @Test public void testShort() {
    Random random = new Random();
    short expected = (short) random.nextInt(Short.MAX_VALUE + 1);
    Short mybox = box.box(expected);
    short res = unbox.unbox(mybox);
    assertEquals(expected, res);
  }

  @Test public void testShortArray() {
    int len = 100;
    short[] expected = new short[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      expected[i] = (short) random.nextInt(Short.MAX_VALUE + 1);
    }
    Short[] mybox = box.box(expected);
    short[] res = unbox.unbox(mybox);
    assertArrayEquals(expected, res);
  }
}
