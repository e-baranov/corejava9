package epk.sam.ebooks.corejava9.v1.ch10;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.23 2012-05-14
 * @author Cay Horstmann
 */
public class NotHelloWorld extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7747528847943147120L;

	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JLabel label = new JLabel("Not a Hello, World applet",
						SwingConstants.CENTER);
				add(label);
			}
		});
	}
}