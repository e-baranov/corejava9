package epk.sam.ebooks.corejava9.v1.ch09;

import javax.swing.*;

/**
 * A frame that shows buttons arranged along a circle.
 */
public class CircleLayoutFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -7337339101815460799L;

public CircleLayoutFrame()
   {
      setLayout(new CircleLayout());
      add(new JButton("Yellow"));
      add(new JButton("Blue"));
      add(new JButton("Red"));
      add(new JButton("Green"));
      add(new JButton("Orange"));
      add(new JButton("Fuchsia"));
      add(new JButton("Indigo"));
      pack();
   }
}
