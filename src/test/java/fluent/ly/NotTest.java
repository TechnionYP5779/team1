package fluent.ly;

import java.util.*;
import org.junit.*;

import il.org.spartan.*;

//This suppress is here because
// eclipse asks the method to be static
// although they shouldn't
@SuppressWarnings("static-method")
public class NotTest {
  @Test public void inTest() {
    @SuppressWarnings("unused") List<Integer> values = new ArrayList<Integer>(); //because travis wont know the type
    assert not.in(Utils.cantBeNull(Integer.valueOf(2)), values);
  }
  @Test public void nilTest() {
    assert !not.nil(null);
    assert not.nil(Integer.toString(5));
  }

}
