package fluent.ly;
import static fluent.ly.azzert.is;
import static fluent.ly.box.box;
import org.junit.*;

@SuppressWarnings("static-method") public class robustTest {
  @Test public void robustlySupplierNoException() {
    azzert.that(robust.<Integer>ly(()->(box(2)),(Exception e) -> (box(3))), is(2));
  }
  
  
  public static Integer throwException(){
    throw new NullPointerException();
  }
  
  public static Boolean throwBoolException(){
    throw new NullPointerException();
  }
  
  @Test public void robustlySupplierException() {
    azzert.that(robust.<Integer>ly(robustTest::throwException, (Exception e) -> (box(3))), is(3));
  }
  
  @Test public void robustlyFalseNoException() {
    assert robust.lyFalse(() -> true, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyFalseException() {
    System.out.println(robust.lyFalse(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    }));
    assert !robust.lyFalse(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueNoException() {
    assert robust.lyFalse(() -> true, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueException() {
    System.out.println(robust.lyTrue(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    }));
    assert robust.lyTrue(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
}
