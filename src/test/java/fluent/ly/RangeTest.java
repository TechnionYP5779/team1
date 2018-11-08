package fluent.ly;


import java.util.*;
import org.junit.*;
import il.org.spartan.utils.*;

@SuppressWarnings({"static-method","static-access"})
public class RangeTest {
  @Test public void testHashCode() {
    azzert.assertEquals(7, (new Range(1, 2)).hashCode());
  }

  @Test public void equalsObject() {
    Range range = new Range(3, 10), range2 = new Range(5, 10), range3 = new Range(3, 8), range4 = new Range(2, 4), equal = new Range(3, 10),
        copy = new Range(range);
    azzert.assertFalse(range.equals(new Object()));
    azzert.assertFalse(range.equals(range2));
    azzert.assertFalse(range.equals(range3));
    azzert.assertFalse(range.equals(range4));
    azzert.assertTrue( range.equals(equal));
    azzert.assertTrue( range.equals(copy));
  }

  @Test public void findIncludedIn() {
    Range range1 = new Range(2, 5);
    Range range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
    ArrayList<Range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    azzert.assertNotEquals(null, toFindSucc.findIncludedIn(rangeList));
    azzert.assertEquals(range1, toFindSucc.findIncludedIn(rangeList));
    azzert.assertEquals(null, toFindFail.findIncludedIn(rangeList));
    azzert.assertEquals(null, toFindFail.findIncludedIn(null));
    rangeList.add(null);
    azzert.assertEquals(range1, toFindSucc.findIncludedIn(rangeList));
  }

  @Test public void includedIn() {
    Range contained = new Range(5, 8), container = new Range(3, 10);
    azzert.assertTrue( contained.includedIn(container));
    azzert.assertFalse(container.includedIn(contained));
  }

  @Test public void isEmpty() {
    Range notEmpty = new Range(2, 3);
    azzert.assertTrue( new Range(2, 2).isEmpty());
    azzert.assertFalse(notEmpty.isEmpty());
  }

  @Test public void merge() {
    Range small = new Range(2, 5), big = new Range(3, 8), incorrect = new Range(3, 5);
    azzert.assertTrue( small.merge(big).equals(new Range(2, 8)));
    azzert.assertFalse( small.merge(big).equals(incorrect));
  }

  @Test public void overlapping() {
    Range main = new Range(2, 5), comingFromLeft = new Range(1, 3), comingFromRight = new Range(4, 10), container = new Range(1, 8),
        unrelated = new Range(8, 10);
    azzert.assertTrue( !main.overlapping(new Range(3, 4)));
    azzert.assertTrue( main.overlapping(comingFromLeft));
    azzert.assertTrue( main.overlapping(comingFromRight));
    azzert.assertTrue( main.overlapping(container));
    azzert.assertTrue( main.overlapping(unrelated));
  }

  @Test public void pruneIncluders() {
    Range range1 = new Range(2, 5), range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
    ArrayList<Range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    azzert.assertEquals(2, rangeList.size());
    toFindSucc.pruneIncluders(rangeList);
    azzert.assertEquals(1, rangeList.size());
    toFindFail.pruneIncluders(rangeList);
    azzert.assertEquals(1, rangeList.size());
  }

  @Test public void size() {
    Range range2 = new Range(2, 2), range3 = new Range(5, 4);
    azzert.assertEquals(8, new Range(2, 10).size());
    azzert.assertEquals(0, range2.size());
    azzert.assertEquals(-1, range3.size());
  }

  @Test public void tostring() {
    azzert.assertEquals(new Range(2, 10) + "", "[2, 10]");
  }
}
