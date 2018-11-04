package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class countTest {
  @SuppressWarnings("static-method") @Test
  public void testWithEmptyIterator() {
    assertEquals(0, count.of(Collections.emptyList()));
  }
  
  @SuppressWarnings("static-method") @Test
  public void testWithList() {
    List<Integer> list = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
    assertEquals(list.size(), count.of(list));
  }
  
}
