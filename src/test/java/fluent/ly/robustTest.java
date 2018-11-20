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
  
  public static void throwRunnableException(){
    throw new NullPointerException();
  }
  
  @Test public void robustlySupplierException() {
    azzert.that(robust.<Integer>ly(robustTest::throwException, (Exception e) -> (box(3))), is(3));
  }
  
  @Test public void robustlyFalseNoException() {
    assert !robust.lyFalse(() -> false, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyFalseException() {
    assert !robust.lyFalse(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueBoolNoException() {
    assert robust.lyFalse(() -> true, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueBoolException() {
    assert robust.lyTrue(robustTest::throwBoolException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueNoException() {
    assert robust.lyTrue(() -> {
      // I'm just an empty block
    }, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
  
  @Test public void robustlyTrueException() {
    assert robust.lyTrue(robustTest::throwRunnableException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    });
  }
}
