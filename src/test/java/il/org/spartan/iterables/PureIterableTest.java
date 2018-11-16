package il.org.spartan.iterables;

import org.junit.*;

import fluent.ly.*;

public class PureIterableTest {
  class Mock extends PureIterable.Sized<Integer> {
    @Override public int size() {
      return 0;
    }
  }

  @Test public void size() {
    azzert.assertEquals(new Mock().size(), 0);
    azzert.assertNull(new Mock().iterator());
  }
}
