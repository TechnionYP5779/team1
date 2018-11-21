package il.org.spartan.etc;

import static fluent.ly.azzert.*;
import static il.org.spartan.Utils.*;

import org.jetbrains.annotations.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class cCamelCaseTest {
  @Test public void ccComponents() {
    @NotNull String s = cantBeNull(String.valueOf("cCamelCase_components"));
    final @NotNull String[] gold = as.array("c", "Camel", "Case", "components");
    azzert.that(cCamelCase.components(s), is(gold));
  }
}
