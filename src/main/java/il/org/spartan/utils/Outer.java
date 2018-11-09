package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-03-21 */
public class Outer<Inner> {
  public Inner inner;

  public Outer(final Inner inner) {
    this.inner = inner;
    if (inner == null || inner == this)
      throw new IllegalArgumentException();
  }

  @Override @NotNull @SuppressWarnings("unchecked") public Outer<Inner> clone() throws CloneNotSupportedException {
    return (Outer<Inner>) Utils.cantBeNull(super.clone());
  }

  @Override public boolean equals(final Object ¢) {
    if (¢ == this)
      return true;
    if (¢ == null || getClass() != ¢.getClass())
      return false;
    @SuppressWarnings("unchecked") final Outer<Inner> $ = (Outer<Inner>) ¢;
    return equals($);
  }

  @SuppressWarnings("null") protected boolean equals(final Outer<Inner> other) {
    if (inner == null) {
      if (other.inner != null)
        return false;
    } else if (!inner.equals(other.inner))
      return false;
    return true;
  }

  /** @return value wrapped in this object. */
  public Inner get() {
    return inner;
  }

  @Override @SuppressWarnings("null") public int hashCode() {
    return inner == null ? 0 : inner.hashCode();
  }

  /** set current value */
  public void set(final Inner ¢) {
    this.inner = ¢;
  }

  @Override @NotNull public String toString() {
    return inner == null ? "null" : Utils.cantBeNull(inner + "");
  }
}
