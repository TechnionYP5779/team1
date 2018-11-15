package an;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testList() {
    azzert.zero(empty.list().size());
  }

  @Test public void testIterable() {
    azzert.isNull(empty.iterable().iterator().next());
    azzert.falze(empty.iterable().iterator().hasNext());
  }
}
