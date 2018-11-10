package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class RealNumbersPairListTest {
  @Test public void creationEmptyList() {
    RealNumbersPairList list = new RealNumbersPairList();
    azzert.notNull(list);
  }
  
  @Test public void size() {
    RealNumbersPairList list = new RealNumbersPairList();
    azzert.assertEquals(list.size(), 0);
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
    azzert.assertTrue(list.getFirst().first.equals(Double.valueOf(1.3)));
    azzert.assertTrue(list.getFirst().second.equals(Double.valueOf(22.2)));
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
    azzert.assertTrue(list.getFirst().first.equals(Double.valueOf(1.3)));
    try {
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(1.7)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(3.5)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(4.2)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(8.9)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(12.88)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(41.30)));
      azzert.assertTrue(list.getNext().first.equals(Double.valueOf(93.5)));
    } catch (@SuppressWarnings("unused") Exception e) {
      azzert.assertTrue(false);
    }
    
  }
  
  
  @Test public void iteratorNullBehaviour() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    azzert.assertTrue(list.getFirst().first.equals(Double.valueOf(3.5)));
    try {
      azzert.assertNull(list.getNext());
    } catch (@SuppressWarnings("unused") Exception e) {
      azzert.assertTrue(false);
    }
  }
  
  @Test public void iteratorEmptyList() {
    RealNumbersPairList list = new RealNumbersPairList();
    try {
      azzert.assertNull(list.getFirst());
    } catch (@SuppressWarnings("unused") Exception e) {
      azzert.assertTrue(false);
    }
  }
  
  @SuppressWarnings("boxing") @Test public void iteratorOverList() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(3.5, 2.5);
    list.record(1.7, 2.58);
    list.record(8.9, 3.2);
    list.record(1.3, 22.2);
    list.record(4.2, 9.9);
    list.record(93.5, 3.10);
    list.record(12.88, 17.1);
    list.record(41.30, 12.3);
    for(Pair<Double, Double> p : list) {
      Assert.assertNotNull(p);
      azzert.assertTrue(p.first >= 1.3 && p.first <= 93.5);
      azzert.assertTrue(p.second >= 2.5 && p.first <= 22.2);
    }
  }
}
