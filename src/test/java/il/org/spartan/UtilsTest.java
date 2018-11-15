package il.org.spartan;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

/**
 * [[SuppressWarningsSpartan]]
 */
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
      azzert.assertNotNull(Utils.apply(λ->λ).to(y));
      azzert.assertNotNull(Utils.apply(λ->λ).to(yy));
      azzert.assertNotNull(Utils.apply(λ->λ).to(new Object()));
      azzert.xassertEquals(0, Utils.hash(null));
      Object o = new Object();
      azzert.xassertEquals(Utils.hash(o), o.hashCode());
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
      azzert.assertTrue(Utils.inRange(0, y));
      azzert.assertFalse(Utils.inRange(-70, y));
      azzert.assertFalse(Utils.inRange(5, y));
      azzert.assertTrue(Utils.intIsIn(1,1, 2,3));
      azzert.assertFalse(Utils.intIsIn(606,1, 2,3));
      azzert.assertTrue(Utils.lastIn(Integer.valueOf(5),x));
      azzert.assertFalse(Utils.lastIn(Integer.valueOf(2),x));
      azzert.assertTrue(Utils.lastIn(Integer.valueOf(5),x));
      @Nullable List<@Nullable Integer> z = new ArrayList<>();
      z.add(Integer.valueOf(4));
      z.add(Integer.valueOf(5));
      Utils.removeDuplicates(z);
      azzert.assertFalse(Utils.penultimateIn(Integer.valueOf(5),z));
      azzert.assertTrue(Utils.penultimateIn(Integer.valueOf(4),z));
    }
    
    @Test public void utilTesting() {
      
      azzert.assertNotNull(Utils.canBeNull(Integer.valueOf(3)));
//      azzert.assertNotNull(Utils.apply(λ->λ).to(Integer.valueOf(1),));
      azzert.assertEquals(0,Utils.compare(true, true));
      azzert.assertEquals(-1,Utils.compare(false, true));
      azzert.assertEquals(1,Utils.compare(true, false));
      azzert.assertEquals(Utils.sqr(1.0),1.0,0);
      azzert.assertTrue(Utils.found(5).in(1,2,3,4,5));
      azzert.assertFalse(Utils.found(6).in(1,2,3,4,5));
      azzert.assertNotNull(Utils.found(Integer.valueOf(5)));
    
     azzert.assertNotNull(Utils.sort(new int @NotNull [] { 1, 2, 3, 4 }));
      
    }
    
    @Test public void stringTesting() {
      azzert.assertEquals(Utils.compressSpaces("HHH            HHH"), "HHH HHH");
      azzert.assertTrue(Utils.contains("HHH            HHH", "HHH"));
      azzert.assertFalse(Utils.contains("HHH            HHH", "HgHH"));
      azzert.assertEquals(Utils.name(new File("Hi")), new File("Hi").getName());
      List< String> X = new ArrayList<>();
      azzert.assertFalse(Utils.suffixedBy(new File("Hi"), X));
      azzert.assertFalse(Utils.suffixedBy(new File("Hi"), "HHH"));
      X.add("Hi");
      azzert.assertTrue(Utils.suffixedBy(new File("Hi"), X));
      azzert.assertTrue(Utils.suffixedBy(new File("Hi"), "Hi"));
      azzert.assertEquals(Utils.prepend(new StringBuilder(), 'c') + "","c");
      azzert.assertEquals(Utils.prepend(new StringBuilder(), "ac") + "","ac");
      azzert.assertEquals(Utils.prepend(new StringBuilder(), "ac") + "","ac");
      azzert.assertEquals(Utils.quote("ac"),"'ac'");
      azzert.assertEquals(Utils.quote(null),"<null reference>");
      azzert.assertEquals(Utils.removePrefix("Maaaaaaaa", "M"),"aaaaaaaa");
      azzert.assertEquals(Utils.removeSuffix("Maaaaaaaa", "aaaaaaaa"),"M");
      azzert.assertEquals(Utils.removeWhites("  "),"");
      
     
    }

}

