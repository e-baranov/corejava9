package epk.sam.ebooks.corejava9.v1.ch08;

import javax.swing.*;

/**
 * A frame containing a panel for testing mouse operations
 */
public class MouseFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 7278899827996999640L;

public MouseFrame()
   {
      add(new MouseComponent());
      pack();
   }
}