package epk.sam.ebooks.corejava9.v1.ch05;

public abstract class Person
{
   public abstract String getDescription();
   private String name;

   public Person(String n)
   {
      name = n;
   }

   public String getName()
   {
      return name;
   }
}
