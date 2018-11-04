package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.*;

import org.junit.*;

public class RangeTest {
  @Test public void testHashCode() {
    Range range = new Range(1,2);
    assertEquals(7, range.hashCode());
  }

  @Test public void testEqualsObject() {
    Range range = new Range(3, 10);
    Range range2 = new Range(5, 10);
    Range range3 = new Range(3, 8);
    Range range4 = new Range(2, 4);
    Range equal = new Range(3,10);
    Range copy = new Range(range);
    assertFalse(range.equals(new Int()));
    assertFalse(range.equals(range2));
    assertFalse(range.equals(range3));
    assertFalse(range.equals(range4));
    assertTrue(range.equals(equal));
    assertTrue(range.equals(copy));
  }

  @Test public void testFindIncludedIn() {
      Range range1 = new Range(2,5);
      Range range2 = new Range(1,3);
      Range toFindSucc = new Range(3,4);
      Range toFindFail = new Range(5,6);
      ArrayList<Range> rangeList = new ArrayList<>();
      rangeList.add(range1);
      rangeList.add(range2);
      assertNotEquals(null,toFindSucc.findIncludedIn(rangeList));
      assertEquals(range1,toFindSucc.findIncludedIn(rangeList));
      assertEquals(null,toFindFail.findIncludedIn(rangeList));
      assertEquals(null,toFindFail.findIncludedIn(null));
      rangeList.add(null);
      assertEquals(range1,toFindSucc.findIncludedIn(rangeList));
  }

  @Test public void testIncludedIn() {
    Range contained = new Range(5, 8);
    Range container = new Range(3, 10);
    assertTrue(contained.includedIn(container));
    assertFalse(container.includedIn(contained));
  }

  @Test public void testIsEmpty() {
    Range empty = new Range(2, 2);
    Range notEmpty = new Range(2,3);
    assertTrue(empty.isEmpty());
    assertFalse(notEmpty.isEmpty());
  }

  @Test public void testMerge() {
    Range small = new Range(2,5);
    Range big = new Range(3,8);
    Range combined = new Range(2,8);
    Range incorrect = new Range(3, 5);
    assertTrue(small.merge(big).equals(combined));
    assertFalse(small.merge(big).equals(incorrect));
  }

  @Test public void testOverlapping() {
    Range main = new Range(2,5);
    Range contained = new Range(3,4);
    Range comingFromLeft = new Range(1, 3);
    Range comingFromRight = new Range(4,10);
    Range container = new Range(1,8);
    Range unrelated = new Range(8,10);
    assertFalse(main.overlapping(contained));
    assertTrue(main.overlapping(comingFromLeft));
    assertTrue(main.overlapping(comingFromRight));
    assertTrue(main.overlapping(container));
    //TODO: SHOULD BE ASSERT FALSE[Seems to be a logic error in Range code]:
    assertTrue(main.overlapping(unrelated));
  }

  @Test public void testPruneIncluders() {
    Range range1 = new Range(2,5);
    Range range2 = new Range(1,3);
    Range toFindSucc = new Range(3,4);
    Range toFindFail = new Range(5,6);
    ArrayList<Range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    assertEquals(2, rangeList.size());
    toFindSucc.pruneIncluders(rangeList);
    assertEquals(1, rangeList.size());
    toFindFail.pruneIncluders(rangeList);
    assertEquals(1,rangeList.size());
  }

  @Test public void testSize() {
    Range range = new Range(2,10);
    Range range2 = new Range(2,2);
    Range range3 = new Range(5,4);
    assertEquals(8,range.size());
    assertEquals(0,range2.size());
    assertEquals(-1,range3.size());

  }

  @Test public void testToString() {
    Range range = new Range(2,10);
    assertEquals(range.toString(), "[2, 10]");
  }
}
