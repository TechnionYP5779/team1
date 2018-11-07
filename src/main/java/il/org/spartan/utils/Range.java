package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** An immutable integral range, representing all integers between
 * {@link #from}, up to, but not including, {@link #to}, i.e.,
 *
 * <pre>
 * {@link #from}, {@link #from}+1, ..., {@link #to}-1
 * </pre>
 *
 * @author Boris van Sosin <code><boris.van.sosin [at] gmail.com></code>
 * @since 2012 */
public class Range {
  /** the beginning of the range (inclusive) */
  public final int from;
  /** the end of the range (exclusive) */
  public final int to;

  /** Instantiates from beginning and end locations
   * @param from JD
   * @param to   JD */
  public Range(final int from, final int to) {
    this.from = from;
    this.to = to;
  }

  /** Instantiates using values found in another intance
   * @param other other */
  public Range(final @NotNull Range other) {
    this(other.from, other.to);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ instanceof Range && from == ((Range) ¢).from && to == ((Range) ¢).to;
  }

  @Nullable public Range findIncludedIn(final @Nullable Iterable<? extends Range> ¢) {
    if (¢ != null)
      for (final @Nullable Range $ : ¢)
        if ($ != null && includedIn($))
          return $;
    return null;
  }

  @Override public int hashCode() {
    // Cantor pairing function
    return (int) (from + 0.5 * (to + from) * (to + from + 1));
  }

  /** @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> is
   *         included in the parameter. */
  public boolean includedIn(final @NotNull Range ¢) {
    return from >= ¢.from && to <= ¢.to;
  }

  public boolean isEmpty() {
    return size() <= 0;
  }

  @NotNull public Range merge(final @NotNull Range ¢) {
    return new Range(Math.min(from, ¢.from), Math.max(to, ¢.to));
  }

  /** Determine whether overlaps in any part another range
   * @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> overlaps
   *         the parameter. */
  public boolean overlapping(final @NotNull Range ¢) {
    return from >= ¢.from || to <= ¢.to;
  }

  /** Prune all ranges in a given list that include this object.
   * @param rs JD */
  public void pruneIncluders(final @NotNull List<Range> rs) {
    for (;;) {
      final @Nullable Range r = findIncludedIn(rs);
      if (r == null)
        return;
      rs.remove(r);
    }
  }

  /** The number of integers in the range
   * @return a non-negative integer, computed as {@link #to} -{@link #from} */
  public int size() {
    return to - from;
  }

  @Override public String toString() {
    return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(to));
  }
  
  public  @SuppressWarnings("static-method")  static class TEST{
    @Test public void testHashCode() {
      assertEquals(7, (new Range(1, 2)).hashCode());
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
      Range range1 = new Range(2, 5);
      Range range2 = new Range(1, 3), toFindSucc = new Range(3, 4), toFindFail = new Range(5, 6);
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
      assertEquals(2, rangeList.size());
      toFindSucc.pruneIncluders(rangeList);
      assertEquals(1, rangeList.size());
      toFindFail.pruneIncluders(rangeList);
      assertEquals(1, rangeList.size());
    }

    @Test public void size() {
      Range range2 = new Range(2, 2), range3 = new Range(5, 4);
      assertEquals(8, new Range(2, 10).size());
      assertEquals(0, range2.size());
      assertEquals(-1, range3.size());
    }

    @Test public void tostring() {
      assertEquals(new Range(2, 10) + "", "[2, 10]");
    }
  }
}