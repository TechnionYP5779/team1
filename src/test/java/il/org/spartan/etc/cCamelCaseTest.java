package il.org.spartan.etc;

import static fluent.ly.azzert.*;
import static il.org.spartan.Utils.*;

import org.jetbrains.annotations.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.EnglishTest.*;

@SuppressWarnings("static-method") public class cCamelCaseTest {
  @Test public void ccComponents() {
    @NotNull String s = cantBeNull(String.valueOf("cCamelCase_components"));
    final @NotNull String[] gold = as.array("c", "Camel", "Case", "components");
    azzert.that(cCamelCase.components(s), is(gold));
  }
  
  @Test public void ccLastComponentsString() {
    @NotNull String s = cantBeNull(String.valueOf("cCamelCase.components"));
    azzert.that(cCamelCase.lastComponent(s), is("components"));
  }
  
  @Test public void ccLastComponentsClass() {
    azzert.that(cCamelCase.lastComponent(Mock.EnclosedMock.class), is("EnclosedMock"));
  }
  
  @Test public void ccUsefulNameTypeLongString() {
    @NotNull String s = cantBeNull(String.valueOf("Saifun"));
    assert cCamelCase.usefulTypeName(s);
  }
  
  @Test public void ccUsefulNameTypeSecondBranchUpperCase() {
    @NotNull String s = cantBeNull(String.valueOf("C"));
    assert !cCamelCase.usefulTypeName(s);
  }
  
  @Test public void ccUsefulNameTypeSecondBranchNonUpperCase() {
    @NotNull String s = cantBeNull(String.valueOf("s"));
    assert cCamelCase.usefulTypeName(s);
  }
}
