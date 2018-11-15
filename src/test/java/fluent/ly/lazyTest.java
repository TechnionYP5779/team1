package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-access", "static-method" }) public class lazyTest {
  @Test public void testGet() {
    lazy<@Nullable String> lzy = lazy.get(new Supplier<@Nullable String>() {
      int cnt;

      @Override public String get() {
        cnt++;
        return "foo" + cnt;
      }
    });
    
    //make sure the computation only happens once
    azzert.assertEquals("foo1", lzy.get());
    azzert.assertEquals("foo1", lzy.get());
    azzert.assertEquals("foo1", lzy.get());
  }
}
