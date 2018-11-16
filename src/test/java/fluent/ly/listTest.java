package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class listTest {
  @Test public void penultimateTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    Assert.assertEquals(list.penultimate(x), Integer.valueOf(4));
  }

  @Test public void appendprependTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    @Nullable final List<@Nullable Integer> yy = new ArrayList<>();
    yy.add(Integer.valueOf(4));
    Assert.assertEquals(list.prepend(Integer.valueOf(4)).to(y), x);
    Assert.assertEquals(list.append(Integer.valueOf(5)).to(yy), x);
    Assert.assertEquals(list.append(Integer.valueOf(5)).to().to(yy), x);
  }
}
