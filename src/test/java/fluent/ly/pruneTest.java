package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) //
public class pruneTest {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    assertEquals(nonNullArray.length, prune.nulls(nonNullArray).length);
  }

  @Test public void nullsNullArrayItems() {
    assertEquals("1", prune.nulls(nonNullArray)[0]);
    assertEquals("2", prune.nulls(nonNullArray)[1]);
    assertEquals("4", prune.nulls(nonNullArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    assertEquals("A", prune.nulls(alternatingArray)[0]);
    assertEquals("B", prune.nulls(alternatingArray)[1]);
    assertEquals("C", prune.nulls(alternatingArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    assertEquals(3, prune.nulls(alternatingArray).length);
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    assertEquals("A", a[0]);
    assertEquals("B", a[1]);
    assertEquals("C", a[2]);
    assertEquals(3, a.length);
  }

  @Test public void nullsPruneSparseCollectionLength() {
    assertEquals(3, prune.nulls(sparseCollection).size());
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void shrinkArray() {
    assertEquals(0, prune.shrink(new Object[10]).length);
  }

  @Test public void shrinkEmptyArray() {
    assertEquals(0, prune.shrink(new Object[0]).length);
  }

  @Test public void whitesEmptyArray() {
    assertEquals(0, prune.whites().length);
  }

  @Test public void whitesEmptyList() {
    assertEquals(0, prune.whites().length);
  }
}