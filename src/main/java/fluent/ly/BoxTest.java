package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "boxing", "static-method" }) public class BoxTest {
  @Test public void testBoxBoolean() {
    Random random = new Random();
    boolean tested = random.nextBoolean();
    Boolean mybox = box.box(tested);
    Boolean expected = tested;
    assertEquals(expected, mybox);
  }

  @Test public void testBoxBooleanArray() {
    int len = 100;
    boolean[] tested = new boolean[len];
    Boolean[] expected = new Boolean[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextBoolean();
      expected[i] = tested[i];
    }
    Boolean[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    byte tested = arr[0];
    Byte mybox = box.box(tested);
    Byte expected = tested;
    assertEquals(expected, mybox);
  }

  @Test public void testBoxByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] tested = new byte[len];
    Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int i = 0; i < len; i++) {
      expected[i] = tested[i];
    }
    Byte[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxChar() {
    Random random = new Random();
    char tested = (char) random.nextInt(Character.MAX_VALUE + 1);
    Character expected = tested;
    Character mybox = box.box(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testBoxCharArray() {
    int len = 100;
    char[] tested = new char[len];
    Character[] expected = new Character[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[i] = tested[i];
    }
    Character[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxDouble() {
    Random random = new Random();
    double tested = random.nextDouble();
    Double expected = tested;
    Double mybox = box.box(expected);
    // Maybe shouldnt compare using assertEquals even when
    assertEquals(expected, mybox);
  }

  @Test public void testBoxDoubleArray() {
    int len = 100;
    double[] tested = new double[len];
    Double[] expected = new Double[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextDouble();
      expected[i] = tested[i];
    }
    Double[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxFloat() {
    Random random = new Random();
    float tested = random.nextFloat();
    Float expected = tested;
    Float mybox = box.box(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testBoxFloatArray() {
    int len = 100;
    float[] tested = new float[len];
    Float[] expected = new Float[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextFloat();
      expected[i] = tested[i];
    }
    Float[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxInt() {
    Random random = new Random();
    int tested = random.nextInt();
    Integer expected = tested;
    Integer mybox = box.box(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testBoxIntArray() {
    int len = 100;
    int[] tested = new int[len];
    Integer[] expected = new Integer[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextInt();
      expected[i] = tested[i];
    }
    Integer[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxLong() {
    Random random = new Random();
    long tested = random.nextLong();
    Long expected = tested;
    Long mybox = box.box(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testBoxLongArray() {
    int len = 100;
    long[] tested = new long[len];
    Long[] expected = new Long[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextLong();
      expected[i] = tested[i];
    }
    Long[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testBoxShort() {
    Random random = new Random();
    short tested = (short) random.nextInt(Short.MAX_VALUE + 1);
    Short expected = tested;
    Short mybox = box.box(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testBoxShortArray() {
    int len = 100;
    short[] tested = new short[len];
    Short[] expected = new Short[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[i] = tested[i];
    }
    Short[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItBoolean() {
    Random random = new Random();
    boolean tested = random.nextBoolean();
    Boolean mybox = box.it(tested);
    Boolean expected = tested;
    assertEquals(expected, mybox);
  }

  @Test public void testItBooleanArray() {
    int len = 100;
    boolean[] tested = new boolean[len];
    Boolean[] expected = new Boolean[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextBoolean();
      expected[i] = tested[i];
    }
    Boolean[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    byte tested = arr[0];
    Byte mybox = box.it(tested);
    Byte expected = tested;
    assertEquals(expected, mybox);
  }

  @Test public void testItByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] tested = new byte[len];
    Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int i = 0; i < len; i++) {
      expected[i] = tested[i];
    }
    Byte[] mybox = box.box(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItChar() {
    Random random = new Random();
    char tested = (char) random.nextInt(Character.MAX_VALUE + 1);
    Character expected = tested;
    Character mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItCharArray() {
    int len = 100;
    char[] tested = new char[len];
    Character[] expected = new Character[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[i] = tested[i];
    }
    Character[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItDouble() {
    Random random = new Random();
    double tested = random.nextDouble();
    Double expected = tested;
    Double mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItDoubleArray() {
    int len = 100;
    double[] tested = new double[len];
    Double[] expected = new Double[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextDouble();
      expected[i] = tested[i];
    }
    Double[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItFloat() {
    Random random = new Random();
    float tested = random.nextFloat();
    Float expected = tested;
    Float mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItFloatArray() {
    int len = 100;
    float[] tested = new float[len];
    Float[] expected = new Float[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextFloat();
      expected[i] = tested[i];
    }
    Float[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItInt() {
    Random random = new Random();
    int tested = random.nextInt();
    Integer expected = tested;
    Integer mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItIntArray() {
    int len = 100;
    int[] tested = new int[len];
    Integer[] expected = new Integer[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextInt();
      expected[i] = tested[i];
    }
    Integer[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItLong() {
    Random random = new Random();
    long tested = random.nextLong();
    Long expected = tested;
    Long mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItLongArray() {
    int len = 100;
    long[] tested = new long[len];
    Long[] expected = new Long[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = random.nextLong();
      expected[i] = tested[i];
    }
    Long[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }

  @Test public void testItShort() {
    Random random = new Random();
    short tested = (short) random.nextInt(Short.MAX_VALUE + 1);
    Short expected = tested;
    Short mybox = box.it(expected);
    assertEquals(expected, mybox);
  }

  @Test public void testItShortArray() {
    int len = 100;
    short[] tested = new short[len];
    Short[] expected = new Short[len];
    Random random = new Random();
    for (int i = 0; i < len; i++) {
      tested[i] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[i] = tested[i];
    }
    Short[] mybox = box.it(tested);
    assertArrayEquals(expected, mybox);
  }
}
