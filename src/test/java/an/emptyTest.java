package an;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.is;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testList() {
    azzert.that(empty.list().size(), is(0));
  }

  @Test public void testIterable() {
    azzert.isNull(empty.iterable().iterator().next());
    azzert.falze(empty.iterable().iterator().hasNext());
  }
}
