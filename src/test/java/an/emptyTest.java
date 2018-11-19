package an;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testList() {
    azzert.that(empty.list().size(), is(0));
  }

  @Test public void testIterable() {
    azzert.isNull(empty.iterable().iterator().next());
    azzert.falze(empty.iterable().iterator().hasNext());
  }
}
