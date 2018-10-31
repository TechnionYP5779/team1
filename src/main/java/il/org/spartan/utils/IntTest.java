package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class IntTest {
  @Test
  public void testGet() {
    int i = new Random().nextInt();
    Int int1 = Int.valueOf(i);
    assertTrue(int1.inner().equals(Integer.valueOf(i)));
  }
  
  @Test
  public void testStep() {
    int i = new Random().nextInt();
    Int int1 = Int.valueOf(i);
    int1.step();
    assertTrue(int1.inner().equals(Integer.valueOf(i + 1)));
  }

  @Test
  public void testAddRegularInt() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.add(i2);
    assertTrue(int1.inner().equals(Integer.valueOf(i1 + i2)));
  }
  
  @Test
  public void testAddOtherInt() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    Int int2 = Int.valueOf(i2);
    int1.add(int2);
    assertEquals(int1.inner(),Integer.valueOf(i1 + i2));
  }
  
  @Test
  public void testToString() {
    Random random = new Random();
    int i1 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    assertEquals(int1.toString(), Integer.valueOf(i1).toString());
  }
  
  @Test
  public void testSet() {
    Random random = new Random();
    int i1 = random.nextInt(), i2 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.set(i2);
    
    assertNotEquals(int1.inner(), Integer.valueOf(i1));
    assertEquals(int1.inner(), Integer.valueOf(i2));
    
  }
  
  @Test
  public void testNext() {
    Random random = new Random();
    int i1 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    assertEquals(int1.next(), i1 + 1);
    assertEquals(int1.inner(), Integer.valueOf(i1 + 1));
  }
  
  @Test
  public void testClear() {
    Random random = new Random();
    int i1 = random.nextInt();
    Int int1 = Int.valueOf(i1);
    int1.clear();
    assertEquals(int1.inner(), Integer.valueOf(0));
  }
}

