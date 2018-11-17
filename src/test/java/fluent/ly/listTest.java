package fluent.ly;

import static fluent.ly.box.*;
import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class listTest {
  @Test public void penultimateTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(box(4));
    x.add(box(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(box(5));
    azzert.that(list.penultimate(x), is(box(4)));
  }

  @Test public void appendprependTest() {
    final List<@NotNull Integer> x = new ArrayList<>();
    x.add(box(4));
    x.add(box(5));
    final List<@NotNull Integer> y = new ArrayList<>();
    y.add(box(5));
    final List<@NotNull Integer> yy = new ArrayList<>();
    yy.add(box(4));
    azzert.that(list.prepend(box(4)).to(y), is(x));
    azzert.that(list.append(box(5)).to(yy), is(x));
    azzert.that(list.append(box(5)).to().to(yy), is(x));
  }
}
