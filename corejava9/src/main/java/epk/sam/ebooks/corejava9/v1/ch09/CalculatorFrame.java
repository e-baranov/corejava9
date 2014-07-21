package epk.sam.ebooks.corejava9.v1.ch09;

import javax.swing.*;

/**
 * A frame with a calculator panel.
 */
public class CalculatorFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 7726482993816394215L;

public CalculatorFrame()
   {
      add(new CalculatorPanel());
      pack();
   }
}
