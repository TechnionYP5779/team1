package fluent.ly;

import org.junit.*;

public class RangeTest2 {
  @SuppressWarnings("static-method") @Test public void createInfiniteSequence() {
    azzert.assertFalse(range.from(2).isEmpty());
    azzert.assertTrue(range.from(2).isInfinite());
  }
  
  
  @SuppressWarnings("static-method") @Test public void from2fromReturnOrigin() {
    azzert.assertTrue(range.from(2).from() == 2);
  }
  
  @SuppressWarnings("static-method") @Test public void fromTo() {
    int count =2;
    for (final Integer $ : range.from(2).to(6)) {
      azzert.assertEquals($, count);
      ++count;
    }
  }
//  @SuppressWarnings("static-method") @Test public void fromTo() {
//    int count =1;
//    for (final Integer $ : range.to(2)) {
//      azzert.assertEquals($, count);
//      --count;
//    }
//  }
}
