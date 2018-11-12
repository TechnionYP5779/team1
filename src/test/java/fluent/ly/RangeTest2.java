package fluent.ly;

import org.junit.*;

public class RangeTest2 {
  @Test @SuppressWarnings("static-method") public void createInfiniteSequence() {
    assert !range.from(2).isEmpty();
    assert range.from(2).isInfinite();
  }


  @Test @SuppressWarnings("static-method") public void from2fromReturnOrigin() {
    assert range.from(2).from() == 2;
  }

  @Test @SuppressWarnings("static-method") public void fromTo() {
    int count = 2;
    for (final Integer $ : range.from(2).to(6)) {
      azzert.assertEquals( count,$);
      ++count;
    }
  }

  @Test @SuppressWarnings("static-method") public void onlyTo() {
    assert !range.to(2).isEmpty();
    assert range.to(2).isInfinite();
    int count =1;
    for (final Integer $ : range.to(2)) {
      //      System.out.println($);
      azzert.assertEquals( count,$);
      --count;
      if( count == -5)
        break;
    }
  }
  // range.to(2).from() should return a null pointer
  @Test @SuppressWarnings("static-method") public void toFromFunc() {
    assert range.to(2).from() == null;
  }

  //range.to(2).from(-5) is the range -5, -4, ...,0,1
  @Test @SuppressWarnings("static-method") public void toFromRange() {
    int count =-5;
    for (final Integer $ : range.to(2).from(-5)) {
      //      System.out.println($);
      azzert.assertEquals( count,$);
      ++count;
    }
  }

  @Test @SuppressWarnings("static-method") public void numbersRange() {
    //    int count =Integer.MIN_VALUE;
    int count =Integer.MIN_VALUE;
    for (final Integer $ : range.numbers) {
      //      System.out.println($);
      azzert.assertEquals( count,$);
      ++count;
      if( count == Integer.MIN_VALUE+5)
        break;
    }
  }
  // range.to(10).interset(range.from(3)) crate the intersection range
  @Test @SuppressWarnings("static-method") public void rangeintersect() {
    //    int count =Integer.MIN_VALUE;
    
    int count =3;
    for (final Integer $ : range.to(10).interset(range.from(3))) {
      //      System.out.println($);
      azzert.assertEquals( count,$);
      ++count;
    }
  }
  
  //range.from(x).to(y).includes(z) specifiy by yourself.
  @Test @SuppressWarnings("static-method") public void includestest() {
    assert range.from(1).to(3).includes(2);
    assert !range.from(0).to(3).includes(7);

  }
}

