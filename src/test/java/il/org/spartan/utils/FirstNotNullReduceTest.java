package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;
import static fluent.ly.azzert.*;
import fluent.ly.*;

@SuppressWarnings("static-method")  public class FirstNotNullReduceTest {
 @Test public void reduce() {
    azzert.that((new FirstNotNullReduce<@Nullable String>()).reduce(null, "h"), is("h"));
    azzert.that((new FirstNotNullReduce<@Nullable String>()).reduce("t", "h"), is("t"));
  }
}
