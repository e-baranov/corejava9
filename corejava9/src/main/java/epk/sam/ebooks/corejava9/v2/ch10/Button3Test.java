package epk.sam.ebooks.corejava9.v2.ch10;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
public class Button3Test
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {

               ButtonFrame3 frame = new ButtonFrame3();
               frame.setTitle("ButtonTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}