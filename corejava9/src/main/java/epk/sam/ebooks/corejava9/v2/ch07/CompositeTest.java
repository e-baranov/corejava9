package epk.sam.ebooks.corejava9.v2.ch07;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the Porter-Duff composition rules.
 * @version 1.03 2007-08-16
 * @author Cay Horstmann
 */
public class CompositeTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new CompositeTestFrame();
               frame.setTitle("CompositeTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

