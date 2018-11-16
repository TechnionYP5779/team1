package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class lazyTest {
  @Test public void testGet() {
    final lazy<@Nullable String> lzy = lazy.get(new Supplier<@Nullable String>() {
      int cnt;

      @Override public String get() {
        cnt++;
        return "foo" + cnt;
      }
    });
    // make sure the computation only happens once
    Assert.assertEquals("foo1", lzy.get());
    Assert.assertEquals("foo1", lzy.get());
    Assert.assertEquals("foo1", lzy.get());
  }
}
