package il.org.spartan.iterables;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

@SuppressWarnings("static-method") public class iterablesTest {
  @Test public void test() {
    iterables.alternate(new ArrayList<>(), new ArrayList<>());
  }

  @Test public void testNonIntegerLists() {
    iterables.alternate(new ArrayList<>(), new ArrayList<>());
  }

  @Test public void testMethodReturnsNonNullObject() {
    azzert.aye(iterables.alternate(new ArrayList<>(), new ArrayList<>()) != null);
  }

  @Test public void testEmptyIterablesReturnEmptyIterable() {
    azzert.nay(iterables.alternate(new ArrayList<>(), new ArrayList<>()).iterator().hasNext());
  }

  @Test public void testNonEmptyIterablesReturnNonEmptyIterable() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(box(1));
    nums2.add(box(1));
    azzert.aye(iterables.alternate(nums1, nums2).iterator().hasNext());
  }

  @Test public void testFirstIsFromFirstIterable() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(box(1));
    nums2.add(box(2));
    azzert.assertEquals(1, iterables.alternate(nums1, nums2).iterator().next());
  }

  @Test public void testSecondIsFromSecondIterable() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(box(1));
    nums2.add(box(2));
    final Iterator<Integer> ite = iterables.alternate(nums1, nums2).iterator();
    ite.next();
    azzert.assertEquals(2, ite.next());
  }

  @Test public void testEmptyFirstListResultsInEmptyIterable() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums2.add(box(2));
    nums2.add(box(3));
    azzert.nay(iterables.alternate(nums1, nums2).iterator().hasNext());
  }

  @Test public void testSizeOfIterableIsTwiceTheMinLenOfTheArguments() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(box(1));
    nums1.add(box(2));
    nums2.add(box(3));
    nums2.add(box(4));
    nums2.add(box(5));
    nums2.add(box(6));
    final Iterator<Integer> ite = iterables.alternate(nums1, nums2).iterator();
    for (int ¢ = 0; ¢ < 2 * Math.min(nums1.size(), nums2.size()); ++¢)
      ite.next();
    azzert.nay(ite.hasNext());
  }

  @Test public void testAlternatesBetweenIterables() {
    final List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(box(1));
    nums1.add(box(2));
    nums2.add(box(3));
    nums2.add(box(4));
    nums2.add(box(5));
    nums2.add(box(6));
    final Iterator<Integer> ite1 = nums1.iterator(), ite2 = nums2.iterator(), ite = iterables.alternate(nums1, nums2).iterator();
    for (boolean first = true; ite.hasNext(); first = !first)
      Assert.assertEquals(ite.next(), (first ? ite1 : ite2).next());
  }

  @Test public void testCount() {
    assert iterables.count(null) == 0;
    final List<Integer> nums = new ArrayList<>();
    nums.add(box(1));
    nums.add(box(2));
    azzert.assertEquals(iterables.count(nums), nums.size());
    nums.add(box(3));
    azzert.assertEquals(iterables.count(nums), nums.size());
    nums.remove(box(1));
    azzert.assertEquals(iterables.count(nums), nums.size());
  }

  @Test public void testIsEmpty() {
    final List<Integer> nums = new ArrayList<>();
    nums.add(box(1));
    final List<Integer> nums2 = new ArrayList<>();
    nums2.add(null);
    azzert.assertEquals(iterables.isEmpty(nums2), true);
    azzert.assertEquals(iterables.isEmpty(nums), false);
    azzert.assertEquals(iterables.isEmpty(new ArrayList<Integer>()), true);
  }
  
  @Test public void singletonIteratorTest() {
    azzert.assertEquals(iterables.singletonIterator(box(1)).next(),1);
  }
}