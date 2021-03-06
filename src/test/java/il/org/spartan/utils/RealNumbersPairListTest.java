package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.RealNumbersPairList.*;

@SuppressWarnings("static-method") public class RealNumbersPairListTest {
  @Test public void creationEmptyList() {
    azzert.notNull(new RealNumbersPairList());
  }

  @Test public void size() {
    azzert.that(new RealNumbersPairList().size(), is(0));
  }

  @Test public void addingValue() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    azzert.that(list.size(), is(1));
  }

  @Test public void valuesOrder() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.record(1.7, 2.58);
    list.record(8.9, 3.2);
    list.record(1.3, 22.2);
    list.record(4.2, 9.9);
    list.record(93.5, 3.10);
    list.record(12.88, 17.1);
    list.record(41.30, 12.3);
    assert list.getFirst().first.equals(box(1.3));
    assert list.getFirst().second.equals(box(22.2));
  }

  @Test public void iteratingOrderedByXval() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.record(1.7, 2.58);
    list.record(8.9, 3.2);
    list.record(1.3, 22.2);
    list.record(4.2, 9.9);
    list.record(93.5, 3.10);
    list.record(12.88, 17.1);
    list.record(41.30, 12.3);
    assert list.getFirst().first.equals(box(1.3));
    try {
      assert list.getNext().first.equals(box(1.7));
      assert list.getNext().first.equals(box(3.5));
      assert list.getNext().first.equals(box(4.2));
      assert list.getNext().first.equals(box(8.9));
      assert list.getNext().first.equals(box(12.88));
      assert list.getNext().first.equals(box(41.30));
      assert list.getNext().first.equals(box(93.5));
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void iteratorNullBehaviour() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    assert list.getFirst().first.equals(box(3.5));
    try {
      azzert.assertNull(list.getNext());
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void iteratorEOL() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.getFirst();
    try {
      list.getNext();
      list.getNext();
    } catch (final EOL __) {
      forget.it(__);
      assert true;
    }
  }

  @Test public void iteratorEmptyList() {
    final RealNumbersPairList list = new RealNumbersPairList();
    try {
      azzert.assertNull(list.getFirst());
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void iteratorOverList() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.record(1.7, 2.58);
    list.record(8.9, 3.2);
    list.record(1.3, 22.2);
    list.record(4.2, 9.9);
    list.record(93.5, 3.10);
    list.record(12.88, 17.1);
    list.record(41.30, 12.3);
    for (final Pair<Double, Double> ¢ : list) {
      azzert.notNull(¢);
      assert unbox(¢.first) >= 1.3 && unbox(¢.first) <= 93.5;
      assert unbox(¢.second) >= 2.5 && unbox(¢.second) <= 22.2;
    }
  }

  @Test public void iteratorOverListCheckAllValsExist() {
    final RealNumbersPairList list = new RealNumbersPairList();
    final double xVals[] = { 1.3, 3.5, 93.5 }, yVals[] = { 22.2, 2.58, 9.9 };
    for (int ¢ = 0; ¢ < xVals.length; ++¢)
      list.record(xVals[¢], yVals[¢]);
    int i = 0;
    for (final Pair<Double, Double> ¢ : list) {
      assert unbox(¢.first) == xVals[i];
      assert unbox(¢.second) == yVals[i++];
    }
  }
}
