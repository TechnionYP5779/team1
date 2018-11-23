package il.org.spartan.utils;

import java.util.*;

import org.jsoup.nodes.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

import static fluent.ly.azzert.*;

public class SimpleWebParserTest {
  final String url = "http://example.com/";
  final String businessUrl = "http://www.asat.org.il/eng/asakim";

  @Test public void getH1() {
    List<Element> list = new SimpleWebParser().getListOfTags(url, "h1");
    azzert.that(list.size(), is(1));
    azzert.that((list.get(0) + "").replaceAll("<.*?>", ""), is("Example Domain"));
  }

  @Test public void getBusinesses() {
    azzert.that(new SimpleWebParser().getListOfClasses(businessUrl, "innerBusinessDet").size(), is(20));
  }

  @Test public void printBusinesses() {
    new SimpleWebParser().getListOfClasses(businessUrl, "innerBusinessDet").forEach(λ -> System.out.println(new BusinnesEntryBuilder().apply(λ)));
  }
}
