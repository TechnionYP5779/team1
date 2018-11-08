package il.org.spartan.utils;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;


public class IntTest {
  @Test @SuppressWarnings("static-method") public void testGet() {
    int i = new Random().nextInt();
    assert Int.valueOf(i).inner().equals(Integer.valueOf(i));
  }
  
  @Test @SuppressWarnings("static-method") public void testStep() {
    int i = new Random().nextInt();
    Int int1 = Int.valueOf(i);
    int1.step();
    assert int1.inner().equals(Integer.valueOf(i + 1));
  }

  @Test @SuppressWarnings("static-method") public void testAddRegularInt() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.add(i2);
    assert int1.inner().equals(Integer.valueOf(i1 + i2));
  }
  
  @Test @SuppressWarnings("static-method") public void testAddOtherInt() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.add(Int.valueOf(i2));
    assertEquals(int1.inner(), Integer.valueOf(i1 + i2));
  }
  
  @Test @SuppressWarnings("static-method") public void testToString() {
    int i1 = new Random().nextInt();
    assertEquals(Int.valueOf(i1) + "", Integer.valueOf(i1) + "");
  }
  
  @Test @SuppressWarnings("static-method") public void testSet() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.set(i2);
    assertNotEquals(int1.inner(), Integer.valueOf(i1));
    assertEquals(int1.inner(), Integer.valueOf(i2));
  }
  
  @Test @SuppressWarnings("static-method") public void testNext() {
    int i1 = new Random().nextInt();
    Int int1 = Int.valueOf(i1);
    assertEquals(int1.next(), i1 + 1);
    assertEquals(int1.inner(), Integer.valueOf(i1 + 1));
  }
  
  @Test @SuppressWarnings("static-method") public void testClear() {
    Int int1 = Int.valueOf(new Random().nextInt());
    int1.clear();
    assertEquals(int1.inner(), Integer.valueOf(0));
  }
}

