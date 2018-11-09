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
  
//  @Test public void iteratingrderedByXval() {
//    RealNumbersPairList list = new RealNumbersPairList();
//    list.record(3.5, 2.5);
//    list.record(1.7, 2.58);
//    list.record(8.9, 3.2);
//    list.record(1.3, 22.2);
//    list.record(4.2, 9.9);
//    list.record(93.5, 3.10);
//    list.record(12.88, 17.1);
//    list.record(41.30, 12.3);
//    azzert.assertEquals(list.size(), 1);
//  }
}
