package fluent.ly;

import java.util.*;

import org.junit.*;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

@SuppressWarnings("static-method") public class boxTest {
  @Test public void testBoxBoolean() {
    final boolean tested = new Random().nextBoolean();
    azzert.that(tested, is(box(tested)));
  }

  @Test public void testBoxBooleanArray() {
    final int len = 100;
    final boolean[] tested = new boolean[len];
    final Boolean[] expected = new Boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.that(box(arr[0]), is(box(arr[0])));
  }

  @Test public void testBoxByteArray() {
    final Random random = new Random();
    final int len = 100;
    final byte[] tested = new byte[len];
    final Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = box(tested[¢]);
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxChar() {
    char tested = (char) new Random().nextInt(Character.MAX_VALUE + 1);
    azzert.that(box(tested), is(box(tested)));
  }

  @Test public void testBoxCharArray() {
    final int len = 100;
    final char[] tested = new char[len];
    final Character[] expected = new Character[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxDouble() {
    final Double expected = box(new Random().nextDouble());
    azzert.that(expected, is(box(expected.doubleValue())));
  }

  @Test public void testBoxDoubleArray() {
    final int len = 100;
    final double[] tested = new double[len];
    final Double[] expected = new Double[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxFloat() {
    final Float expected = box(new Random().nextFloat());
    azzert.that(expected, is(box(expected.floatValue())));
  }

  @Test public void testBoxFloatArray() {
    final int len = 100;
    final float[] tested = new float[len];
    final Float[] expected = new Float[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxInt() {
    final Integer expected = box(new Random().nextInt());
    azzert.that(expected, is(box(expected.intValue())));
  }

  @Test public void testBoxIntArray() {
    final int len = 100;
    final int[] tested = new int[len];
    final Integer[] expected = new Integer[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxLong() {
    final Long expected = box(new Random().nextLong());
    azzert.that(expected, is(box(expected.longValue())));
  }

  @Test public void testBoxLongArray() {
    final int len = 100;
    final long[] tested = new long[len];
    final Long[] expected = new Long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testBoxShort() {
    final Short expected = box((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.that(expected, is(box(expected.shortValue())));
  }

  @Test public void testBoxShortArray() {
    final int len = 100;
    final short[] tested = new short[len];
    final Short[] expected = new Short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItBoolean() {
    final boolean tested = new Random().nextBoolean();
    azzert.that(tested, is(box.it(tested)));
  }

  @Test public void testItBooleanArray() {
    final int len = 100;
    final boolean[] tested = new boolean[len];
    final Boolean[] expected = new Boolean[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextBoolean();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItByte() {
    final Random random = new Random();
    final byte[] arr = new byte[1];
    random.nextBytes(arr);
    azzert.that(box(arr[0]), is(box.it(arr[0])));
  }

  @Test public void testItByteArray() {
    final Random random = new Random();
    final int len = 100;
    final byte[] tested = new byte[len];
    final Byte[] expected = new Byte[len];
    random.nextBytes(tested);
    for (int ¢ = 0; ¢ < len; ++¢)
      expected[¢] = box(tested[¢]);
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItChar() {
    final Character expected = box((char) new Random().nextInt(Character.MAX_VALUE + 1));
    azzert.that(expected, is(box.it(expected.charValue())));
  }

  @Test public void testItCharArray() {
    final int len = 100;
    final char[] tested = new char[len];
    final Character[] expected = new Character[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (char) random.nextInt(Character.MAX_VALUE + 1);
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItDouble() {
    final Double expected = box(new Random().nextDouble());
    azzert.that(expected, is(box.it(expected.doubleValue())));
  }

  @Test public void testItDoubleArray() {
    final int len = 100;
    final double[] tested = new double[len];
    final Double[] expected = new Double[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextDouble();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItFloat() {
    final Float expected = box(new Random().nextFloat());
    azzert.that(expected, is(box.it(expected.floatValue())));
  }

  @Test public void testItFloatArray() {
    final int len = 100;
    final float[] tested = new float[len];
    final Float[] expected = new Float[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextFloat();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItInt() {
    final Integer expected = box(new Random().nextInt());
    azzert.that(expected, is(box.it(expected.intValue())));
  }

  @Test public void testItIntArray() {
    final int len = 100;
    final int[] tested = new int[len];
    final Integer[] expected = new Integer[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextInt();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItLong() {
    final Long expected = box(new Random().nextLong());
    azzert.that(expected, is(box.it(expected.longValue())));
  }

  @Test public void testItLongArray() {
    final int len = 100;
    final long[] tested = new long[len];
    final Long[] expected = new Long[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = random.nextLong();
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }

  @Test public void testItShort() {
    final Short expected = box((short) new Random().nextInt(Short.MAX_VALUE + 1));
    azzert.that(expected, is(box.it(expected.shortValue())));
  }

  @Test public void testItShortArray() {
    final int len = 100;
    final short[] tested = new short[len];
    final Short[] expected = new Short[len];
    final Random random = new Random();
    for (int ¢ = 0; ¢ < len; ++¢) {
      tested[¢] = (short) random.nextInt(Short.MAX_VALUE + 1);
      expected[¢] = box(tested[¢]);
    }
    azzert.that(expected, is(box(tested)));
  }
}
