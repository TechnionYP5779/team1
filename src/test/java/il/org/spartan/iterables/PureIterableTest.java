package il.org.spartan.iterables;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

public class PureIterableTest {
  class Mock extends PureIterable.Sized<Integer> {
    @Override public int size() {
      return 0;
    }
  }

  @Test public void size() {
    azzert.that(new Mock().size(), is(0));
    azzert.assertNull(new Mock().iterator());
  }
}
