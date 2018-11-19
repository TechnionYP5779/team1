package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void testGet() {
    final int i = new Random().nextInt();
    assert Int.valueOf(i).inner().equals(box(i));
  }

  @Test public void testStep() {
    final int i = new Random().nextInt();
    final Int int1 = Int.valueOf(i);
    int1.step();
    assert int1.inner().equals(box(i + 1));
  }

  @Test public void testAddRegularInt() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.add(i2);
    assert int1.inner().equals(box(i1 + i2));
  }

  @Test public void testAddOtherInt() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.add(Int.valueOf(i2));
    azzert.that(int1.inner(), is(box(i1 + i2)));
  }

  @Test public void testToString() {
    final int i1 = new Random().nextInt();
    azzert.that(Int.valueOf(i1) + "", is(box(i1) + ""));
  }

  @Test public void testSet() {
    final Random random = new Random();
    final int i1 = random.nextInt(), i2 = random.nextInt();
    final Int int1 = Int.valueOf(i1);
    int1.set(i2);
    assertNotEquals(int1.inner(), box(i1));
    azzert.that(int1.inner(), is(box(i2)));
  }

  @Test public void testNext() {
    final int i1 = new Random().nextInt();
    final Int int1 = Int.valueOf(i1);
    azzert.that(int1.next(), is(i1 + 1));
    azzert.that(int1.inner(), is(box(i1 + 1)));
  }

  @Test public void testClear() {
    final Int int1 = Int.valueOf(new Random().nextInt());
    int1.clear();
    azzert.that(int1.inner(), is(box(0)));
  }
}
