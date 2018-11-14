package il.org.spartan.iterables;

import java.util.*;
import org.junit.*;
import fluent.ly.*;

@SuppressWarnings({"static-method" , "boxing"}) public class iterablesTest {
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
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(1);
    nums2.add(1);    
    azzert.aye(iterables.alternate(nums1,nums2).iterator().hasNext());
  }
  
  @Test public void testFirstIsFromFirstIterable() {
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(1);
    nums2.add(2);
    azzert.assertEquals(1,iterables.alternate(nums1,nums2).iterator().next());
  }
  
  @Test public void testSecondIsFromSecondIterable() {
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(1);
    nums2.add(2);
    Iterator<Integer> ite = iterables.alternate(nums1,nums2).iterator();
    ite.next();
    azzert.assertEquals(2,ite.next());
  }
  
  @Test public void testEmptyFirstListResultsInEmptyIterable() {
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums2.add(2);
    nums2.add(3);
    azzert.nay(iterables.alternate(nums1,nums2).iterator().hasNext());
  }
  
  @Test public void testSizeOfIterableIsTwiceTheMinLenOfTheArguments() {
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(1);
    nums1.add(2);
    nums2.add(3);
    nums2.add(4);
    nums2.add(5);
    nums2.add(6);
    Iterator<Integer> ite = iterables.alternate(nums1,nums2).iterator();
    for(int ¢ = 0; ¢ < 2*Math.min(nums1.size(), nums2.size()); ++¢)
      ite.next();
    azzert.nay(ite.hasNext());
  }
  
  @Test @SuppressWarnings("static-access") public void testAlternatesBetweenIterables() {
    List<Integer> nums1 = new ArrayList<>(), nums2 = new ArrayList<>();
    nums1.add(1);
    nums1.add(2);
    nums2.add(3);
    nums2.add(4);
    nums2.add(5);
    nums2.add(6);
    Iterator<Integer> ite1 = nums1.iterator(), ite2 = nums2.iterator(), ite = iterables.alternate(nums1, nums2).iterator();
    for (boolean first = true; ite.hasNext(); first = !first)
      azzert.assertEquals(ite.next(), (first ? ite1 : ite2).next());
  }
  
  
  
  
}