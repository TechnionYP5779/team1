package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;
import il.org.spartan.utils.RealNumbersPairList.*;

@SuppressWarnings("static-method") public class RealNumbersPairListTest {
  @Test public void creationEmptyList() {
    azzert.notNull(new RealNumbersPairList());
  }

  @Test public void size() {
    azzert.assertEquals(new RealNumbersPairList().size(), 0);
  }

  @Test public void addingValue() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    azzert.assertEquals(list.size(), 1);
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
    assert list.getFirst().first.equals(Double.valueOf(1.3));
    assert list.getFirst().second.equals(Double.valueOf(22.2));
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
    assert list.getFirst().first.equals(Double.valueOf(1.3));
    try {
      assert list.getNext().first.equals(Double.valueOf(1.7));
      assert list.getNext().first.equals(Double.valueOf(3.5));
      assert list.getNext().first.equals(Double.valueOf(4.2));
      assert list.getNext().first.equals(Double.valueOf(8.9));
      assert list.getNext().first.equals(Double.valueOf(12.88));
      assert list.getNext().first.equals(Double.valueOf(41.30));
      assert list.getNext().first.equals(Double.valueOf(93.5));
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void iteratorNullBehaviour() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    assert list.getFirst().first.equals(Double.valueOf(3.5));
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
      Assert.assertNotNull(¢);
      assert unbox.unbox(¢.first) >= 1.3 && unbox.unbox(¢.first) <= 93.5;
      assert unbox.unbox(¢.second) >= 2.5 && unbox.unbox(¢.second) <= 22.2;
    }
  }

  @Test public void iteratorOverListCheckAllValsExist() {
    final RealNumbersPairList list = new RealNumbersPairList();
    final double xVals[] = { 1.3, 3.5, 93.5 }, yVals[] = { 22.2, 2.58, 9.9 };
    for (int ¢ = 0; ¢ < xVals.length; ++¢)
      list.record(xVals[¢], yVals[¢]);
    int i = 0;
    for (final Pair<Double, Double> ¢ : list) {
      assert unbox.unbox(¢.first) == xVals[i];
      assert unbox.unbox(¢.second) == yVals[i++];
    }
  }
}
