package il.org.spartan.etc;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.English.*;
import il.org.spartan.iterables.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class EnglishTest {
  class Mock {
    class EnclosedMock {
      int x;
    }

    EnclosedMock enclosedMock;
  }

  @Test public void inflection() {
    final Inflection jump = English.Inflection.stem("Jump");
    azzert.that(jump.get(), is("Jump"));
    azzert.that(jump.getEd(), is("Jumped"));
    azzert.that(jump.getIng(), is("Jumping"));
  }

  @Test public void isAcronym() {
    assert English.isAcronym("ATM");
    assert !English.isAcronym("AtM");
  }

  @Test public void list() {
    final ArrayList<@NotNull String> strings = new ArrayList<>();
    azzert.that(English.list(strings), is("nothing"));
    strings.add("Hello");
    azzert.that(English.list(strings), is("Hello"));
    strings.add("Bye");
    azzert.that(English.list(strings), is("Hello and Bye"));
    azzert.that(English.list(null), is("nothing"));
  }

  @Test public void lowerFirstLetter() {
    azzert.that(English.lowerFirstLetter("Hello"), is("hello"));
  }

  @Test public void upperFirstLetter() {
    azzert.that(English.upperFirstLetter("hello"), is("Hello"));
  }

  @Test public void plurales() {
    azzert.that(English.plurales("dog", 1), is("one dog"));
    azzert.that(English.plurales("dog", 2), is("2 doges"));
    azzert.that(English.plurales("dog", new Int(1)), is("one dog"));
    azzert.that(English.plurales("dog", new Int(2)), is("2 doges"));
    azzert.that(English.plurales("dog", new Int(2)), is("2 doges"));
    azzert.that(English.plurales("dog", box(1)), is("one dog"));
    azzert.that(English.plurales("dog", box(2)), is("2 doges"));
    final Int nullInt = null;
    final Integer nullInteger = null;
    azzert.that(English.plurales("dog", nullInt), is("??? doges"));
    azzert.that(English.plurales("dog", nullInteger), is("??? doges"));
  }

  @Test public void plurals() {
    azzert.that(English.plurals("dog", 1), is("one dog"));
    azzert.that(English.plurals("dog", 2), is("2 dogs"));
    azzert.that(English.plurals("dog", new Int(1)), is("one dog"));
    azzert.that(English.plurals("dog", new Int(2)), is("2 dogs"));
    azzert.that(English.plurals("dog", new Int(2)), is("2 dogs"));
    azzert.that(English.plurals("dog", box(1)), is("one dog"));
    azzert.that(English.plurals("dog", box(2)), is("2 dogs"));
    final Int nullInt = null;
    final Integer nullInteger = null;
    azzert.that(English.plurals("dog", nullInt), is("??? dogs"));
    azzert.that(English.plurals("dog", nullInteger), is("??? dogs"));
  }

  @Test public void pronounce() {
    azzert.that(English.pronounce('A'), is("aey"));
    azzert.that(English.pronounce('b'), is("bee"));
    azzert.that(English.pronounce('c'), is("see"));
    azzert.that(English.pronounce('d'), is("dee"));
    azzert.that(English.pronounce('e'), is("eae"));
    azzert.that(English.pronounce('f'), is("eff"));
    azzert.that(English.pronounce('g'), is("gee"));
    azzert.that(English.pronounce('h'), is("eitch"));
    azzert.that(English.pronounce('i'), is("eye"));
    azzert.that(English.pronounce('j'), is("jay"));
    azzert.that(English.pronounce('k'), is("kay"));
    azzert.that(English.pronounce('l'), is("ell"));
    azzert.that(English.pronounce('m'), is("em"));
    azzert.that(English.pronounce('n'), is("en"));
    azzert.that(English.pronounce('o'), is("oh"));
    azzert.that(English.pronounce('p'), is("pee"));
    azzert.that(English.pronounce('q'), is("queue"));
    azzert.that(English.pronounce('r'), is("ar"));
    azzert.that(English.pronounce('s'), is("ess"));
    azzert.that(English.pronounce('t'), is("tee"));
    azzert.that(English.pronounce('u'), is("you"));
    azzert.that(English.pronounce('v'), is("vee"));
    // For some reason no 'w'
    // azzert.assertEquals(English.pronounce('w'), is("exx"));
    azzert.that(English.pronounce('x'), is("exx"));
    azzert.that(English.pronounce('y'), is("why"));
    azzert.that(English.pronounce('z'), is("zee"));
    azzert.that(English.pronounce('3'), is("some character"));
  }

  @Test public void repeat() {
    azzert.that(English.repeat(3, 'd'), is("ddd"));
  }

  @Test public void selfName() {
    azzert.that(English.selfName(new Example() {
      /* EMPTY */}.getClass()), is("{}"));
    azzert.that(English.selfName(Test.class), is("@Test"));
    azzert.that(English.selfName(Object.class), is("Object"));
    azzert.that(English.selfName(PureIterable.Sized.class), is("Sized"));
  }

  @Test public void time() {
    azzert.that(English.time(123456789), is("0.12"));
  }

  @Test public void trim() {
    azzert.assertNull(English.trim(null));
    azzert.that(English.trim("Hello how are you doing?\nI'm doing fine"), is("Hello how are you doing?\nI'm doing fine"));
    azzert.that(English.trim("Hello how are you you you you you you you you doing?\nI'm doing fine"),
        is("Hello how are you you you you you you you you d...\nI'm doing fine"));
  }

  @Test public void unknownIfNull() {
    azzert.that(English.unknownIfNull(null), is("???"));
    azzert.that(English.unknownIfNull("Hello how are you doing?\nI'm doing fine"), is("Hello how are you doing?\nI'm doing fine"));
    azzert.that(English.unknownIfNull(null, λ -> λ + "a"), is("???"));
    azzert.that(English.unknownIfNull("Hello", λ -> λ + "a"), is("Helloa"));
  }

  @Test public void name() {
    final Mock m = new Mock();
    azzert.that(English.name(Integer.class), is("Integer"));
    azzert.that(English.name(Mock.EnclosedMock.class), is("EnclosedMock.Mock.EnglishTest"));
    azzert.that(English.name(m.getClass()), is("Mock.EnglishTest"));
  }

  @Test public void indefinite() {
    azzert.that(English.indefinite("object"), is("a object"));
    azzert.that(English.indefinite("double"), is("an double"));
    azzert.that(English.indefinite("INT"), is("an tee"));
  }
}
