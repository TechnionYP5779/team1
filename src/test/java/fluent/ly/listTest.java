package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "static-access" })public class listTest {
  
  @Test  public void penultimateTest() {
    @Nullable List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    azzert.assertEquals(list.penultimate(x), Integer.valueOf(4));
  }
  
  @Test  public void appendprependTest() {
    @Nullable List<@Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable List<@Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    @Nullable List<@Nullable Integer> yy = new ArrayList<>();
    yy.add(Integer.valueOf(4));
    azzert.assertEquals(list.prepend(Integer.valueOf(4)).to(y), x);
    azzert.assertEquals(list.append(Integer.valueOf(5)).to(yy), x);
    azzert.assertEquals(list.append(Integer.valueOf(5)).to().to(yy), x); 
    
  }
}
