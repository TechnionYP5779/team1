package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({"boxing","static-method","static-access","null"}) 
public class unboxTest {
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
