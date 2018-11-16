package fluent.ly;

import org.junit.*;

// Added suppress warning cause eclipse claims
// that the methods can be static although it won't compile
@SuppressWarnings("static-method") public class YesTest {
  @Test public void forgettingRunnableTest() {
    assert yes.forgetting(() -> {
      /* redundant */ });
  }

  @Test public void forgettingObjectTest() {
    assert yes.forgetting(Integer.toString(5));
  }

  @Test public void ignoringBooleanTest() {
    assert yes.ignoring(false) && yes.ignoring(true);
  }

  @Test public void ignoringDoubleTest() {
    assert yes.ignoring(5.0);
  }

  @Test public void ignoringLongTest() {
    assert yes.ignoring(123);
  }
}
