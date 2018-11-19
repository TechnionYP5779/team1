package fluent.ly;

import static fluent.ly.box.*;
import static il.org.spartan.Utils.*;

import org.junit.*;

// This suppress is here because
// eclipse asks the method to be static
// although they shouldn't
@SuppressWarnings("static-method") public class notTest {
  @Test public void inTest() {
    final Integer two = box(2), three = box(3);
    assert not.in(cantBeNull(two), cantBeNull(three));
    assert !not.in(cantBeNull(two), cantBeNull(two), cantBeNull(three));
  }

  @Test public void nilTest() {
    assert !not.nil(null);
    assert not.nil(Integer.toString(5));
  }
}
