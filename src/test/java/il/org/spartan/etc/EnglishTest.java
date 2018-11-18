package il.org.spartan.etc;

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
    Assert.assertEquals(jump.get(), "Jump");
    Assert.assertEquals(jump.getEd(), "Jumped");
    Assert.assertEquals(jump.getIng(), "Jumping");
  }

  @Test public void isAcronym() {
    assert English.isAcronym("ATM");
    assert !English.isAcronym("AtM");
  }

  @Test public void list() {
    final ArrayList<@NotNull String> strings = new ArrayList<>();
    Assert.assertEquals(English.list(strings), "nothing");
    strings.add("Hello");
    Assert.assertEquals(English.list(strings), "Hello");
    strings.add("Bye");
    Assert.assertEquals(English.list(strings), "Hello and Bye");
  }

  @Test public void lowerFirstLetter() {
    Assert.assertEquals(English.lowerFirstLetter("Hello"), "hello");
  }

  @Test public void upperFirstLetter() {
    Assert.assertEquals(English.upperFirstLetter("hello"), "Hello");
  }

  @Test public void plurales() {
    Assert.assertEquals(English.plurales("dog", 1), "one dog");
    Assert.assertEquals(English.plurales("dog", 2), "2 doges");
    Assert.assertEquals(English.plurales("dog", new Int(1)), "one dog");
    Assert.assertEquals(English.plurales("dog", new Int(2)), "2 doges");
    Assert.assertEquals(English.plurales("dog", new Int(2)), "2 doges");
    Assert.assertEquals(English.plurales("dog", box(1)), "one dog");
    Assert.assertEquals(English.plurales("dog", box(2)), "2 doges");
    final Int nullInt = null;
    final Integer nullInteger = null;
    Assert.assertEquals(English.plurales("dog", nullInt), "??? doges");
    Assert.assertEquals(English.plurales("dog", nullInteger), "??? doges");
  }

  @Test public void plurals() {
    Assert.assertEquals(English.plurals("dog", 1), "one dog");
    Assert.assertEquals(English.plurals("dog", 2), "2 dogs");
    Assert.assertEquals(English.plurals("dog", new Int(1)), "one dog");
    Assert.assertEquals(English.plurals("dog", new Int(2)), "2 dogs");
    Assert.assertEquals(English.plurals("dog", new Int(2)), "2 dogs");
    Assert.assertEquals(English.plurals("dog", box(1)), "one dog");
    Assert.assertEquals(English.plurals("dog", box(2)), "2 dogs");
    final Int nullInt = null;
    final Integer nullInteger = null;
    Assert.assertEquals(English.plurals("dog", nullInt), "??? dogs");
    Assert.assertEquals(English.plurals("dog", nullInteger), "??? dogs");
  }

  @Test public void pronounce() {
    Assert.assertEquals(English.pronounce('A'), "aey");
    Assert.assertEquals(English.pronounce('b'), "bee");
    Assert.assertEquals(English.pronounce('c'), "see");
    Assert.assertEquals(English.pronounce('d'), "dee");
    Assert.assertEquals(English.pronounce('e'), "eae");
    Assert.assertEquals(English.pronounce('f'), "eff");
    Assert.assertEquals(English.pronounce('g'), "gee");
    Assert.assertEquals(English.pronounce('h'), "eitch");
    Assert.assertEquals(English.pronounce('i'), "eye");
    Assert.assertEquals(English.pronounce('j'), "jay");
    Assert.assertEquals(English.pronounce('k'), "kay");
    Assert.assertEquals(English.pronounce('l'), "ell");
    Assert.assertEquals(English.pronounce('m'), "em");
    Assert.assertEquals(English.pronounce('n'), "en");
    Assert.assertEquals(English.pronounce('o'), "oh");
    Assert.assertEquals(English.pronounce('p'), "pee");
    Assert.assertEquals(English.pronounce('q'), "queue");
    Assert.assertEquals(English.pronounce('r'), "ar");
    Assert.assertEquals(English.pronounce('s'), "ess");
    Assert.assertEquals(English.pronounce('t'), "tee");
    Assert.assertEquals(English.pronounce('u'), "you");
    Assert.assertEquals(English.pronounce('v'), "vee");
    // For some reason no 'w'
    // azzert.assertEquals(English.pronounce('w'), "exx");
    Assert.assertEquals(English.pronounce('x'), "exx");
    Assert.assertEquals(English.pronounce('y'), "why");
    Assert.assertEquals(English.pronounce('z'), "zee");
    Assert.assertEquals(English.pronounce('3'), "some character");
  }

  @Test public void repeat() {
    Assert.assertEquals(English.repeat(3, 'd'), "ddd");
  }

  @Test public void selfName() {
    Assert.assertEquals(English.selfName(Object.class), "Object");
    Assert.assertEquals(English.selfName(PureIterable.Sized.class), "Sized");
  }

  @Test public void time() {
    Assert.assertEquals(English.time(123456789), "0.12");
  }

  @Test public void trim() {
    azzert.assertNull(English.trim(null));
    Assert.assertEquals(English.trim("Hello how are you doing?\nI'm doing fine"), "Hello how are you doing?\nI'm doing fine");
    Assert.assertEquals(English.trim("Hello how are you you you you you you you you doing?\nI'm doing fine"),
        "Hello how are you you you you you you you you d...\nI'm doing fine");
  }

  @Test public void unknownIfNull() {
    Assert.assertEquals(English.unknownIfNull(null), "???");
    Assert.assertEquals(English.unknownIfNull("Hello how are you doing?\nI'm doing fine"), "Hello how are you doing?\nI'm doing fine");
    Assert.assertEquals(English.unknownIfNull(null, λ -> λ + "a"), "???");
    Assert.assertEquals(English.unknownIfNull("Hello", λ -> λ + "a"), "Helloa");
  }

  @Test public void name() {
    final Mock m = new Mock();
    Assert.assertEquals(English.name(Integer.class), "Integer");
    Assert.assertEquals(English.name(Mock.EnclosedMock.class), "EnclosedMock.Mock.EnglishTest");
    Assert.assertEquals(English.name(m.getClass()), "Mock.EnglishTest");
  }
}
