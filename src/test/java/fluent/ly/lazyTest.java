package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;
import static fluent.ly.azzert.is;

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
    azzert.that(lzy.get(), is("foo1"));
    azzert.that(lzy.get(), is("foo1"));
    azzert.that(lzy.get(), is("foo1"));
  }
}
