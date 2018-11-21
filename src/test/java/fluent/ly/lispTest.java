package fluent.ly;

import java.util.*;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static il.org.spartan.Utils.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class lispTest {
  @Test public void chopEmpty() {
    azzert.isNull(lisp.chop(new ArrayList<>()));
  }

  @Test public void chopFirst() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    azzert.that(lisp.chop(list), is(Collections.emptyList()));
  }

  @Test public void cons() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    azzert.that(lisp.cons(box(10), list), is(Arrays.asList(box(10), box(8))));
  }

  @Test public void nextOutOfRange() {
    @Nullable List<@Nullable Integer> list = canBeNull(Collections.singletonList(box(8)));
    azzert.that(lisp.next(100, list), is(box(8)));
  }

  @Test public void nextInRange() {
    @Nullable List<@Nullable Integer> list = canBeNull(Arrays.asList(box(10), box(8)));
    azzert.that(lisp.next(0, list), is(box(8)));
  }

  @Test public void getFromNull() {
    azzert.isNull(lisp.get(null, 100));
  }

  @Test public void get() {
    @Nullable List<@Nullable Integer> list = canBeNull(Arrays.asList(box(10), box(8)));
    azzert.that(lisp.get(list, 0), is(box(8)));
  }

  @Test public void removeLast() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    lisp.removeLast(list);
    azzert.that(list, is(Collections.singletonList(box(8))));
  }

  @Test public void removeFromList() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    list.add(box(12));
    list.add(box(14));
    @NotNull List<@NotNull Integer> removes = new ArrayList<>();
    removes.add(box(8));
    removes.add(box(12));
    lisp.removeFromList(removes, list);
    azzert.that(list, is(Arrays.asList(box(10), box(14))));
  }

  @Test public void replaceNull() {
    azzert.isNull(lisp.replace(null, new Object(), 100));
  }

  @Test public void replaceEmptyList() {
    azzert.that(lisp.replace(new ArrayList<>(), new Object(), 100), is(new ArrayList<>()));
  }

  @Test public void replaceOutOfBounds() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    list.add(box(12));
    list.add(box(14));
    azzert.that(lisp.replace(list, box(90), list.size() + 1), is(list));
  }

  @Test public void replaceFirst() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(14));
    lisp.replaceFirst(list, box(10));
    azzert.that(list, is(Arrays.asList(box(10), box(14))));
  }

  @Test public void replaceLast() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(10));
    list.add(box(8));
    lisp.replaceLast(list, box(14));
    azzert.that(list, is(Arrays.asList(box(10), box(14))));
  }

  @Test public void rest2() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(10));
    list.add(box(8));
    assert !(lisp.rest2(list).iterator().hasNext());
  }

  @Test public void equalsHasNull() {
    assert !lisp.areEqual(new Object(), new Object(), null);
  }

  @Test public void notEquals() {
    assert !lisp.areEqual(new Object(), new Object(), Integer.valueOf(9));
  }

  @Test public void equals() {
    Object object = new Object();
    assert lisp.areEqual(object, object, object);
  }

  @Test public void swapIndexOutOfBounds() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(10));
    list.add(box(8));
    azzert.that(lisp.swap(list, 0, 100), is(list));
    azzert.that(lisp.swap(list, 100, 0), is(list));
  }

  @Test public void swap() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    azzert.that(lisp.swap(list, 0, 1), is(Arrays.asList(box(10), box(8))));
  }

  @Test public void chopLastString() {
    azzert.that(lisp.chopLast("Hello!"), is("Hello"));
  }

  @Test public void chopLastList() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    lisp.chopLast(list);
    azzert.that(lisp.chopLast(list), is(Collections.singletonList(box(8))));
  }

  @Test public void prevNegative() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    azzert.that(lisp.prev(-2, list), is(box(8)));
  }
  
  @Test public void prev() {
    @NotNull List<@NotNull Integer> list = new ArrayList<>();
    list.add(box(8));
    list.add(box(10));
    azzert.that(lisp.prev(2, list), is(box(10)));
  }
}
