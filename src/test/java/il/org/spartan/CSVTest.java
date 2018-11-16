package il.org.spartan;

import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;

public class CSVTest {
  
  enum someEnum {
    A,B;
  }
  
  @Test @SuppressWarnings("static-method") public void combineTest() {
    Class<?>[] array = new Class<?>[2];
    array[0] = null;
    array[1] = Integer.class;
    azzert.that(CSV.combine(array), is("null,java.lang.Integer"));
    
    someEnum [] enum_array = new someEnum[2];
    enum_array[0] = someEnum.A;
    enum_array[1] = null;
    azzert.that(CSV.combine(enum_array), is("A,null"));
  }
  
}
