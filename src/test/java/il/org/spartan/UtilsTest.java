package il.org.spartan;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings({ "static-access", "static-method"})public class UtilsTest {
    @NotNull public static Integer[] intToIntegers(final  int... is) {
      final  @NotNull Integer @NotNull [] $ = new  @NotNull Integer @NotNull [is.length];
      for (int ¢ = 0; ¢ < is.length; ++¢)
        $[¢] = fluent.ly.box.it(is[¢]);
      return $;
    }

    @Test @SuppressWarnings("unchecked") public void addAllTypical() {
      final Set< String> ss = new HashSet<>();
      accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
      azzert.nay(ss.contains("E"));
      azzert.nay(ss.contains(null));
      azzert.that(ss.size(), is(4));
      for (final String ¢ : ss)
        azzert.aye("", ss.contains(¢));
    }

    @Test public void addTypical() {
      final Set<String> ss = new HashSet<>();
      accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
      azzert.nay(ss.contains("E"));
      azzert.nay(ss.contains(null));
      azzert.that(ss.size(), is(4));
      for (final String ¢ : ss)
        azzert.aye("", ss.contains(¢));
      azzert.aye(ss.contains("A"));
    }

    @Test public void cantBeNullOfNull() {
      try {
        Utils.cantBeNull(null);
        azzert.fail("AssertionError expected prior to this line.");
      } catch (final AssertionError ¢) {
        forget.it(¢);
        azzert.aye("", true);
      }
    }

    @Test public void cantBeNullTypical() {
      assert Utils.cantBeNull(new Object()) != null;
    }

    @Test public void isNullTypical() {
      try {
        isNull(Utils.mustBeNull(null));
        azzert.fail("AssertionError expected prior to this line.");
      } catch (final AssertionError ¢) {
        forget.it(¢);
        azzert.aye("", true);
      }
    }

    @Test public void mustBeNullOfNotNull() {
      try {
        Utils.mustBeNull(new Object());
        azzert.fail("AssertionError expected prior to this line.");
      } catch (final AssertionError ¢) {
        forget.it(¢);
        azzert.aye("", true);
      }
    }

    @Test public void quoteEmptyString() {
      azzert.that(idiomatic.quote(""), is("''"));
    }

    @Test public void quoteNull() {
      azzert.that(idiomatic.quote(null), is("<null reference>"));
    }

    @Test public void quoteSimpleString() {
      azzert.that(idiomatic.quote("A"), is("'A'"));
    }

    @Test public void swapDegenerate() {
      final @NotNull String [] ss = as.array("A", "B", "C", "D");
      Utils.swap(ss, 1, 1);
      assertArrayEquals(as.array("A", "B", "C", "D"), ss);
    }

    @Test public void swapTypical() {
      final @NotNull String [] ss = as.array("A", "B", "C", "D");
      Utils.swap(ss, 1, 2);
      assertArrayEquals(as.array("A", "C", "B", "D"), ss);
    }

    @Test public void swapTypicalCase() {
      final @NotNull Integer [] $ = intToIntegers( 29, 1, 60);
      Utils.swap($, 0, 1);
      assertArrayEquals(intToIntegers(1, 29, 60), $);
    }
    
    @Test public void collectionTesting() {
      List< Integer> x = new ArrayList<>();
      x.add(Integer.valueOf(4));
      x.add(Integer.valueOf(5));
       List< Integer> y = new ArrayList<>();
      y.add(Integer.valueOf(5));
       List< Integer> yy = new ArrayList<>();
      yy.add(null);
      
       List<List< Integer>> X = new ArrayList<>();
      azzert.assertEquals(Utils.add(X,x),X);
      x.add(null);
      azzert.assertEquals(Utils.add(X,yy),X);
      azzert.assertEquals(Utils.add(x,y),x);
      azzert.assertEquals(Utils.addAll(X,yy),X);
      azzert.assertEquals(Utils.addAll(y,yy),y);
      azzert.assertEquals(Utils.addAll(y,(Iterable<Integer>)x),y);
      azzert.assertFalse(Utils.hasNull(yy));
      azzert.assertTrue(Utils.hasNull(Integer.valueOf(1),null));
      azzert.assertNotNull(Utils.append(new @NotNull Integer[0], Integer.valueOf(4))[0]);
//      azzert.assertEquals(,);
      azzert.assertNotNull(Utils.delete(new @NotNull Integer[4],3));
      
    }
    
    @Test public void utilTesting() {
      
      azzert.assertNotNull(Utils.canBeNull(Integer.valueOf(3)));
      azzert.assertNotNull(Utils.apply(null));
      azzert.assertEquals(0,Utils.compare(true, true));
      azzert.assertEquals(-1,Utils.compare(false, true));
      azzert.assertEquals(1,Utils.compare(true, false));
      azzert.assertEquals(Utils.compressSpaces("HHH            HHH"), "HHH HHH");
      
      azzert.assertTrue(Utils.contains("HHH            HHH", "HHH"));
      azzert.assertFalse(Utils.contains("HHH            HHH", "HgHH"));
      azzert.assertNotNull(Utils.found(5));
      azzert.assertNotNull(Utils.found(Integer.valueOf(5)));
    }

}

