package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

public class countTest {
  @Test
  public void testWithEmptyIterator() {
    assertEquals(0, count.of(Collections.emptyList()));
  }
  
  @Test
  public void testWithList() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(list.size(), count.of(list));
  }
  
}
