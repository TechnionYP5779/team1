package il.org.spartan.utils;

import java.util.*;

public class RealNumbersPairList implements Iterable<Pair<Double, Double>> {
  public class EOL extends Exception {
    private static final long serialVersionUID = 1L;
    // End of list exception
  }

  private class Node{
    public Node(double d, double e) {
      x = d;
      y = e;
      next = null;
    }
    double x;
    double y;
    Node next;
  }
  
  public class ListIterator implements Iterator<Pair<Double, Double>> {
    Node iter;
    
    ListIterator(Node node){
      iter = node;
    }
    
    @Override public boolean hasNext() {
      return iter != null;
    }

    @Override public Pair<Double, Double> next() {
      if(iter == null) return null;
      Pair<Double, Double> p = new Pair<>(Double.valueOf(iter.x), Double.valueOf(iter.y));
      iter = iter.next;
      return p;
    }
    
  }
  
  Node head;
  Node iterator;
  int size;
  
  RealNumbersPairList(){
    head = null;
    iterator = null;
    size = 0;
  }
  
  public void record(double x, double y) {
    Node ins = new Node(x, y);
    Node cur = head;
    if(cur == null) {
      head = ins;
      size = 1;
      return;
    }
    if(cur.x > x) {
      ins.next = cur;
      head = ins;
      size++;
      return;
    }
    while(cur.next != null && cur.next.x < x) {
        cur = cur.next;
    }
    ins.next = cur.next;
    cur.next = ins;
    size++;
  }
  
  public int size() {
    return size;
  }
  
  public Pair<Double, Double> getFirst() {
    if(head == null) return null;
    iterator = head;
    return new Pair<>(Double.valueOf(head.x), Double.valueOf(head.y));
  }
  
  public Pair<Double, Double> getNext() throws EOL {
    if(iterator == null) throw new EOL();
    iterator = iterator.next;
    if(iterator == null) return null;
    return new Pair<>(Double.valueOf(iterator.x), Double.valueOf(iterator.y));
  }
  
  @Override public Iterator<Pair<Double, Double>> iterator() {
    return new ListIterator(head);
  }
}
