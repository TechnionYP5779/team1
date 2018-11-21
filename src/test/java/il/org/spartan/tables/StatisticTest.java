package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method")
public class StatisticTest {
  RealStatistics m = new RealStatistics().record(1).record(2).record(3);
  // ===================================================================
  @Test public void ofNTest(){
    azzert.that(Statistic.N.of(m), is(3.0));
    
  }
  
  //===================================================================
  @Test public void toStringNATest(){
    azzert.that(Statistic.NA + "", is("N/A"));
  }
  
  @Test public void ofNATest() {
    azzert.that(Statistic.NA.of(m), is(0.0));
  }
  
  //===================================================================
  @Test public void meanofTest(){
    azzert.that(Statistic.mean.of(m), is(2.0));
  }
  
  //===================================================================
  @Test public void sigmaofTest() {
    azzert.that(Statistic.σ.of(m), is(0.8164965809277263));
  }
  
  //===================================================================
  @Test public void medianofTest() {
    azzert.that(Statistic.median.of(m), is(2.0));
  }
  
  //===================================================================
  @Test public void madofTest() {
    azzert.that(Statistic.MAD.of(m), is(1.0));
  }
  
  @Test public void madtoStringTest() {
    azzert.that(Statistic.MAD + "", is("M.A.D"));
  }
  
  //===================================================================
  @Test public void minofTest() {
    azzert.that(Statistic.min.of(m), is(1.0));
  }
  
  //===================================================================
  @Test public void maxofTest() {
    azzert.that(Statistic.max.of(m),is(3.0));
  }
  
  //===================================================================
  @Test public void rangeofTest() {
    azzert.that(Statistic.range.of(m), is(2.0));
  }
  
  //===================================================================
  @Test public void sumofTest() {
    azzert.that(Statistic.Σ.of(m), is(6.0));
  }
  
  //===================================================================
  @Test public void Q1ofTest() {
    azzert.that(Statistic.Q1.of(m), is(1.0));
  }
  
  //===================================================================
  @Test public void Q3ofTest() {
    azzert.that(Statistic.Q3.of(m), is(3.0));
  }

}
