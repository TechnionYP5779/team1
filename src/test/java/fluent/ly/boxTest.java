package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "boxing", "static-method", "static-access" }) public class boxTest {
  @Test public void testBoxBoolean() {
    boolean tested = new Random().nextBoolean();
    azzert.assertEquals(tested, box.box(tested));
  }

  @Test public void testBoxBooleanArray() {
    int len = 100;
    boolean[] tested = new boolean[len];
    Boolean[] expected = new Boolean[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.assertEquals((Byte) arr[0], box.box(arr[0]));
  }

  @Test public void testBoxByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] tested = new byte[len];
    Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = tested[¢];
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxChar() {
    Character expected = ((char) new Random().nextInt(Character.MAX_VALUE + 1));
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxCharArray() {
    int len = 100;
    char[] tested = new char[len];
    Character[] expected = new Character[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxDouble() {
    Double expected = new Random().nextDouble();
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxDoubleArray() {
    int len = 100;
    double[] tested = new double[len];
    Double[] expected = new Double[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxFloat() {
    Float expected = new Random().nextFloat();
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxFloatArray() {
    int len = 100;
    float[] tested = new float[len];
    Float[] expected = new Float[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxInt() {
    Integer expected = new Random().nextInt();
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxIntArray() {
    int len = 100;
    int[] tested = new int[len];
    Integer[] expected = new Integer[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxLong() {
    Long expected = new Random().nextLong();
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxLongArray() {
    int len = 100;
    long[] tested = new long[len];
    Long[] expected = new Long[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testBoxShort() {
    Short expected = ((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.assertEquals(expected, box.box(expected));
  }

  @Test public void testBoxShortArray() {
    int len = 100;
    short[] tested = new short[len];
    Short[] expected = new Short[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItBoolean() {
    boolean tested = new Random().nextBoolean();
    azzert.assertEquals(tested, box.it(tested));
  }

  @Test public void testItBooleanArray() {
    int len = 100;
    boolean[] tested = new boolean[len];
    Boolean[] expected = new Boolean[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.assertEquals((Byte) arr[0], box.it(arr[0]));
  }

  @Test public void testItByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] tested = new byte[len];
    Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = tested[¢];
    azzert.assertArrayEquals(expected, box.box(tested));
  }

  @Test public void testItChar() {
    Character expected = ((char) new Random().nextInt(Character.MAX_VALUE + 1));
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItCharArray() {
    int len = 100;
    char[] tested = new char[len];
    Character[] expected = new Character[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItDouble() {
    Double expected = new Random().nextDouble();
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItDoubleArray() {
    int len = 100;
    double[] tested = new double[len];
    Double[] expected = new Double[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItFloat() {
    Float expected = new Random().nextFloat();
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItFloatArray() {
    int len = 100;
    float[] tested = new float[len];
    Float[] expected = new Float[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItInt() {
    Integer expected = new Random().nextInt();
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItIntArray() {
    int len = 100;
    int[] tested = new int[len];
    Integer[] expected = new Integer[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItLong() {
    Long expected = new Random().nextLong();
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItLongArray() {
    int len = 100;
    long[] tested = new long[len];
    Long[] expected = new Long[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }

  @Test public void testItShort() {
    Short expected = ((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.assertEquals(expected, box.it(expected));
  }

  @Test public void testItShortArray() {
    int len = 100;
    short[] tested = new short[len];
    Short[] expected = new Short[len];
    Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = tested[¢];
    }
    azzert.assertArrayEquals(expected, box.it(tested));
  }
}
