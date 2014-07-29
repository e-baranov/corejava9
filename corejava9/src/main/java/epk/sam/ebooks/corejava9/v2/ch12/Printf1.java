package epk.sam.ebooks.corejava9.v2.ch12;

/**
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf1
{
   public static native int print(int width, int precision, double x);

   static
   {
      System.loadLibrary("Printf1");
   }
}
