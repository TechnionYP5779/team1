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
    assert robust.lyTrue(() -> true, λ -> {
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
  
  @Test public void robustlyNull() {
    azzert.that(robust.<Integer>lyNull(()->(box(2))), is(2));
  }
  
  @Test public void robustlyNullException() {
    azzert.isNull(robust.<Integer>lyNull(robustTest::throwException));
  }

  @Test public void robustlyNullWithConsumer() {
    azzert.that(robust.<Integer>lyNull(()->(box(2)), λ -> {
      /*it's a Consumer, so it returns nothing*/
    }), is(2));
  }
  
  @Test public void robustlyNullWithConsumerException() {
    azzert.isNull(robust.<Integer>lyNull(robustTest::throwException, λ -> {
      /*it's a Consumer, so it returns nothing*/
    }));
  }
  
  @Test public void robustlyNullWithRunnable() {
    azzert.that(robust.<Integer>lyNull(() -> box(2), () -> {
      // I'm just an empty block
    }), is(2));
  }
  
  @Test public void robustlyNullWithRunnableException() {
    azzert.isNull(robust.<Integer>lyNull(robustTest::throwException, () -> {
      // I'm just an empty block
    }));
  }
  
  @Test public void robustlyTwoRunnablesNoException() {
    try{
      robust.ly(() -> {
        // I'm just an empty block
      }, () -> {
        // I'm just an empty block
      });
    }catch(Exception ¢) {
      ¢.getStackTrace();
    }
  }
  
  @Test public void robustlyConsumerNoException() {
    try{
      robust.ly(() -> {
        // I'm just an empty block
      }, (Exception e) -> {
        // empty block!
      });
    }catch(Exception ¢) {
      ¢.getStackTrace();
    }
  }
  
  @Test public void robustlyConsumerException() {
    try{
      robust.ly(robustTest::throwRunnableException, () -> {
        // I'm just an empty block
      });
    }catch(Exception ¢) {
      ¢.getStackTrace();
    }
  }
}
