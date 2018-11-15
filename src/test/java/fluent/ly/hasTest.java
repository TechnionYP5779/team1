package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;

@SuppressWarnings({ "static-access", "static-method" }) public class hasTest {
  List<@Nullable Object> list;

  @Before public void initList() {
    list = new ArrayList<>();
    list.add(box.box(1));
    list.add(box.box(2));
    list.add(box.box(3));
    list.add(box.box(4));
    list.add(box.box(5));
  }

  @Test public void getItemInRange() {
    azzert.assertEquals(has.next(2, Utils.cantBeNull(list)), box.box(4));
  }

  @Test public void getItemOutOfRange() {
    azzert.assertEquals(has.next(1000, Utils.cantBeNull(list)), box.box(5));
  }

  @Test public void iterableHasNoNulls() {
    final @NotNull Iterable<@Nullable Object> it = Utils.cantBeNull(list);
    assert !has.nulls(it);
  }

  @Test public void iterableHasNulls() {
    list.add(null);
    final @NotNull Iterable<@Nullable Object> it = Utils.cantBeNull(list);
    assert has.nulls(it);
  }

  @Test public void varargsHasNoNulls() {
    assert !has.nulls(box.box(1.5), box.box('H'), box.box(true));
  }

  @Test public void varargsHasNulls() {
    assert has.nulls(box.box(6), box.box('j'), null, box.box(3.14159));
  }

  @Test public void sendNull() {
    assert has.nulls((String) null);
  }
}
