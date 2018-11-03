package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class UnboxTest {
  @Test public void testItDoubleArray() {
    Random random = new Random();
    int len = 100;
    Double[] tested = new Double[len];
    double[] expected = new double[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextDouble();
      expected[i] = tested[i];
    }
    double[] res = unbox.it(tested);
    double epsilon = 0.0000000001;
    for(int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], epsilon);
    }
  }

  @Test public void testItFloatArray() {
    Random random = new Random();
    int len = 100;
    Float[] tested = new Float[len];
    float[] expected = new float[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextFloat();
      expected[i] = tested[i];
    }
    float[] res = unbox.it(tested);
    float epsilon = (float) 0.0000001;
    for(int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], epsilon);
    }
  }

  @Test public void testItInteger() {
    Random random = new Random();
    Integer tested = random.nextInt();
    int expected = tested;
    int res = unbox.it(tested);
    assertEquals(expected, res);
  }

  @Test public void testItIntegerArray() {
    Random random = new Random();
    int len = 100;
    Integer[] tested = new Integer[len];
    int[] expected = new int[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextInt();
      expected[i] = tested[i];
    }
    int[] res = unbox.it(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testItListOfInteger() {
    Random random = new Random();
    int len = 100;
    List<Integer> tested = new ArrayList<>();
    int[] expected = new int[len];
    for(int i =0; i< len; i++) {
      Integer num = random.nextInt();
      tested.add(num);
      expected[i] = num;
    }
    int[] res = unbox.it(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxBoolean() {
    Random random = new Random();
    Integer tested = random.nextInt();
    int expected = tested;
    int res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxBooleanArray() {
    Random random = new Random();
    int len = 100;
    Boolean[] tested = new Boolean[len];
    boolean[] expected = new boolean[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextBoolean();
      expected[i] = tested[i];
    }
    boolean[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxByte() {
    Random random = new Random();
    byte[] arr = new byte[1];
    random.nextBytes(arr);
    Byte tested = arr[0];
    byte expected = tested;
    byte res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxByteArray() {
    Random random = new Random();
    int len = 100;
    byte[] arr = new byte[len];
    random.nextBytes(arr);
    Byte[] tested = new Byte[len];
    byte[] expected = new byte[len];
    for(int i =0; i< len; i++) {
      tested[i] = arr[i];
      expected[i] = tested[i];
    }
    byte[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxCharacter() {
    Random random = new Random();
    Character tested = (Character)((char)random.nextInt(Character.MAX_VALUE + 1));
    char expected = tested;
    char res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxCharacterArray() {
    Random random = new Random();
    int len = 100;
    Character[] tested = new Character[len];
    char[] expected = new char[len];
    for(int i =0; i< len; i++) {
      tested[i] = (Character)((char)random.nextInt(Character.MAX_VALUE + 1));
      expected[i] = tested[i];
    }
    char[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxOrderedCollectionOfShort() {
    Random random = new Random();
    int len = 100;
    Collection<Short> tested = new ArrayList<>();
    short[] expected = new short[len];
    for(int i =0; i< len; i++) {
      Short num = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
      tested.add(num);
      expected[i] = num;
    }
    short[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxDouble() {
    Random random = new Random();
    Double tested = random.nextDouble();
    double expected = tested;
    double res = unbox.unbox(tested);
    double epsilon = 0.0000000001;
    assertEquals(expected, res, epsilon);
  }

  @Test public void testUnboxDoubleArray() {
    Random random = new Random();
    int len = 100;
    Double[] tested = new Double[len];
    double[] expected = new double[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextDouble();
      expected[i] = tested[i];
    }
    double[] res = unbox.unbox(tested);
    double epsilon = 0.0000000001;
    for(int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], epsilon);
    }
  }

  @Test public void testUnboxFloat() {
    Random random = new Random();
    Float tested = random.nextFloat();
    float expected = tested;
    float res = unbox.unbox(tested);
    float epsilon = (float) 0.0000001;
    assertEquals(expected, res, epsilon);
  }

  @Test public void testUnboxFloatArray() {
    Random random = new Random();
    int len = 100;
    Float[] tested = new Float[len];
    float[] expected = new float[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextFloat();
      expected[i] = tested[i];
    }
    float[] res = unbox.unbox(tested);
    float epsilon = (float) 0.0000001;
    for(int i = 0; i < len; i++) {
      assertEquals(expected[i], res[i], epsilon);
    }
  }

  @Test public void testUnboxInteger() {
    Random random = new Random();
    Integer tested = random.nextInt();
    int expected = tested;
    int res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxIntegerArray() {
    Random random = new Random();
    int len = 100;
    Integer[] tested = new Integer[len];
    int[] expected = new int[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextInt();
      expected[i] = tested[i];
    }
    int[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxLong() {
    Random random = new Random();
    Long tested = random.nextLong();
    long expected = tested;
    long res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxLongArray() {
    Random random = new Random();
    int len = 100;
    Long[] tested = new Long[len];
    long[] expected = new long[len];
    for(int i =0; i< len; i++) {
      tested[i] = random.nextLong();
      expected[i] = tested[i];
    }
    long[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }

  @Test public void testUnboxShort() {
    Random random = new Random();
    Short tested = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
    short expected = tested;
    short res = unbox.unbox(tested);
    assertEquals(expected, res);
  }

  @Test public void testUnboxShortArray() {
    Random random = new Random();
    int len = 100;
    Short[] tested = new Short[len];
    short[] expected = new short[len];
    for(int i =0; i< len; i++) {
      tested[i] = Short.valueOf((short) random.nextInt(Short.MAX_VALUE + 1));
      expected[i] = tested[i];
    }
    short[] res = unbox.unbox(tested);
    assertArrayEquals(expected, res);
  }
}
