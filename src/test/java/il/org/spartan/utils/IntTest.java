package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void testGet() {
    final int i = new Random().nextInt();
    assert Int.valueOf(i).inner().equals(Integer.valueOf(i));
  }

  @Test public void testStep() {
    final int i = new Random().nextInt();
    final Int int1 = Int.valueOf(i);
    int1.step();
    assert int1.inner().equals(Integer.valueOf(i + 1));
  }

  @Test public void testAddRegularInt() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.add(i2);
    assert int1.inner().equals(Integer.valueOf(i1 + i2));
  }

  @Test public void testAddOtherInt() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.add(Int.valueOf(i2));
    assertEquals(int1.inner(), Integer.valueOf(i1 + i2));
  }

  @Test public void testToString() {
    final int i1 = new Random().nextInt();
    assertEquals(Int.valueOf(i1) + "", Integer.valueOf(i1) + "");
  }

  @Test public void testSet() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.set(i2);
    assertNotEquals(int1.inner(), Integer.valueOf(i1));
    assertEquals(int1.inner(), Integer.valueOf(i2));
  }

  @Test public void testNext() {
    final int i1 = new Random().nextInt();
    final Int int1 = Int.valueOf(i1);
    assertEquals(int1.next(), i1 + 1);
    assertEquals(int1.inner(), Integer.valueOf(i1 + 1));
  }

  @Test public void testClear() {
    final Int int1 = Int.valueOf(new Random().nextInt());
    int1.clear();
    assertEquals(int1.inner(), Integer.valueOf(0));
  }
}
