package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class theTest {
  @Test public void minTest() {
    azzert.that(the.min(5, 3, 2), is(2));
  }

  @Test public void maxTest() {
    azzert.that(the.max(5, 3, 2), is(5));
  }

  @Test public void sqrTest() {
    azzert.that(the.sqr(0), is(0));
    azzert.that(the.sqr(3), is(9));
    azzert.that(the.sqr(2), is(4));
    azzert.that(the.sqr(1), is(1));
  }

  @Test public void restTest() {
    azzert.that(the.rest("hello"), is("ello"));
    azzert.that(the.rest("a"), is(""));
  }

  @Test public void lastTailTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(box(4));
    x.add(box(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(box(5));
    assert the.last(null) == null;
    assert the.last(new ArrayList<>()) == null;
    azzert.that(the.last(x), is(box(5)));
    azzert.that(the.lastOf(x), is(box(5)));
    azzert.that(the.tailOf(x), is(y));
    azzert.that(the.lastOf(new @Nullable Integer[] { box(5), box(2) }), is(2));
    azzert.that(the.tailOf(new Integer[] { box(5), box(2) })[0], is(box(2)));
    azzert.that(the.lastOf("Hello"), is('o'));
    azzert.that(the.tailOf("Hello"), is("ello"));
  }

  @Test public void indexTest() {
    azzert.that(the.index(1, 1, 2, 3, 4), is(0));
    azzert.that(the.index(4, 1, 2, 3, 4), is(3));
    azzert.that(the.index(5, 1, 2, 3, 4), is(-1));
  }

  @Test public void nilTest() {
    assert the.nil() == null;
  }

  @Test public void nthTest() {
    final List<Integer> x = new ArrayList<>();
    x.add(box(4));
    x.add(box(5));
    azzert.that(the.nth(6, x), is(" #6/2"));
  }

  @Test public void lastOfTest() {
    final List<Integer> x = new ArrayList<>();
    // x.add(box(4));
    x.add(box(5));
    x.add(box(5));
    for (final Integer ¢ : the.lastOf((Iterable<Integer>) x))
      azzert.that(¢, is(box(5)));
  }

  @Test public void onlyOneOfTest() {
    final List<Integer> x = new ArrayList<>();
    x.add(box(4));
    azzert.that(the.onlyOneOf(x), is(box(4)));
    assert the.onlyOneOf(null) == null;
    x.add(box(5));
    azzert.isNull(the.onlyOneOf(x));
  }

  @Test public void listTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(box(4));
    x.add(box(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(box(5));
    assert the.penultimateOf(null) == null;
    assert the.penultimateOf(y) == null;
    azzert.that(the.penultimateOf(x), is(box(4)));
    assert the.previous(box(5), null) == null;
    assert the.previous(box(4), x) == null;
    assert the.previous(box(5), x) != null;
    assert the.headOf(null) == null;
    assert the.headOf(new ArrayList<>()) == null;
    assert the.lastOf(new ArrayList<>()) == null;
    assert the.lastOf((List<Object>) null) == null;
    azzert.that(the.lastOf(y), is(box(5)));
    azzert.that(the.previous(box(5), x), is(box(4)));
    azzert.that(the.secondOf(x), is(box(5)));
    assert the.secondOf(null) == null;
    assert the.secondOf(y) == null;
    azzert.that(the.rest(box(3), x), is(an.empty.list()));
    azzert.that(the.rest(box(4), x), is(y));
  }

  @Test public void charTest() {
    azzert.that(the.characterOf("hello"), is('o'));
    azzert.that(the.ith("hello", 2), is('l'));
  }
}
