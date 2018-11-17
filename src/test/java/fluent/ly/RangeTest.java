package fluent.ly;

import java.util.*;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import org.junit.*;

// import il.org.spartan.utils.*;
@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testHashCode() {
    int i1;
    final range r1 = new range(1, 2);
    i1 = r1.hashCode();
    azzert.that(7, is(i1));
    azzert.that(1, is(r1.from()));
    assert !r1.isInfinite();
  }

  @Test public void equalsObject() {
    final range range = new range(3, 10), range2 = new range(5, 10), range3 = new range(3, 8), range4 = new range(2, 4), equal = new range(3, 10),
        copy = new range(range);
    assert !range.equals(new Object());
    assert !range.equals(range2);
    assert !range.equals(range3);
    assert !range.equals(range4);
    assert range.equals(equal);
    assert range.equals(copy);
  }

  @Test public void findIncludedIn() {
    final range range1 = new range(2, 5), range2 = new range(1, 3), toFindSucc = new range(3, 4), toFindFail = new range(5, 6);
    final ArrayList<range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    azzert.assertNotEquals(null, toFindSucc.findIncludedIn(rangeList));
    azzert.that(range1, is(toFindSucc.findIncludedIn(rangeList)));
    Assert.assertEquals(null, toFindFail.findIncludedIn(rangeList));
    Assert.assertEquals(null, toFindFail.findIncludedIn(null));
    rangeList.add(null);
    azzert.that(range1, is(toFindSucc.findIncludedIn(rangeList)));
  }

  @Test public void includedIn() {
    final range contained = new range(5, 8), container = new range(3, 10);
    assert contained.includedIn(container);
    assert !container.includedIn(contained);
  }

  @Test public void isEmpty() {
    final range notEmpty = new range(2, 3);
    assert new range(2, 2).isEmpty();
    assert !notEmpty.isEmpty();
  }

  @Test public void merge() {
    final range small = new range(2, 5), big = new range(3, 8), incorrect = new range(3, 5);
    assert small.merge(big).equals(new range(2, 8));
    assert !small.merge(big).equals(incorrect);
  }

  @Test public void overlapping() {
    final range main = new range(2, 5), comingFromLeft = new range(1, 3), comingFromRight = new range(4, 10), container = new range(1, 8),
        unrelated = new range(8, 10);
    assert !main.overlapping(new range(3, 4));
    assert main.overlapping(comingFromLeft);
    assert main.overlapping(comingFromRight);
    assert main.overlapping(container);
    assert main.overlapping(unrelated);
  }

  @Test public void pruneIncluders() {
    final range range1 = new range(2, 5), range2 = new range(1, 3), toFindSucc = new range(3, 4), toFindFail = new range(5, 6);
    final ArrayList<range> rangeList = new ArrayList<>();
    rangeList.add(range1);
    rangeList.add(range2);
    azzert.that(2, is(rangeList.size()));
    toFindSucc.pruneIncluders(rangeList);
    azzert.that(1, is(rangeList.size()));
    toFindFail.pruneIncluders(rangeList);
    azzert.that(1, is(rangeList.size()));
  }

  @Test public void size() {
    final range range2 = new range(2, 2), range3 = new range(5, 4);
    azzert.that(8, is(new range(2, 10).size()));
    azzert.that(0, is(range2.size()));
    azzert.that(-1, is(range3.size()));
  }

  @Test public void tostring() {
    azzert.that(new range(2, 10) + "", is("[2, 10]"));
  }

  @Test public void createInfiniteSequence() {
    assert !range.from(2).isEmpty();
    assert range.from(2).isInfinite();
  }

  @Test public void from2fromReturnOrigin() {
    assert range.from(2).from() == 2;
  }

  @Test public void fromTo() {
    int count = 2;
    for (final Integer $ : range.from(2).to(6)) {
      azzert.that(box(count), is($));
      ++count;
    }
  }

  @Test public void onlyTo() {
    assert !range.to(2).isEmpty();
    assert range.to(2).isInfinite();
    int count = 1;
    for (final Integer $ : range.to(2)) {
      // System.out.println($);
      azzert.that(box(count), is($));
      --count;
      if (count == -5)
        break;
    }
  }

  // range.to(2).from() should return a null pointer
  @Test public void toFromFunc() {
    assert range.to(2).from() == null;
  }

  // range.to(2).from(-5) is the range -5, -4, ...,0,1
  @Test public void toFromRange() {
    int count = -5;
    for (final Integer $ : range.to(2).from(-5)) {
      // System.out.println($);
      azzert.that(box(count), is($));
      ++count;
    }
  }

  @Test public void numbersRange() {
    // int count =Integer.MIN_VALUE;
    int count = Integer.MIN_VALUE;
    for (final Integer $ : range.numbers) {
      // System.out.println($);
      azzert.that(box(count), is($));
      ++count;
      if (count == Integer.MIN_VALUE + 5)
        break;
    }
  }

  // range.to(10).interset(range.from(3)) crate the intersection range
  @Test public void rangeintersect() {
    // int count =Integer.MIN_VALUE;
    int count = 3;
    for (final Integer $ : range.to(10).interset(range.from(3))) {
      // System.out.println($);
      azzert.that(box(count), is($));
      ++count;
    }
  }

  // range.from(x).to(y).includes(z) specifiy by yourself.
  @Test public void includestest() {
    assert range.from(1).to(3).includes(2);
    assert !range.from(0).to(3).includes(7);
  }
}
