package epk.sam.ebooks.corejava9.v1.ch12;

/**
 * @version 1.00 2004-05-10
 * @author Cay Horstmann
 */
public class Pair2<T> 
{
   private T first;
   private T second;

   public Pair2() { first = null; second = null; }
   public Pair2(T first, T second) { this.first = first;  this.second = second; }

   public T getFirst() { return first; }
   public T getSecond() { return second; }

   public void setFirst(T newValue) { first = newValue; }
   public void setSecond(T newValue) { second = newValue; }
}
