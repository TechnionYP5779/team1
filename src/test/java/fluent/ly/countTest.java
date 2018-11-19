package fluent.ly;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test public void testWithEmptyIterator() {
    azzert.assertEquals(0, count.of(Collections.emptyList()));
  }

  @Test public void testWithList() {
    final List<Integer> list = Arrays.asList(box(1), box(2), box(3), box(4), box(5));
    azzert.assertEquals(list.size(), count.of(list));
  }
}
