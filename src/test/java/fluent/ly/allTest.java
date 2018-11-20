package fluent.ly;

import java.util.*;

import static fluent.ly.box.*;

import org.junit.*;

import org.jetbrains.annotations.*;

@SuppressWarnings("static-method") public class allTest {
  @Test public void allNotNullIterableNullCollection() {
    assert !all.notNull((ArrayList<Integer>)null);
  }
  
  @Test public void allNotNullIterableNullValue() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(box(3));
    a.add(null);
    a.add(box(5));
    
    assert !all.notNull(a);
  }
  
  @Test public void allNotNullIterableNoNullValue() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(box(3));
    a.add(box(7));
    a.add(box(5));
    
    assert all.notNull(a);
  }
  
  @Test public void allNotNullArrayNullCollection() {
    assert !all.notNull((@Nullable Integer[]) null);
  }
  
  @Test public void allNotNullArrayNullValue() {
    @Nullable Integer a[] = new @Nullable Integer[3];
    a[0] = (box(3));
    a[1] = null;
    a[2] = (box(5));
    assert !all.notNull(a);
  }
  
  @Test public void allNotNullArrayNoNullValue() {
    @Nullable Integer a[] = new @Nullable Integer[3];
    a[0] = (box(3));
    a[1] = (box(7));
    a[2] = (box(5));
    assert all.notNull(a);
  }
}

