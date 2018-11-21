package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

public class NullReduceTest {
  class Mock extends NullReduce<@Nullable String>{
    @Override @Nullable public String reduce(@Nullable String r1, @Nullable String r2) {
      return null;
    } 
  }
  @Test public void reduce() {
    azzert.isNull((new Mock()).reduce());
    azzert.isNull((new Mock()).reduce("h", "j"));
  }
}
