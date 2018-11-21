package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class pruneTest {
//
//  @Nullable final String @NotNull [] alternatingArray = new @Nullable String @NotNull [] { null, "A", null, null, "B", null, null, null, "C", null };
//  @NotNull final String @NotNull [] nonNullArray = { "1", "2", "4" };
  @NotNull final Supplier<List<String>> x = () -> {
    final List<String> $ = an.empty.list();
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    $.add("A");
    $.add(null);
    $.add(null);
    $.add(null);
    $.add("B");
    $.add(null);
    $.add("C");
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    return $;
  };
//  @NotNull private final List<String> sparseCollection = new Supplier<List<String>>() {
//    @Override @NotNull public List<String> get() {
//      @NotNull final List<String> $ = an.empty.list();
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      $.add("A");
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      $.add("B");
//      $.add(null);
//      $.add("C");
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      $.add(null);
//      return $;
//    }
//  }.get();

  @Test public void testNotNullArrayItems() {
    azzert.that(prune.nulls(nonNullArray)[0], is("1"));
    azzert.that(prune.nulls(nonNullArray)[1], is("2"));
    azzert.that(prune.nulls(nonNullArray)[2], is("4"));
  }

  @Test public void testNotNullArrayLength() {
    azzert.that(prune.nulls(nonNullArray).length, is(nonNullArray.length));
  }

  @Test public void testPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(alternatingArray)[0], is("A"));
    azzert.that(prune.nulls(alternatingArray)[1], is("B"));
    azzert.that(prune.nulls(alternatingArray)[2], is("C"));
  }

  @Test public void testPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(alternatingArray).length, is(3));
  }

  @Test public void testPruneSparseCollectionContents() {
    final @NotNull String[] a = prune.nulls(sparseCollection).toArray(new @NotNull String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void testPruneSparseCollectionLength() {
    azzert.that(prune.nulls(sparseCollection).size(), is(3));
  }

  @Test public void testPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void testShrink() {
    azzert.that(prune.shrink(new Object[10]).length, is(0));
  }
  
  @Nullable final String @NotNull [] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String @NotNull [] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    azzert.that(nonNullArray.length, is(prune.nulls(nonNullArray).length));
  }

  @Test public void nullsNullArrayItems() {
    azzert.that("1", is(prune.nulls(nonNullArray)[0]));
    azzert.that("2", is(prune.nulls(nonNullArray)[1]));
    azzert.that("4", is(prune.nulls(nonNullArray)[2]));
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    azzert.that("A", is(prune.nulls(alternatingArray)[0]));
    azzert.that("B", is(prune.nulls(alternatingArray)[1]));
    azzert.that("C", is(prune.nulls(alternatingArray)[2]));
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    azzert.that(3, is(prune.nulls(alternatingArray).length));
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that("A", is(a[0]));
    azzert.that("B", is(a[1]));
    azzert.that("C", is(a[2]));
    azzert.that(3, is(a.length));
  }

  @Test public void nullsPruneSparseCollectionLength() {
    azzert.that(3, is(prune.nulls(sparseCollection).size()));
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void shrinkArray() {
    azzert.that(0, is(prune.shrink(new Object[10]).length));
  }

  @Test public void shrinkEmptyArray() {
    azzert.that(0, is(prune.shrink(new Object[0]).length));
  }

  @Test public void whitesEmptyArray() {
    azzert.that(0, is(prune.whites().length));
  }

  @Test public void whitesEmptyList() {
    azzert.that(0, is(prune.whites().length));
  }
}