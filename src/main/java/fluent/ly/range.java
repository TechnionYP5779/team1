package fluent.ly;

import java.util.*;
//import java.util.stream.*;

public class range {

  boolean empty = false;
  int from = -1;
  boolean infinite = false;

  public static range from(int i) {
    // TODO Auto-generated method stub
    return new range() {
      {
        from = i;
        empty = false;
        infinite= true;
      }
    };
  }

  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return empty;
  }

  public boolean isInfinite() {
    // TODO Auto-generated method stub
    return infinite;
  }


  static class RangeIterator<Self extends RangeIterator<Self>> implements Iterable<Integer> {

    @Override public Iterator<Integer> iterator() {
      // TODO Auto-generated method stub
      return null;
    }

  }


  public Iterable<Integer> to(int to) {
    return new Iterable<>() {

      @Override public Iterator<Integer> iterator() {
        return new Iterator<>() {
          int current = from;

          @Override
          public boolean hasNext() {
            // validate if there is a next object
            return current < to;
          }

          @Override
          public Integer next() {
            // get the next object and return it, throw an exception if there is no next object
            return Integer.valueOf(current++);
          }
        };
      }
    };


  }

  public int from() {
    return from;
  }


}
