package il.org.spartan.utils;

import org.junit.*;
import static fluent.ly.unbox.*;
import fluent.ly.*;

public class BooleanOrReducerTest {
  BooleanOrReducer bool = new BooleanOrReducer();
  @Test public void reduce() {
    assert !unbox(bool.reduce());
    assert unbox(bool.reduce(box.it(true), box.it(false)));
    assert unbox(bool.reduce(box.it(false), box.it(true)));
    assert unbox(bool.reduce(box.it(true), box.it(true)));
    assert !unbox(bool.reduce(box.it(false), box.it(false)));
  }
}
