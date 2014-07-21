package epk.sam.ebooks.corejava9.v1.ch09;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.0 2012-05-05
 * @author Cay Horstmann
 */
public class GroupLayoutTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new FontFrame2();
               frame.setTitle("GroupLayoutTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}