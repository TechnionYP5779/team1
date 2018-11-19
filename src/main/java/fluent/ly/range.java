package fluent.ly;

import static fluent.ly.box.*;

import java.util.*;
// import java.util.stream.*;

import org.jetbrains.annotations.*;

// import il.org.spartan.utils.*;
public class range {
  public static DidTo numbers = range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
  boolean empty;
  int from = -1;
  int to = -1;
  boolean infinite;
  int delta = 1;

  /** Instantiates from beginning and end locations
   * @param from JD
   * @param to JD */
  public range(final int from, final int to) {
    this.from = from;
    this.to = to;
    this.infinite = false;
    this.empty = from > to;
  }

  /** Instantiates using values found in another instance
   * @param other other */
  public range(final @NotNull range other) {
    this(other.from, other.to);
  }

  // Default c'tor for fluent API
  public range() {
  }

  public int from() {
    return from;
  }

  @Override public int hashCode() {
    // Cantor pairing function
    return (int) (from + 0.5 * (to + from) * (to + from + 1));
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ instanceof range && from == ((range) ¢).from && to == ((range) ¢).to;
  }

  public boolean isInfinite() {
    // TODO Auto-generated method stub
    return infinite;
  }

  @Nullable public range findIncludedIn(final @Nullable Iterable<? extends range> ¢) {
    if (¢ != null)
      for (final @Nullable range $ : ¢)
        if ($ != null && includedIn($))
          return $;
    return null;
  }

  /** @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> is
   *         included in the parameter. */
  public boolean includedIn(final @NotNull range ¢) {
    return from >= ¢.from && to <= ¢.to;
  }

  public boolean isEmpty() {
    return size() <= 0;
  }

  @NotNull public range merge(final @NotNull range ¢) {
    return new range(Math.min(from, ¢.from), Math.max(to, ¢.to));
  }

  /** Determine whether overlaps in any part another range
   * @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code>
   *         overlaps the parameter. */
  public boolean overlapping(final @NotNull range ¢) {
    return from >= ¢.from || to <= ¢.to;
  }

  /** Prune all ranges in a given list that include this object.
   * @param rs JD */
  public void pruneIncluders(final @NotNull List<range> rs) {
    for (;;) {
      final @Nullable range r = findIncludedIn(rs);
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

  // Fluent API - after from (range.from(x) product) c'tor
  public static DidFrom from(final int ¢) {
    return new range() {
      {
        from = ¢;
        empty = false;
        infinite = true;
      }
    }.new DidFrom();
  }

  // Fluent API - Public class that will allow range iteration
  abstract class rangeIter<T extends rangeIter<T>> implements Iterable<Integer> {
    @Override public Iterator<Integer> iterator() {
      return new Iterator<>() {
        int current = from;

        @Override public boolean hasNext() {
          return infinite || current < to;
        }

        @Override public Integer next() {
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = current;
          current += delta;
          return box($);
        }
      };
    }

    abstract T This();
  }

  // Fluent API - Represents a creation using range.to(x) or range.to(x).from(y)
  // or range.from(x).to(y)
  public class DidTo extends rangeIter<DidTo> {
    @Override DidTo This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public Integer from() {
      return to == from ? null : box(from);
    }

    public DidTo from(final int ¢) {
      return new DidTo() {
        {
          delta = 1;
          to += 1;
          from = ¢;
          infinite = empty = false;
        }
      };
    }

    public DidTo interset(final DidFrom ¢) {
      return range.from(¢.from()).to(to);
    }

    public boolean includes(final int ¢) {
      // TODO Auto-generated method stub
      return ¢ < to && ¢ >= from;
    }
  }

  // Fluent API - Represents a creation using range.from(x)
  public class DidFrom extends rangeIter<DidFrom> {
    public DidTo to(final int ¢) {
      to = ¢;
      return new DidTo() {
        {
          infinite = false;
          to = ¢;
        }
      };
    }

    @Override DidFrom This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public int from() {
      // TODO Auto-generated method stub
      return from;
    }
  }

  // Fluent API - Represents a creation using range.to(x)
  public static DidTo to(final int ¢) {
    return new range() {
      {
        from = to = ¢ - 1;
        infinite = true;
        delta = -1;
      }
    }.new DidTo();
  }
}
