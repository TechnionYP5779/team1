package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class RealNumbersPairListTest {
  @Test public void creationEmptyList() {
    azzert.notNull(new RealNumbersPairList());
  }
  
  @Test public void size() {
    azzert.assertEquals((new RealNumbersPairList()).size(), 0);
  }
  
  @Test public void addingValue() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    azzert.assertEquals(list.size(), 1);
  }
  
  @Test public void valuesOrder() {
    RealNumbersPairList list = new RealNumbersPairList();
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
    RealNumbersPairList list = new RealNumbersPairList();
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
    } catch (@SuppressWarnings("unused") Exception e) {
      assert false;
    }
    
  }
  
  
  @Test public void iteratorNullBehaviour() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    assert list.getFirst().first.equals(Double.valueOf(3.5));
    try {
      azzert.assertNull(list.getNext());
    } catch (@SuppressWarnings("unused") Exception e) {
      assert false;
    }
  }
  
  @Test public void iteratorEmptyList() {
    RealNumbersPairList list = new RealNumbersPairList();
    try {
      azzert.assertNull(list.getFirst());
    } catch (@SuppressWarnings("unused") Exception e) {
      assert false;
    }
  }
  
  @Test @SuppressWarnings("boxing") public void iteratorOverList() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.record(1.7, 2.58);
    list.record(8.9, 3.2);
    list.record(1.3, 22.2);
    list.record(4.2, 9.9);
    list.record(93.5, 3.10);
    list.record(12.88, 17.1);
    list.record(41.30, 12.3);
    for (Pair<Double, Double> ¢ : list) {
      Assert.assertNotNull(¢);
      assert ¢.first >= 1.3 && ¢.first <= 93.5;
      assert ¢.second >= 2.5 && ¢.second <= 22.2;
    }
  }
  
  @Test @SuppressWarnings("boxing") public void iteratorOverListCheckAllValsExist() {
    RealNumbersPairList list = new RealNumbersPairList();
    double xVals[] = { 1.3, 3.5, 93.5 }, yVals[] = { 22.2, 2.58, 9.9 };
    for (int ¢ = 0; ¢ < xVals.length; ++¢)
      list.record(xVals[¢], yVals[¢]);
    int i = 0;
    for (Pair<Double, Double> ¢ : list) {
      assert ¢.first == xVals[i];
      assert ¢.second == yVals[i++];
    }
  }
  
  
}
