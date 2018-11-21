package il.org.spartan.tables;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.tables.TableRenderer.*;
@SuppressWarnings("static-method") public class TableRendererTest {
  enum Mock implements TableRenderer{
    MOCK;
    @Override public void setHeaderCount(int size) {
      forget.it(size);
    }    
  }
  String NL = System.getProperty("line.separator");
  @Test public void afterHeader() {
    azzert.that(builtin.TEX.afterHeader(), is("\\midrule"+NL));
  }
  @Test public void afterTable() {
    azzert.that(builtin.TEX.afterTable(), is("\\bottomrule"+NL));
  }
  @Test public void arraySeparator() {
    azzert.that(builtin.TEX.arraySeparator(), is(", "));
  }
  @Test public void beforeFooter() {
    azzert.that(builtin.TEX.beforeFooter(), is("\\midrule"+NL));
  }
  @Test public void beforeTable() {
    azzert.that(builtin.TEX.beforeTable(), is("\\toprule"+NL));
  }
  @Test public void nil() {
    azzert.that(builtin.TEX.nil(), is("$\\#$"));
  }
  @Test public void recordEnd() {
    azzert.that(builtin.TEX.recordEnd(), is(" \\\\"+NL));
  }
  @Test public void recordSeparator() {
    azzert.that(builtin.TEX.recordSeparator(), is("\t&\t"));
  }
  @Test public void render() {
    azzert.that(builtin.TEX.render(Statistic.Σ), is("\\hfill$\\Sum$"));
    azzert.that(builtin.TEX.render(Statistic.σ), is("\\hfill$\\sigma$"));
    azzert.that(builtin.TEX.render(Statistic.max), is("\\hfill$\\max$"));
    azzert.that(builtin.TEX.render(Statistic.min), is("\\hfill$\\min$"));
    azzert.that(builtin.TEX.render(Statistic.median), is("\\hfillmedian"));
  }
  
  @Test public void afterHeader2() {
    azzert.that(builtin.TEX2.afterHeader(), is("\\hline"+NL));
  }
  @Test public void afterTable2() {
    azzert.that(builtin.TEX2.afterTable(), is("\\hline"+NL));
  }
  @Test public void arraySeparator2() {
    azzert.that(builtin.TEX2.arraySeparator(), is(", "));
  }
  @Test public void beforeFooter2() {
    azzert.that(builtin.TEX2.beforeFooter(), is("\\hline"+NL));
  }
  @Test public void beforeTable2() {
    azzert.that(builtin.TEX2.beforeTable(), is("\\hline"+NL));
  }
  @Test public void footerEnd() {
    azzert.that(builtin.TEX2.footerEnd(), is("\\\\"+NL));
  }
  @Test public void recordSeparator2() {
    azzert.that(builtin.TEX2.recordSeparator(), is("\t&\t"));
  }
  @Test public void footerEnd3() {
    azzert.that(builtin.CSV.footerEnd(), is(NL));
  }
  @Test public void recordSeparator3() {
    azzert.that(builtin.CSV.recordSeparator(), is(","));
  }
  @Test public void afterHeader3() {
    azzert.that(builtin.MARKDOWN.afterHeader(), is("| "+NL));
    builtin.MARKDOWN.setHeaderCount(2);
    azzert.that(builtin.MARKDOWN.afterHeader(), is("| --- |--- |"+NL));
  }
  @Test public void afterTable3() {
    azzert.that(builtin.MARKDOWN.afterTable(), is(NL));
  }
  @Test public void beforeTable3() {
    azzert.that(builtin.MARKDOWN.beforeTable(), is(NL));
  }
  @Test public void recordBegin() {
    azzert.that(builtin.MARKDOWN.recordBegin(), is("|"));
  }
  @Test public void recordEnd2() {
    azzert.that(builtin.MARKDOWN.recordEnd(), is(" |"+NL));
  }
  @Test public void recordSeparator4() {
    azzert.that(builtin.MARKDOWN.recordSeparator(), is(" | "));
  }
  @Test public void cellReal() {
    azzert.that(builtin.MARKDOWN.cellReal(box(2.0)), is("2"));
    azzert.that(builtin.MARKDOWN.cellReal(box(22313213213123421413.0)), is("2.231321321312342E19"));
  }
  @Test public void empty() {
    azzert.that(TableRenderer.empty(), is(""));
  }
  @Test public void tab() {
    azzert.that(TableRenderer.tab(), is("\t"));
  }
  @Test public void afterFooter3() {
    azzert.that(builtin.CSV.afterFooter(), is(""));
  }
  @Test public void afterHeader4() {
    azzert.that(builtin.CSV.afterHeader(), is(""));
  }
  @Test public void afterTable4() {
    azzert.that(builtin.CSV.afterTable(), is(""));
  }
  @Test public void beforeFooter3() {
    azzert.that(builtin.CSV.beforeFooter(), is(""));
  }
  @Test public void beforeHeader2() {
    azzert.that(builtin.CSV.beforeHeader(), is(""));
  }
  @Test public void beforeTable4() {
    azzert.that(builtin.CSV.beforeTable(), is(""));
  }
  @Test public void arraySeparator3() {
    azzert.that(builtin.CSV.arraySeparator(), is("; "));
  }
  @Test public void cellArray() {
    @NotNull String[] strings = new @NotNull String[2];
    strings[0] = "Hello";
    strings[1] = "Bye";
    azzert.that(builtin.CSV.cellArray(strings), is("Hello; Bye"));
  }
  @Test public void extension() {
    azzert.that(builtin.CSV.extension(), is("csv"));
  }
  @Test public void footerBegin() {
    azzert.that(builtin.CSV.footerBegin(), is(""));
  }
  @Test public void footerEnd2() {
    azzert.that(builtin.TXT.footerEnd(), is(NL));
  }
  @Test public void footerSeparator() {
    azzert.that(builtin.CSV.footerSeparator(), is(","));
  }
  @Test public void headerLineBegin() {
    azzert.that(builtin.CSV.headerLineBegin(), is(""));
  }
  @Test public void headerLineEnd() {
    azzert.that(builtin.CSV.headerLineEnd(), is(NL));
  }
  @Test public void headerSeperator() {
    azzert.that(builtin.CSV.headerSeparator(), is(","));
  }
  @Test public void nil2() {
    azzert.that(builtin.CSV.nil(), is("Nº"));
  }
  @Test public void renderRow() {
    String[] strings = {"Hi", "Bye"};
    ArrayList<Object> list = new ArrayList<>();
    list.add("Hello");
    list.add("Bye");
    azzert.that(builtin.CSV.renderRow(list), is("Hello,Bye"+NL));
    list = new ArrayList<>();
    list.add(box(1));
    list.add(box(2));
    azzert.that(builtin.CSV.renderRow(list), is("1,2"+NL));
    list = new ArrayList<>();
    list.add(box((long)1));
    list.add(box((long)2));
    azzert.that(builtin.CSV.renderRow(list), is("1,2"+NL));
    list = new ArrayList<>();
    list.add(box((double)1));
    list.add(box((double)2));
    azzert.that(builtin.CSV.renderRow(list), is("1,2"+NL));
    list = new ArrayList<>();
    list.add(strings);
    azzert.that(builtin.CSV.renderRow(list), is("Hi; Bye"+NL));
  }
  @Test public void stringField() {
    azzert.that(builtin.CSV.stringField("Hi"), is("Hi"));
  }
  @Test public void   recordSeparator5() {
    Mock.MOCK.setHeaderCount(0);
    azzert.that(Mock.MOCK.recordSeparator(), is("\t"));
  }
}
