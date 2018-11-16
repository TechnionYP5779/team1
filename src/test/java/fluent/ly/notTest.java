package fluent.ly;

import java.util.*;

import org.junit.*;

import il.org.spartan.*;

// This suppress is here because
// eclipse asks the method to be static
// although they shouldn't
@SuppressWarnings("static-method") public class notTest {
  @Test public void inTest() {
    assert not.in(Utils.cantBeNull(Integer.valueOf(2)), new ArrayList<Integer>());
  }

  @Test public void nilTest() {
    assert !not.nil(null);
    assert not.nil(Integer.toString(5));
  }
}
