package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class theTest {
  @Test public void minTest() {
    azzert.assertEquals(the.min(5, 3, 2), 2);
  }

  @Test public void maxTest() {
    azzert.assertEquals(the.max(5, 3, 2), 5);
  }

  @Test public void sqrTest() {
    azzert.assertEquals(the.sqr(0), 0);
    azzert.assertEquals(the.sqr(3), 9);
    azzert.assertEquals(the.sqr(2), 4);
    azzert.assertEquals(the.sqr(1), 1);
  }

  @Test public void restTest() {
    Assert.assertEquals(the.rest("hello"), "ello");
    Assert.assertEquals(the.rest("a"), "");
  }

  @Test public void lastTailTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    azzert.assertTrue(the.last(null) == null);
    azzert.assertTrue(the.last(new ArrayList<>()) == null);
    Assert.assertEquals(the.last(x), Integer.valueOf(5));
    Assert.assertEquals(the.lastOf(x), Integer.valueOf(5));
    Assert.assertEquals(the.tailOf(x), y);
    azzert.assertEquals(the.lastOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) }), 2);
    Assert.assertEquals(the.tailOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) })[0], Integer.valueOf(2));
    azzert.assertEquals(the.lastOf("Hello"), 'o');
    Assert.assertEquals(the.tailOf("Hello"), "ello");
  }

  @Test public void indexTest() {
    azzert.assertEquals(the.index(1, 1, 2, 3, 4), 0);
    azzert.assertEquals(the.index(4, 1, 2, 3, 4), 3);
    azzert.assertEquals(the.index(5, 1, 2, 3, 4), -1);
  }

  @Test public void nilTest() {
    azzert.assertTrue(the.nil() == null);
  }

  @Test public void nthTest() {
    final List<Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    Assert.assertEquals(the.nth(6, x), " #6/2");
  }

  @Test public void lastOfTest() {
    final List<Integer> x = new ArrayList<>();
    // x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    x.add(Integer.valueOf(5));
    for (final Integer ¢ : the.lastOf((Iterable<Integer>) x))
      Assert.assertEquals(¢, Integer.valueOf(5));
  }

  @Test public void onlyOneOfTest() {
    final List<Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    Assert.assertEquals(the.onlyOneOf(x), Integer.valueOf(4));
    azzert.assertTrue(the.onlyOneOf(null) == null);
    x.add(Integer.valueOf(5));
    Assert.assertEquals(the.onlyOneOf(x), null);
  }

  @Test public void listTest() {
    @Nullable final List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable final List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    azzert.assertTrue(the.penultimateOf(null) == null);
    azzert.assertTrue(the.penultimateOf(y) == null);
    Assert.assertEquals(the.penultimateOf(x), Integer.valueOf(4));
    azzert.assertTrue(the.previous(Integer.valueOf(5), null) == null);
    azzert.assertTrue(the.previous(Integer.valueOf(4), x) == null);
    azzert.assertTrue(the.previous(Integer.valueOf(5), x) != null);
    azzert.assertTrue(the.headOf(null) == null);
    azzert.assertTrue(the.headOf(new ArrayList<>()) == null);
    azzert.assertTrue(the.lastOf(new ArrayList<>()) == null);
    azzert.assertTrue(the.lastOf((List<Object>) null) == null);
    Assert.assertEquals(the.lastOf(y), Integer.valueOf(5));
    Assert.assertEquals(the.previous(Integer.valueOf(5), x), Integer.valueOf(4));
    Assert.assertEquals(the.secondOf(x), Integer.valueOf(5));
    azzert.assertTrue(the.secondOf(null) == null);
    azzert.assertTrue(the.secondOf(y) == null);
    Assert.assertEquals(the.rest(Integer.valueOf(3), x), an.empty.list());
    Assert.assertEquals(the.rest(Integer.valueOf(4), x), y);
  }

  @Test public void charTest() {
    azzert.assertEquals(the.characterOf("hello"), 'o');
    azzert.assertEquals(the.ith("hello", 2), 'l');
  }
}
