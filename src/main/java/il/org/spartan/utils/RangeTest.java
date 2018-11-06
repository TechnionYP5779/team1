package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class RangeTest {
  @Test @SuppressWarnings("static-method") public void testHashCode() {
    assertEquals(7, (new Range(1, 2)).hashCode());
  }

  @Test @SuppressWarnings("static-method") public void testEqualsObject() {
    Range range = new Range(3, 10), range2 = new Range(5, 10), range3 = new Range(3, 8), range4 = new Range(2, 4), equal = new Range(3, 10),
        copy = new Range(range);
    assert !range.equals(new Object());
    assert !range.equals(range2);
    assert !range.equals(range3);
    assert !range.equals(range4);
    assert range.equals(equal);
    assert range.equals(copy);
  }

  @Test @SuppressWarnings("static-method") public void testFindIncludedIn() {
    Range range1 = new Range(2, 5), range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
    ArrayList<Range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    assertNotEquals(null, toFindSucc.findIncludedIn(rangeList));
    assertEquals(range1, toFindSucc.findIncludedIn(rangeList));
    assertEquals(null, toFindFail.findIncludedIn(rangeList));
    assertEquals(null, toFindFail.findIncludedIn(null));
    rangeList.add(null);
    assertEquals(range1, toFindSucc.findIncludedIn(rangeList));
  }

  @Test @SuppressWarnings("static-method") public void testIncludedIn() {
    Range contained = new Range(5, 8), container = new Range(3, 10);
    assert contained.includedIn(container);
    assert !container.includedIn(contained);
  }

  @Test @SuppressWarnings("static-method") public void testIsEmpty() {
    Range notEmpty = new Range(2, 3);
    assert new Range(2, 2).isEmpty();
    assert !notEmpty.isEmpty();
  }

  @Test @SuppressWarnings("static-method") public void testMerge() {
    Range small = new Range(2, 5), big = new Range(3, 8), incorrect = new Range(3, 5);
    assert small.merge(big).equals(new Range(2, 8));
    assert !small.merge(big).equals(incorrect);
  }

  @Test @SuppressWarnings("static-method") public void testOverlapping() {
    Range main = new Range(2, 5), comingFromLeft = new Range(1, 3), comingFromRight = new Range(4, 10), container = new Range(1, 8),
        unrelated = new Range(8, 10);
    assert !main.overlapping(new Range(3, 4));
    assert main.overlapping(comingFromLeft);
    assert main.overlapping(comingFromRight);
    assert main.overlapping(container);
    assert main.overlapping(unrelated);
  }

  @Test @SuppressWarnings("static-method") public void testPruneIncluders() {
    Range range1 = new Range(2, 5), range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
    ArrayList<Range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    assertEquals(2, rangeList.size());
    toFindSucc.pruneIncluders(rangeList);
    assertEquals(1, rangeList.size());
    toFindFail.pruneIncluders(rangeList);
    assertEquals(1, rangeList.size());
  }

  @Test @SuppressWarnings("static-method") public void testSize() {
    Range range2 = new Range(2, 2), range3 = new Range(5, 4);
    assertEquals(8, new Range(2, 10).size());
    assertEquals(0, range2.size());
    assertEquals(-1, range3.size());
  }

  @Test @SuppressWarnings("static-method") public void testToString() {
    assertEquals(new Range(2, 10) + "", "[2, 10]");
  }
}
