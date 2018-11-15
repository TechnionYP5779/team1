package il.org.spartan.etc;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.English.*;
import il.org.spartan.iterables.*;
import il.org.spartan.utils.*;

@SuppressWarnings({"static-method", "static-access"})
public class EnglishTest {
  class Mock{
    class EnclosedMock{
      int x;
    }
    EnclosedMock enclosedMock;
  }
  
  @Test public void inflection() {
    Inflection jump = English.Inflection.stem("Jump");
    azzert.assertEquals(jump.get(), "Jump");
    azzert.assertEquals(jump.getEd(), "Jumped");
    azzert.assertEquals(jump.getIng(), "Jumping");
  }
  
  @Test public void isAcronym() {
    assert English.isAcronym("ATM");
    assert !English.isAcronym("AtM");
  }
  
  @Test public void list() {
    ArrayList<@NotNull String> strings = new ArrayList<>();
    azzert.assertEquals(English.list(strings), "nothing");
    strings.add("Hello");
    azzert.assertEquals(English.list(strings), "Hello");
    strings.add("Bye");
    azzert.assertEquals(English.list(strings), "Hello and Bye");
  }
  
  @Test public void lowerFirstLetter() {
    azzert.assertEquals(English.lowerFirstLetter("Hello"), "hello");
  }
  
  @Test public void upperFirstLetter() {
    azzert.assertEquals(English.upperFirstLetter("hello"), "Hello");
  }
  
  @Test public void plurales() {
    azzert.assertEquals(English.plurales("dog", 1), "one dog");
    azzert.assertEquals(English.plurales("dog", 2), "2 doges");
    azzert.assertEquals(English.plurales("dog", new Int(1)), "one dog");
    azzert.assertEquals(English.plurales("dog", new Int(2)), "2 doges");
    azzert.assertEquals(English.plurales("dog", new Int(2)), "2 doges");
    azzert.assertEquals(English.plurales("dog", Integer.valueOf(1)), "one dog");
    azzert.assertEquals(English.plurales("dog", Integer.valueOf(2)), "2 doges");
    Int nullInt = null;
    Integer nullInteger = null;
    azzert.assertEquals(English.plurales("dog", nullInt), "??? doges");
    azzert.assertEquals(English.plurales("dog", nullInteger), "??? doges");
  }
  
  @Test public void plurals() {
    azzert.assertEquals(English.plurals("dog", 1), "one dog");
    azzert.assertEquals(English.plurals("dog", 2), "2 dogs");
    azzert.assertEquals(English.plurals("dog", new Int(1)), "one dog");
    azzert.assertEquals(English.plurals("dog", new Int(2)), "2 dogs");
    azzert.assertEquals(English.plurals("dog", new Int(2)), "2 dogs");
    azzert.assertEquals(English.plurals("dog", Integer.valueOf(1)), "one dog");
    azzert.assertEquals(English.plurals("dog", Integer.valueOf(2)), "2 dogs");
    Int nullInt = null;
    Integer nullInteger = null;
    azzert.assertEquals(English.plurals("dog", nullInt), "??? dogs");
    azzert.assertEquals(English.plurals("dog", nullInteger), "??? dogs");
  }
  
  @Test public void pronounce() {
    azzert.assertEquals(English.pronounce('A'), "aey");
    azzert.assertEquals(English.pronounce('b'), "bee");
    azzert.assertEquals(English.pronounce('c'), "see");
    azzert.assertEquals(English.pronounce('d'), "dee");
    azzert.assertEquals(English.pronounce('e'), "eae");
    azzert.assertEquals(English.pronounce('f'), "eff");
    azzert.assertEquals(English.pronounce('g'), "gee");
    azzert.assertEquals(English.pronounce('h'), "eitch");
    azzert.assertEquals(English.pronounce('i'), "eye");
    azzert.assertEquals(English.pronounce('j'), "jay");
    azzert.assertEquals(English.pronounce('k'), "kay");
    azzert.assertEquals(English.pronounce('l'), "ell");
    azzert.assertEquals(English.pronounce('m'), "em");
    azzert.assertEquals(English.pronounce('n'), "en");
    azzert.assertEquals(English.pronounce('o'), "oh");
    azzert.assertEquals(English.pronounce('p'), "pee");
    azzert.assertEquals(English.pronounce('q'), "queue");
    azzert.assertEquals(English.pronounce('r'), "ar");
    azzert.assertEquals(English.pronounce('s'), "ess");
    azzert.assertEquals(English.pronounce('t'), "tee");
    azzert.assertEquals(English.pronounce('u'), "you");
    azzert.assertEquals(English.pronounce('v'), "vee");
    //For some reason no 'w'
    //azzert.assertEquals(English.pronounce('w'), "exx");
    azzert.assertEquals(English.pronounce('x'), "exx");
    azzert.assertEquals(English.pronounce('y'), "why");
    azzert.assertEquals(English.pronounce('z'), "zee");
    azzert.assertEquals(English.pronounce('3'), "some character");
  }
  
  @Test public void repeat() {
    azzert.assertEquals(English.repeat(3, 'd'), "ddd");
  }
  
  @Test public void selfName() {
    azzert.assertEquals(English.selfName(Object.class), "Object");
    azzert.assertEquals(English.selfName(PureIterable.Sized.class), "Sized");
  }
  
  @Test public void time() {
    azzert.assertEquals(English.time(123456789), "0.12");
  }
  
  @Test public void trim() {
    azzert.assertNull(English.trim(null));
    azzert.assertEquals(English.trim("Hello how are you doing?\nI'm doing fine"), "Hello how are you doing?\nI'm doing fine");
    azzert.assertEquals(English.trim("Hello how are you you you you you you you you doing?\nI'm doing fine"), "Hello how are you you you you you you you you d...\nI'm doing fine");
  }
  
  @Test public void unknownIfNull() {
    azzert.assertEquals(English.unknownIfNull(null), "???");
    azzert.assertEquals(English.unknownIfNull("Hello how are you doing?\nI'm doing fine"), "Hello how are you doing?\nI'm doing fine");
    azzert.assertEquals(English.unknownIfNull(null, λ -> λ + "a"), "???");
    azzert.assertEquals(English.unknownIfNull("Hello", λ -> λ + "a"), "Helloa");
  }
  
  @Test public void name() {
    Mock m = new Mock();
    azzert.assertEquals(English.name(Integer.class), "Integer");
    azzert.assertEquals(English.name(Mock.EnclosedMock.class), "EnclosedMock.Mock.EnglishTest");
    azzert.assertEquals(English.name(m.getClass()), "Mock.EnglishTest");

  }
}
