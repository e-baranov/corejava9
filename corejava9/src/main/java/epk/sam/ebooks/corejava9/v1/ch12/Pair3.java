package epk.sam.ebooks.corejava9.v1.ch12;

/**
 * @version 1.00 2004-05-10
 * @author Cay Horstmann
 */
public class Pair3<T> 
{
   private T first;
   private T second;

   public Pair3() { first = null; second = null; }
   public Pair3(T first, T second) { this.first = first;  this.second = second; }

   public T getFirst() { return first; }
   public T getSecond() { return second; }

   public void setFirst(T newValue) { first = newValue; }
   public void setSecond(T newValue) { second = newValue; }
}
