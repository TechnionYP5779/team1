package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;
import static il.org.spartan.Utils.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") public class onceTest {
   @Test public void test() {
    @NotNull String x = "Hello";
    
    azzert.that(new once(cantBeNull(x)) + "", is("Hello"));
//    azzert.that(once("hello"), is);
  }
}
