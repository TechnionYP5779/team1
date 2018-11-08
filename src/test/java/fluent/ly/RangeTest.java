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
    assert !range.equals(new Object());
    assert !range.equals(range2);
    assert !range.equals(range3);
    assert !range.equals(range4);
    assert range.equals(equal);
    assert range.equals(copy);
  }

  @Test public void findIncludedIn() {
    Range range1 = new Range(2, 5), range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
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
    assert contained.includedIn(container);
    assert !container.includedIn(contained);
  }

  @Test public void isEmpty() {
    Range notEmpty = new Range(2, 3);
    assert new Range(2, 2).isEmpty();
    assert !notEmpty.isEmpty();
  }

  @Test public void merge() {
    Range small = new Range(2, 5), big = new Range(3, 8), incorrect = new Range(3, 5);
    assert small.merge(big).equals(new Range(2, 8));
    assert !small.merge(big).equals(incorrect);
  }

  @Test public void overlapping() {
    Range main = new Range(2, 5), comingFromLeft = new Range(1, 3), comingFromRight = new Range(4, 10), container = new Range(1, 8),
        unrelated = new Range(8, 10);
    assert !main.overlapping(new Range(3, 4));
    assert main.overlapping(comingFromLeft);
    assert main.overlapping(comingFromRight);
    assert main.overlapping(container);
    assert main.overlapping(unrelated);
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
