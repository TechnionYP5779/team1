package il.org.spartan.etc;

import java.util.*;
import java.util.function.*;
import java.util.regex.*;

import org.jsoup.nodes.*;

import static fluent.ly.azzert.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BusinnesEntryBuilder implements Function<Element, String> {
  private final String[] daysOfTheWeek = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

  @Override public String apply(Element t) {
    List<Element> list = t.getElementsByTag("h3");
    azzert.that(list.size(), is(1));
    String $ = (list.get(0) + "").replaceAll("<.*?h.*?>", "");
    try {
      Element innerDiv = t.getElementsByClass("hoverItems").get(0), openingHoursDiv = innerDiv.children().first();
      azzert.notNull(openingHoursDiv);
      return formatAsJson($ + "\n" + parseHoursSimple(formatString(openingHoursDiv + "")));
    } catch (Throwable __) {
      forget.it(__);
      return $ + " Problem with opening hours' format";
    }
  }

  private String formatString(String ¢) {
    return ¢.replaceAll("<.*?div.*?>", "").replaceAll("<br>", "").replaceAll(".*?Open.*", "").replaceAll("( *(\n|\n\r|\r\n) *)+", "\n");
  }

  private String parseHoursSimple(String hours) {
    String[] lines = hours.split("\n");
    StringBuilder $ = new StringBuilder();
    for (String line : lines) {
      if ("".equals(line))
        continue;
      String patternString = "(\\s?(?<day1>[a-zA-Z]*?day)( ?- ?(?<day2>[a-zA-Z]*?day))? (?<hours>\\d*:\\d* ?- ?\\d*:\\d*)\\s?)+";
      if (!line.matches(patternString))
        throw new IllegalArgumentException();
      for (Matcher matcher = Pattern.compile(patternString).matcher(line); matcher.find();) {
        $.append(matcher.group("day1") + "|");
        String day2 = matcher.group("day2");
        if (day2 != null)
          $.append(day2 + "|");
        $.append(matcher.group("hours"));
      }
      $.append("\n");
    }
    return $ + "";
  }

  private String formatAsJson(String data) {
    String[] lines = data.split("\n");
    StringBuilder $ = new StringBuilder();
    $.append("{\n\t\"name\":\"" + lines[0] + "\"");
    for (int ¢ = 1; ¢ < lines.length; ++¢) {
      if ("".equals(lines[¢]))
        continue;
      String[] params = lines[¢].split("\\|");
      if (params.length == 2)
        $.append(",\n\t\"" + params[0] + "\":\"" + params[1] + "\"");
      else {
        boolean startedRange = false;
        for (String weekDay : daysOfTheWeek) {
          if (weekDay.startsWith(params[0]))
            startedRange = true;
          if (!startedRange)
            continue;
          if (weekDay.startsWith(params[1]))
            startedRange = false;
          $.append(",\n\t\"" + weekDay + "\":\"" + params[2] + "\"");
        }
      }
    }
    $.append("\n}");
    return $ + "";
  }
}
