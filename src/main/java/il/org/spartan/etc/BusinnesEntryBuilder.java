package il.org.spartan.etc;

import java.util.*;
import java.util.function.*;
import org.jsoup.nodes.*;
import static fluent.ly.azzert.*;

import fluent.ly.*;

public class BusinnesEntryBuilder implements Function<Element, String> {
  @Override public String apply(Element t) {
    List<Element> list = t.getElementsByTag("h3");
    azzert.that(list.size(), is(1));
    String $ = (list.get(0) + "").replaceAll("<.*?h.*?>", "");
    try {
      Element innerDiv = t.getElementsByClass("hoverItems").get(0), openingHoursDiv = innerDiv.children().first();
      azzert.notNull(openingHoursDiv);
      return $ + " | " + (openingHoursDiv + "").replaceAll("<.*?div.*?>", "").replaceAll("<br>", "").replaceAll(".*?Open.*", "").replaceAll("\\s+", " ");
    } catch (Throwable __) {
      forget.it(__);
      return $ + " No Opening Hours";
    }
  }
}
