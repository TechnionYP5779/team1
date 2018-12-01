package il.org.spartan.utils;
 import java.io.*;
import java.util.*;
import java.util.function.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
 import fluent.ly.*;
 @SuppressWarnings("static-method") public class SimpleWebParser implements Function<String, Optional<String>> {
  @Override public Optional<String> apply(String $) {
    try {
      return Optional.of(Jsoup.connect($).get().body() + "");
    } catch (IOException __) {
      forget.it(__);
      return Optional.empty();
    }
  }
   public List<Element> getListOfTags(String $, String tag) {
    try {
      return Jsoup.connect($).get().body().getElementsByTag(tag);
    } catch (IOException __) {
      forget.it(__);
      return new ArrayList<>();
    }
  }
  
  public List<Element> getListOfClasses(String $, String className) {
    try {
      return Jsoup.connect($).get().body().getElementsByClass(className);
    } catch (IOException __) {
      forget.it(__);
      return new ArrayList<>();
    }
  }
  
  public Optional<String> applyHead(String $) {
    try {
      return Optional.of(Jsoup.connect($).get().head() + "");
    } catch (IOException __) {
      forget.it(__);
      return Optional.empty();
    }
  }
   public List<Element> getListOfTagsHead(String $, String tag) {
    try {
      return Jsoup.connect($).get().head().getElementsByTag(tag);
    } catch (IOException __) {
      forget.it(__);
      return new ArrayList<>();
    }
  }
  
  public List<Element> getListOfClassesHead(String $, String className) {
    try {
      return Jsoup.connect($).get().head().getElementsByClass(className);
    } catch (IOException __) {
      forget.it(__);
      return new ArrayList<>();
    }
  }
}