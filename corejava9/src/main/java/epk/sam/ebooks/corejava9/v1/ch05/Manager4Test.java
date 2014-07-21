package epk.sam.ebooks.corejava9.v1.ch05;



/**
 * This program demonstrates inheritance.
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 */
public class Manager4Test
{
   public static void main(String[] args)
   {
      // construct a Manager object
      Manager4 boss = new Manager4("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee4[] staff = new Employee4[3];

      // fill the staff array with Manager and Employee objects

      staff[0] = boss;
      staff[1] = new Employee4("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee4("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee objects
      for (Employee4 e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
   }
}