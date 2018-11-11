package fluent.ly;

import java.util.*;
//import java.util.stream.*;

public class range {

  public static DidTo numbers=  range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
  
  boolean empty = false;
  int from = -1;
  int to = -1;
  boolean infinite = false;
  int delta = 1;

  public int from() {
    return from;
  }

  public static DidFrom from(int i) {
    return new range() {
      {
        from = i;
        empty = false;
        infinite= true;
      }
    }. new DidFrom();
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isInfinite() {
    // TODO Auto-generated method stub
    return infinite;
  }


  abstract class RangeIter<T extends RangeIter<T>> implements Iterable<Integer> {

    @Override public Iterator<Integer> iterator() {
      // TODO Auto-generated method stub
      return new Iterator<Integer>() {
        int current = from;

        @Override public boolean hasNext() {
//          System.out.println(to);
          return infinite || ( current < to);
        }

        @Override public Integer next() {
          
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = current;
          current+=delta;
          return Integer.valueOf($);
        }
      };
    }
    
    abstract T This();

  }
  
  
  
  public class DidTo extends RangeIter<DidTo>{

    @Override DidTo This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public Integer from() {
      if (to == from) {
          return null;
      }
      return Integer.valueOf(from);
    }

    public DidTo from(int i) {
      int j = to;
      return new DidTo() {
        {
          delta = 1;
          to = j+1;
          from = i;
          empty = false;
          infinite= false;
        }
      };
    }

    public DidTo interset(DidFrom f) {
      // TODO Auto-generated method stub
      int j = to;
      return range.from(f.from()).to(j);
    }

    public boolean includes(int i) {
      // TODO Auto-generated method stub
      return (i < to && i >= from);
    }
  }
    
 
  
  public class DidFrom extends RangeIter<DidFrom>{
    public DidTo to(final int t) {
      to = t;
      return new DidTo() {
        {
          infinite = false;
          to = t;
        }
      };
    }
    
    @Override DidFrom This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public int from() {
      // TODO Auto-generated method stub
      return from;
    }
    
  }
  


  static public DidTo to(int i) {
    // TODO Auto-generated method stub
    return new range() {
      {
        from = to = i-1;
        infinite = true;
        delta =-1;
      }
    }. new DidTo();
  }


}
