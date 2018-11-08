package fluent.ly;

import java.util.*;

import org.junit.*;

public class countTest {
  @Test @SuppressWarnings("static-method") public void testWithEmptyIterator() {
    azzert.assertEquals(0, count.of(Collections.emptyList()));
  }

  @Test @SuppressWarnings("static-method") public void testWithList() {
    final List<Integer> list = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5));
    azzert.assertEquals(list.size(), count.of(list));
  }
}
